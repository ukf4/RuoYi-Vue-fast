package com.ruoyi.project.propwise.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.propwise.domain.PwUserProperty;
import com.ruoyi.project.propwise.service.IPwUserPropertyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户房源收藏Controller
 * 
 * @author jin
 * @date 2024-09-24
 */

@Api("用户收藏房源管理")
@RestController
@RequestMapping("/propwise/userProperty")
public class PwUserPropertyController extends BaseController
{
    @Autowired
    private IPwUserPropertyService pwUserPropertyService;

    /**
     * 查询用户房源收藏列表
     */
    @ApiOperation("查询用户房源收藏列表")
    @PreAuthorize("@ss.hasPermi('propwise:userProperty:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwUserProperty pwUserProperty)
    {
        startPage();
        List<PwUserProperty> list = pwUserPropertyService.selectPwUserPropertyList(pwUserProperty);
        return getDataTable(list);
    }

    /**
     * 导出用户房源收藏列表
     */
    @PreAuthorize("@ss.hasPermi('propwise:userProperty:export')")
    @Log(title = "用户房源收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwUserProperty pwUserProperty)
    {
        List<PwUserProperty> list = pwUserPropertyService.selectPwUserPropertyList(pwUserProperty);
        ExcelUtil<PwUserProperty> util = new ExcelUtil<PwUserProperty>(PwUserProperty.class);
        util.exportExcel(response, list, "用户房源收藏数据");
    }

    /**
     * 获取用户房源收藏详细信息
     */
    @ApiOperation("获取用户房源收藏详细信息")
    @PreAuthorize("@ss.hasPermi('propwise:userProperty:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pwUserPropertyService.selectPwUserPropertyById(id));
    }

    /**
     * 新增用户房源收藏
     */
    @ApiOperation("新增-用户房源")
    @PreAuthorize("@ss.hasPermi('propwise:userProperty:add')")
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
    @ApiOperation("修改-用户房源信息")
    @PreAuthorize("@ss.hasPermi('propwise:userProperty:edit')")
    @Log(title = "用户房源收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwUserProperty pwUserProperty)
    {
        return toAjax(pwUserPropertyService.updatePwUserProperty(pwUserProperty));
    }

    /**
     * 删除用户房源收藏
     */
    @ApiOperation("删除-用户房源信息")
    @PreAuthorize("@ss.hasPermi('propwise:userProperty:remove')")
    @Log(title = "用户房源收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pwUserPropertyService.deletePwUserPropertyByIds(ids));
    }
}
