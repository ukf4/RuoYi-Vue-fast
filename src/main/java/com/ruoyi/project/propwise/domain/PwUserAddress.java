package com.ruoyi.project.propwise.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 用户常去地址对象 pw_user_address
 * 
 * @author jin
 * @date 2024-09-24
 */
public class PwUserAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地址ID，主键，自增 */
    private Long addressId;

    /** 用户ID，外键关联pw_profile表 */
    @Excel(name = "用户ID，外键关联pw_profile表")
    private Long userId;

    /** 地址名称（例如：公司、学校等） */
    @Excel(name = "地址名称", readConverterExp = "例=如：公司、学校等")
    private String addressName;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setAddressName(String addressName) 
    {
        this.addressName = addressName;
    }

    public String getAddressName() 
    {
        return addressName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("addressId", getAddressId())
            .append("userId", getUserId())
            .append("addressName", getAddressName())
            .append("address", getAddress())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
