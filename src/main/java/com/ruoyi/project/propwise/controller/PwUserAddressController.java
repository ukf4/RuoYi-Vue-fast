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
import com.ruoyi.project.propwise.domain.PwUserAddress;
import com.ruoyi.project.propwise.service.IPwUserAddressService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 用户常去地址Controller
 * 
 * @author jin
 * @date 2024-09-24
 */
@RestController
@RequestMapping("/propwise/address")
public class PwUserAddressController extends BaseController
{
    @Autowired
    private IPwUserAddressService pwUserAddressService;

    /**
     * 查询用户常去地址列表
     */
    @PreAuthorize("@ss.hasPermi('propwise:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(PwUserAddress pwUserAddress)
    {
        startPage();
        List<PwUserAddress> list = pwUserAddressService.selectPwUserAddressList(pwUserAddress);
        return getDataTable(list);
    }

    /**
     * 导出用户常去地址列表
     */
    @PreAuthorize("@ss.hasPermi('propwise:address:export')")
    @Log(title = "用户常去地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PwUserAddress pwUserAddress)
    {
        List<PwUserAddress> list = pwUserAddressService.selectPwUserAddressList(pwUserAddress);
        ExcelUtil<PwUserAddress> util = new ExcelUtil<PwUserAddress>(PwUserAddress.class);
        util.exportExcel(response, list, "用户常去地址数据");
    }

    /**
     * 获取用户常去地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('propwise:address:query')")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        return success(pwUserAddressService.selectPwUserAddressByAddressId(addressId));
    }

    /**
     * 新增用户常去地址
     */
    @PreAuthorize("@ss.hasPermi('propwise:address:add')")
    @Log(title = "用户常去地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PwUserAddress pwUserAddress)
    {
        return toAjax(pwUserAddressService.insertPwUserAddress(pwUserAddress));
    }

    /**
     * 修改用户常去地址
     */
    @PreAuthorize("@ss.hasPermi('propwise:address:edit')")
    @Log(title = "用户常去地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PwUserAddress pwUserAddress)
    {
        return toAjax(pwUserAddressService.updatePwUserAddress(pwUserAddress));
    }

    /**
     * 删除用户常去地址
     */
    @PreAuthorize("@ss.hasPermi('propwise:address:remove')")
    @Log(title = "用户常去地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable Long[] addressIds)
    {
        return toAjax(pwUserAddressService.deletePwUserAddressByAddressIds(addressIds));
    }
}
