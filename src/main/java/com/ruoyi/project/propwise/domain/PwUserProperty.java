package com.ruoyi.project.propwise.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 用户房源收藏对象 pw_user_property
 * 
 * @author jin
 * @date 2024-09-24
 */
public class PwUserProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID，自增 */
    private Long id;

    /** 用户ID，外键关联pw_profile表 */
    @Excel(name = "用户ID，外键关联pw_profile表")
    private Long userId;

    /** 房源ID，外键关联pw_property表 */
    @Excel(name = "房源ID，外键关联pw_property表")
    private Long propertyId;

    /** 喜欢程度（1到5） */
    @Excel(name = "喜欢程度", readConverterExp = "1=到5")
    private Long favoriteLevel;

    /** 用户对房产的评价 */
    @Excel(name = "用户对房产的评价")
    private String review;

    /** 房源的别名或昵称 */
    @Excel(name = "房源的别名或昵称")
    private String alias;

    /** 驾车通勤时间 */
    @Excel(name = "驾车通勤时间")
    private String commuteTimeCar;

    /** 骑车通勤时间 */
    @Excel(name = "骑车通勤时间")
    private String commuteTimeBike;

    /** 步行通勤时间 */
    @Excel(name = "步行通勤时间")
    private String commuteTimeWalk;

    /** 公共交通通勤时间 */
    @Excel(name = "公共交通通勤时间")
    private String commuteTimeTransit;

    /** 收藏时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收藏时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date favoriteDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setPropertyId(Long propertyId) 
    {
        this.propertyId = propertyId;
    }

    public Long getPropertyId() 
    {
        return propertyId;
    }
    public void setFavoriteLevel(Long favoriteLevel) 
    {
        this.favoriteLevel = favoriteLevel;
    }

    public Long getFavoriteLevel() 
    {
        return favoriteLevel;
    }
    public void setReview(String review) 
    {
        this.review = review;
    }

    public String getReview() 
    {
        return review;
    }
    public void setAlias(String alias) 
    {
        this.alias = alias;
    }

    public String getAlias() 
    {
        return alias;
    }
    public void setCommuteTimeCar(String commuteTimeCar) 
    {
        this.commuteTimeCar = commuteTimeCar;
    }

    public String getCommuteTimeCar() 
    {
        return commuteTimeCar;
    }
    public void setCommuteTimeBike(String commuteTimeBike) 
    {
        this.commuteTimeBike = commuteTimeBike;
    }

    public String getCommuteTimeBike() 
    {
        return commuteTimeBike;
    }
    public void setCommuteTimeWalk(String commuteTimeWalk) 
    {
        this.commuteTimeWalk = commuteTimeWalk;
    }

    public String getCommuteTimeWalk() 
    {
        return commuteTimeWalk;
    }
    public void setCommuteTimeTransit(String commuteTimeTransit) 
    {
        this.commuteTimeTransit = commuteTimeTransit;
    }

    public String getCommuteTimeTransit() 
    {
        return commuteTimeTransit;
    }
    public void setFavoriteDate(Date favoriteDate) 
    {
        this.favoriteDate = favoriteDate;
    }

    public Date getFavoriteDate() 
    {
        return favoriteDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("propertyId", getPropertyId())
            .append("favoriteLevel", getFavoriteLevel())
            .append("review", getReview())
            .append("alias", getAlias())
            .append("commuteTimeCar", getCommuteTimeCar())
            .append("commuteTimeBike", getCommuteTimeBike())
            .append("commuteTimeWalk", getCommuteTimeWalk())
            .append("commuteTimeTransit", getCommuteTimeTransit())
            .append("favoriteDate", getFavoriteDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
