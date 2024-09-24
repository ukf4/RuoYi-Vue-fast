package com.ruoyi.project.propwise.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.propwise.mapper.PwPropertyMapper;
import com.ruoyi.project.propwise.domain.PwProperty;
import com.ruoyi.project.propwise.service.IPwPropertyService;

/**
 * 房源信息Service业务层处理
 * 
 * @author jin
 * @date 2024-09-24
 */
@Service
public class PwPropertyServiceImpl implements IPwPropertyService 
{
    @Autowired
    private PwPropertyMapper pwPropertyMapper;

    /**
     * 查询房源信息
     * 
     * @param propertyId 房源信息主键
     * @return 房源信息
     */
    @Override
    public PwProperty selectPwPropertyByPropertyId(Long propertyId)
    {
        return pwPropertyMapper.selectPwPropertyByPropertyId(propertyId);
    }

    /**
     * 查询房源信息列表
     * 
     * @param pwProperty 房源信息
     * @return 房源信息
     */
    @Override
    public List<PwProperty> selectPwPropertyList(PwProperty pwProperty)
    {
        return pwPropertyMapper.selectPwPropertyList(pwProperty);
    }

    /**
     * 新增房源信息
     * 
     * @param pwProperty 房源信息
     * @return 结果
     */
    @Override
    public int insertPwProperty(PwProperty pwProperty)
    {
        pwProperty.setCreateTime(DateUtils.getNowDate());
        return pwPropertyMapper.insertPwProperty(pwProperty);
    }

    /**
     * 修改房源信息
     * 
     * @param pwProperty 房源信息
     * @return 结果
     */
    @Override
    public int updatePwProperty(PwProperty pwProperty)
    {
        pwProperty.setUpdateTime(DateUtils.getNowDate());
        return pwPropertyMapper.updatePwProperty(pwProperty);
    }

    /**
     * 批量删除房源信息
     * 
     * @param propertyIds 需要删除的房源信息主键
     * @return 结果
     */
    @Override
    public int deletePwPropertyByPropertyIds(Long[] propertyIds)
    {
        return pwPropertyMapper.deletePwPropertyByPropertyIds(propertyIds);
    }

    /**
     * 删除房源信息信息
     * 
     * @param propertyId 房源信息主键
     * @return 结果
     */
    @Override
    public int deletePwPropertyByPropertyId(Long propertyId)
    {
        return pwPropertyMapper.deletePwPropertyByPropertyId(propertyId);
    }
}
