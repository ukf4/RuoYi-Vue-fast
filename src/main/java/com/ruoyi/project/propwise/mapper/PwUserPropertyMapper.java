package com.ruoyi.project.propwise.mapper;

import java.util.List;
import com.ruoyi.project.propwise.domain.PwUserProperty;

/**
 * 用户房源收藏Mapper接口
 * 
 * @author jin
 * @date 2024-09-24
 */
public interface PwUserPropertyMapper 
{
    /**
     * 查询用户房源收藏
     * 
     * @param id 用户房源收藏主键
     * @return 用户房源收藏
     */
    public PwUserProperty selectPwUserPropertyById(Long id);

    /**
     * 查询用户房源收藏列表
     * 
     * @param pwUserProperty 用户房源收藏
     * @return 用户房源收藏集合
     */
    public List<PwUserProperty> selectPwUserPropertyList(PwUserProperty pwUserProperty);

    /**
     * 新增用户房源收藏
     * 
     * @param pwUserProperty 用户房源收藏
     * @return 结果
     */
    public int insertPwUserProperty(PwUserProperty pwUserProperty);

    /**
     * 修改用户房源收藏
     * 
     * @param pwUserProperty 用户房源收藏
     * @return 结果
     */
    public int updatePwUserProperty(PwUserProperty pwUserProperty);

    /**
     * 删除用户房源收藏
     * 
     * @param id 用户房源收藏主键
     * @return 结果
     */
    public int deletePwUserPropertyById(Long id);

    /**
     * 批量删除用户房源收藏
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePwUserPropertyByIds(Long[] ids);
}
