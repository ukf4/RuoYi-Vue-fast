package com.ruoyi.project.propwise.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.propwise.mapper.PwUserPropertyMapper;
import com.ruoyi.project.propwise.domain.PwUserProperty;
import com.ruoyi.project.propwise.service.IPwUserPropertyService;

/**
 * 用户房源收藏Service业务层处理
 * 
 * @author jin
 * @date 2024-09-24
 */
@Service
public class PwUserPropertyServiceImpl implements IPwUserPropertyService 
{
    @Autowired
    private PwUserPropertyMapper pwUserPropertyMapper;

    /**
     * 查询用户房源收藏
     * 
     * @param id 用户房源收藏主键
     * @return 用户房源收藏
     */
    @Override
    public PwUserProperty selectPwUserPropertyById(Long id)
    {
        return pwUserPropertyMapper.selectPwUserPropertyById(id);
    }

    /**
     * 查询用户房源收藏列表
     * 
     * @param pwUserProperty 用户房源收藏
     * @return 用户房源收藏
     */
    @Override
    public List<PwUserProperty> selectPwUserPropertyList(PwUserProperty pwUserProperty)
    {
        return pwUserPropertyMapper.selectPwUserPropertyList(pwUserProperty);
    }

    /**
     * 新增用户房源收藏
     * 
     * @param pwUserProperty 用户房源收藏
     * @return 结果
     */
    @Override
    public int insertPwUserProperty(PwUserProperty pwUserProperty)
    {
        pwUserProperty.setCreateTime(DateUtils.getNowDate());
        return pwUserPropertyMapper.insertPwUserProperty(pwUserProperty);
    }

    /**
     * 修改用户房源收藏
     * 
     * @param pwUserProperty 用户房源收藏
     * @return 结果
     */
    @Override
    public int updatePwUserProperty(PwUserProperty pwUserProperty)
    {
        pwUserProperty.setUpdateTime(DateUtils.getNowDate());
        return pwUserPropertyMapper.updatePwUserProperty(pwUserProperty);
    }

    /**
     * 批量删除用户房源收藏
     * 
     * @param ids 需要删除的用户房源收藏主键
     * @return 结果
     */
    @Override
    public int deletePwUserPropertyByIds(Long[] ids)
    {
        return pwUserPropertyMapper.deletePwUserPropertyByIds(ids);
    }

    /**
     * 删除用户房源收藏信息
     * 
     * @param id 用户房源收藏主键
     * @return 结果
     */
    @Override
    public int deletePwUserPropertyById(Long id)
    {
        return pwUserPropertyMapper.deletePwUserPropertyById(id);
    }
}
