package com.ruoyi.project.propwise.mapper;

import java.util.List;
import com.ruoyi.project.propwise.domain.PwUserAddress;

/**
 * 用户常去地址Mapper接口
 * 
 * @author jin
 * @date 2024-09-24
 */
public interface PwUserAddressMapper 
{
    /**
     * 查询用户常去地址
     * 
     * @param addressId 用户常去地址主键
     * @return 用户常去地址
     */
    public PwUserAddress selectPwUserAddressByAddressId(Long addressId);

    /**
     * 查询用户常去地址列表
     * 
     * @param pwUserAddress 用户常去地址
     * @return 用户常去地址集合
     */
    public List<PwUserAddress> selectPwUserAddressList(PwUserAddress pwUserAddress);

    /**
     * 新增用户常去地址
     * 
     * @param pwUserAddress 用户常去地址
     * @return 结果
     */
    public int insertPwUserAddress(PwUserAddress pwUserAddress);

    /**
     * 修改用户常去地址
     * 
     * @param pwUserAddress 用户常去地址
     * @return 结果
     */
    public int updatePwUserAddress(PwUserAddress pwUserAddress);

    /**
     * 删除用户常去地址
     * 
     * @param addressId 用户常去地址主键
     * @return 结果
     */
    public int deletePwUserAddressByAddressId(Long addressId);

    /**
     * 批量删除用户常去地址
     * 
     * @param addressIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePwUserAddressByAddressIds(Long[] addressIds);
}
