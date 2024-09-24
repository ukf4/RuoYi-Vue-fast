package com.ruoyi.project.propwise.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.propwise.mapper.PwUserAddressMapper;
import com.ruoyi.project.propwise.domain.PwUserAddress;
import com.ruoyi.project.propwise.service.IPwUserAddressService;

/**
 * 用户常去地址Service业务层处理
 * 
 * @author jin
 * @date 2024-09-24
 */
@Service
public class PwUserAddressServiceImpl implements IPwUserAddressService 
{
    @Autowired
    private PwUserAddressMapper pwUserAddressMapper;

    /**
     * 查询用户常去地址
     * 
     * @param addressId 用户常去地址主键
     * @return 用户常去地址
     */
    @Override
    public PwUserAddress selectPwUserAddressByAddressId(Long addressId)
    {
        return pwUserAddressMapper.selectPwUserAddressByAddressId(addressId);
    }

    /**
     * 查询用户常去地址列表
     * 
     * @param pwUserAddress 用户常去地址
     * @return 用户常去地址
     */
    @Override
    public List<PwUserAddress> selectPwUserAddressList(PwUserAddress pwUserAddress)
    {
        return pwUserAddressMapper.selectPwUserAddressList(pwUserAddress);
    }

    /**
     * 新增用户常去地址
     * 
     * @param pwUserAddress 用户常去地址
     * @return 结果
     */
    @Override
    public int insertPwUserAddress(PwUserAddress pwUserAddress)
    {
        pwUserAddress.setCreateTime(DateUtils.getNowDate());
        return pwUserAddressMapper.insertPwUserAddress(pwUserAddress);
    }

    /**
     * 修改用户常去地址
     * 
     * @param pwUserAddress 用户常去地址
     * @return 结果
     */
    @Override
    public int updatePwUserAddress(PwUserAddress pwUserAddress)
    {
        pwUserAddress.setUpdateTime(DateUtils.getNowDate());
        return pwUserAddressMapper.updatePwUserAddress(pwUserAddress);
    }

    /**
     * 批量删除用户常去地址
     * 
     * @param addressIds 需要删除的用户常去地址主键
     * @return 结果
     */
    @Override
    public int deletePwUserAddressByAddressIds(Long[] addressIds)
    {
        return pwUserAddressMapper.deletePwUserAddressByAddressIds(addressIds);
    }

    /**
     * 删除用户常去地址信息
     * 
     * @param addressId 用户常去地址主键
     * @return 结果
     */
    @Override
    public int deletePwUserAddressByAddressId(Long addressId)
    {
        return pwUserAddressMapper.deletePwUserAddressByAddressId(addressId);
    }
}
