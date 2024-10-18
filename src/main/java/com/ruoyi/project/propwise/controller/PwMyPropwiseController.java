package com.ruoyi.project.propwise.controller;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.propwise.domain.PwUserProperty;
import com.ruoyi.project.propwise.service.IPwPropertyService;
import com.ruoyi.project.propwise.service.IPwUserPropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * PwMyPropwiseController
 * 操作自己的数据
 * @author jin
 * @date 2024-09-24
 */

@Api("我收藏的房源管理")
@RestController
@RequestMapping("/propwise/myspace")
public class PwMyPropwiseController extends PwUserPropertyController
{
    @Autowired
    private IPwUserPropertyService pwUserPropertyService;
    @Autowired
    private IPwPropertyService pwPropertyService;











    /**
     * 查询我收藏的房源列表
     */
    @ApiOperation("查询我收藏的房源列表")
    @PreAuthorize("@ss.hasPermi('propwise:myProperty:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwUserProperty pwUserProperty)
    {
        // 获取当前用户信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        startPage();
        List<PwUserProperty> list = pwUserPropertyService.selectPwUserPropertyList(pwUserProperty);
        return getDataTable(list);
    }



    /**
     * 获取用户房源收藏详细信息
     */
    @ApiOperation("获取我收藏的房源详细信息")
    @PreAuthorize("@ss.hasPermi('propwise:myProperty:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pwUserPropertyService.selectPwUserPropertyById(id));
    }

    /**
     * 新增用户房源收藏
     */
    @ApiOperation("新增-我收藏的房源")
    @PreAuthorize("@ss.hasPermi('propwise:myProperty:add')")
    @Log(title = "用户房源收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwUserProperty pwUserProperty)
    {
        // TODO 用户收藏房源的操作逻辑
        //  检查房源是否存在，不存在则在 PwProperty 表 中新增一条房源信息，返回房源id
        //  然后在 PwUserProperty 表中新增一条记录，关联房源id 和 用户id
        //  最后返回成功信息









        return toAjax(pwUserPropertyService.insertPwUserProperty(pwUserProperty));
    }

    /**
     * 修改用户房源收藏
     */
    @ApiOperation("修改-我收藏的房源信息")
    @PreAuthorize("@ss.hasPermi('propwise:myProperty:edit')")
    @Log(title = "用户房源收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwUserProperty pwUserProperty)
    {
        return toAjax(pwUserPropertyService.updatePwUserProperty(pwUserProperty));
    }

    /**
     * 删除用户房源收藏
     */
    @ApiOperation("删除-我收藏的房源信息")
    @PreAuthorize("@ss.hasPermi('propwise:myProperty:remove')")
    @Log(title = "我收藏的房源", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pwUserPropertyService.deletePwUserPropertyByIds(ids));
    }
}
