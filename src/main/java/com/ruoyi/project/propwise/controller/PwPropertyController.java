package com.ruoyi.project.propwise.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.project.propwise.domain.PwProperty;
import com.ruoyi.project.propwise.service.IPwPropertyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 房源信息Controller
 * 
 * @author jin
 * @date 2024-09-24
 */
@RestController
@RequestMapping("/propwise/property")
public class PwPropertyController extends BaseController
{
    @Autowired
    private IPwPropertyService pwPropertyService;

    /**
     * 查询房源信息列表
     */
    @PreAuthorize("@ss.hasPermi('propwise:property:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwProperty pwProperty)
    {
        startPage();
        List<PwProperty> list = pwPropertyService.selectPwPropertyList(pwProperty);
        return getDataTable(list);
    }

    /**
     * 导出房源信息列表
     */
    @PreAuthorize("@ss.hasPermi('propwise:property:export')")
    @Log(title = "房源信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwProperty pwProperty)
    {
        List<PwProperty> list = pwPropertyService.selectPwPropertyList(pwProperty);
        ExcelUtil<PwProperty> util = new ExcelUtil<PwProperty>(PwProperty.class);
        util.exportExcel(response, list, "房源信息数据");
    }

    /**
     * 获取房源信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('propwise:property:query')")
    @GetMapping(value = "/{propertyId}")
    public AjaxResult getInfo(@PathVariable("propertyId") Long propertyId)
    {
        return success(pwPropertyService.selectPwPropertyByPropertyId(propertyId));
    }

    /**
     * 新增房源信息
     */
    @PreAuthorize("@ss.hasPermi('propwise:property:add')")
    @Log(title = "房源信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwProperty pwProperty)
    {
        return toAjax(pwPropertyService.insertPwProperty(pwProperty));
    }

    /**
     * 修改房源信息
     */
    @PreAuthorize("@ss.hasPermi('propwise:property:edit')")
    @Log(title = "房源信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwProperty pwProperty)
    {
        return toAjax(pwPropertyService.updatePwProperty(pwProperty));
    }

    /**
     * 删除房源信息
     */
    @PreAuthorize("@ss.hasPermi('propwise:property:remove')")
    @Log(title = "房源信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{propertyIds}")
    public AjaxResult remove(@PathVariable Long[] propertyIds)
    {
        return toAjax(pwPropertyService.deletePwPropertyByPropertyIds(propertyIds));
    }
}
