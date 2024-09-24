package com.ruoyi.project.propwise.service;

import java.util.List;
import com.ruoyi.project.propwise.domain.PwProperty;

/**
 * 房源信息Service接口
 * 
 * @author jin
 * @date 2024-09-24
 */
public interface IPwPropertyService 
{
    /**
     * 查询房源信息
     * 
     * @param propertyId 房源信息主键
     * @return 房源信息
     */
    public PwProperty selectPwPropertyByPropertyId(Long propertyId);

    /**
     * 查询房源信息列表
     * 
     * @param pwProperty 房源信息
     * @return 房源信息集合
     */
    public List<PwProperty> selectPwPropertyList(PwProperty pwProperty);

    /**
     * 新增房源信息
     * 
     * @param pwProperty 房源信息
     * @return 结果
     */
    public int insertPwProperty(PwProperty pwProperty);

    /**
     * 修改房源信息
     * 
     * @param pwProperty 房源信息
     * @return 结果
     */
    public int updatePwProperty(PwProperty pwProperty);

    /**
     * 批量删除房源信息
     * 
     * @param propertyIds 需要删除的房源信息主键集合
     * @return 结果
     */
    public int deletePwPropertyByPropertyIds(Long[] propertyIds);

    /**
     * 删除房源信息信息
     * 
     * @param propertyId 房源信息主键
     * @return 结果
     */
    public int deletePwPropertyByPropertyId(Long propertyId);
}
