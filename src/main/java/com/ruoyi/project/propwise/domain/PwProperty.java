package com.ruoyi.project.propwise.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 房源信息对象 pw_property
 * 
 * @author jin
 * @date 2024-09-24
 */
public class PwProperty extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房产ID，主键，自增 */
    private Long propertyId;

    /** 房产标题 */
    @Excel(name = "房产标题")
    private String title;

    /** 房产描述 */
    @Excel(name = "房产描述")
    private String description;

    /** 房产价格 */
    @Excel(name = "房产价格")
    private BigDecimal price;

    /** 房产地址 */
    @Excel(name = "房产地址")
    private String address;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private String postalCode;

    /** 国家（默认UK） */
    @Excel(name = "国家", readConverterExp = "默=认UK")
    private String country;

    /** 区域 */
    @Excel(name = "区域")
    private String region;

    /** 卧室数量 */
    @Excel(name = "卧室数量")
    private Long bedrooms;

    /** 卫生间数量 */
    @Excel(name = "卫生间数量")
    private Long bathrooms;

    /** 花园面积（平方米） */
    @Excel(name = "花园面积", readConverterExp = "平=方米")
    private BigDecimal gardenSize;

    /** 房产类型（独立屋、联排别墅、公寓等） */
    @Excel(name = "房产类型", readConverterExp = "独=立屋、联排别墅、公寓等")
    private String propertyType;

    /** 建造年份 */
    @Excel(name = "建造年份")
    private String buildYear;

    /** 建筑面积（平方英尺） */
    @Excel(name = "建筑面积", readConverterExp = "平=方英尺")
    private BigDecimal squareFeet;

    /** 建筑面积（平方米） */
    @Excel(name = "建筑面积", readConverterExp = "平=方米")
    private BigDecimal squareMeters;

    /** 楼层数量 */
    @Excel(name = "楼层数量")
    private Long floors;

    /** 停车位数量 */
    @Excel(name = "停车位数量")
    private Long parkingSpaces;

    /** 能源评级（如A、B、C等） */
    @Excel(name = "能源评级", readConverterExp = "如=A、B、C等")
    private String energyRating;

    /** 上市日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上市日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date listedDate;

    /** 是否可用（1代表可用，0代表不可用） */
    @Excel(name = "是否可用", readConverterExp = "1=代表可用，0代表不可用")
    private String isAvailable;

    /** 状态（0启用 1停用） */
    @Excel(name = "状态", readConverterExp = "0=启用,1=停用")
    private String status;

    /** 信息来源网站名称 */
    @Excel(name = "信息来源网站名称")
    private String sourceWebsite;

    /** 来源网站中的房产唯一编号 */
    @Excel(name = "来源网站中的房产唯一编号")
    private String sourceId;

    /** 来源网址URL */
    @Excel(name = "来源网址URL")
    private String sourceUrl;

    /** 挂牌时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "挂牌时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date listingDate;

    /** 数据采集时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "数据采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dataCollectedAt;

    /** 数据更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "数据更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dataUpdatedAt;

    /** 负责房产的中介联系电话 */
    @Excel(name = "负责房产的中介联系电话")
    private String agentPhone;

    /** 负责房产的中介邮件 */
    @Excel(name = "负责房产的中介邮件")
    private String agentEmail;

    /** 负责房产的中介名称 */
    @Excel(name = "负责房产的中介名称")
    private String agentName;

    public void setPropertyId(Long propertyId) 
    {
        this.propertyId = propertyId;
    }

    public Long getPropertyId() 
    {
        return propertyId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setPostalCode(String postalCode) 
    {
        this.postalCode = postalCode;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setBedrooms(Long bedrooms) 
    {
        this.bedrooms = bedrooms;
    }

    public Long getBedrooms() 
    {
        return bedrooms;
    }
    public void setBathrooms(Long bathrooms) 
    {
        this.bathrooms = bathrooms;
    }

    public Long getBathrooms() 
    {
        return bathrooms;
    }
    public void setGardenSize(BigDecimal gardenSize) 
    {
        this.gardenSize = gardenSize;
    }

    public BigDecimal getGardenSize() 
    {
        return gardenSize;
    }
    public void setPropertyType(String propertyType) 
    {
        this.propertyType = propertyType;
    }

    public String getPropertyType() 
    {
        return propertyType;
    }
    public void setBuildYear(String buildYear) 
    {
        this.buildYear = buildYear;
    }

    public String getBuildYear() 
    {
        return buildYear;
    }
    public void setSquareFeet(BigDecimal squareFeet) 
    {
        this.squareFeet = squareFeet;
    }

    public BigDecimal getSquareFeet() 
    {
        return squareFeet;
    }
    public void setSquareMeters(BigDecimal squareMeters) 
    {
        this.squareMeters = squareMeters;
    }

    public BigDecimal getSquareMeters() 
    {
        return squareMeters;
    }
    public void setFloors(Long floors) 
    {
        this.floors = floors;
    }

    public Long getFloors() 
    {
        return floors;
    }
    public void setParkingSpaces(Long parkingSpaces) 
    {
        this.parkingSpaces = parkingSpaces;
    }

    public Long getParkingSpaces() 
    {
        return parkingSpaces;
    }
    public void setEnergyRating(String energyRating) 
    {
        this.energyRating = energyRating;
    }

    public String getEnergyRating() 
    {
        return energyRating;
    }
    public void setListedDate(Date listedDate) 
    {
        this.listedDate = listedDate;
    }

    public Date getListedDate() 
    {
        return listedDate;
    }
    public void setIsAvailable(String isAvailable) 
    {
        this.isAvailable = isAvailable;
    }

    public String getIsAvailable() 
    {
        return isAvailable;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSourceWebsite(String sourceWebsite) 
    {
        this.sourceWebsite = sourceWebsite;
    }

    public String getSourceWebsite() 
    {
        return sourceWebsite;
    }
    public void setSourceId(String sourceId) 
    {
        this.sourceId = sourceId;
    }

    public String getSourceId() 
    {
        return sourceId;
    }
    public void setSourceUrl(String sourceUrl) 
    {
        this.sourceUrl = sourceUrl;
    }

    public String getSourceUrl() 
    {
        return sourceUrl;
    }
    public void setListingDate(Date listingDate) 
    {
        this.listingDate = listingDate;
    }

    public Date getListingDate() 
    {
        return listingDate;
    }
    public void setDataCollectedAt(Date dataCollectedAt) 
    {
        this.dataCollectedAt = dataCollectedAt;
    }

    public Date getDataCollectedAt() 
    {
        return dataCollectedAt;
    }
    public void setDataUpdatedAt(Date dataUpdatedAt) 
    {
        this.dataUpdatedAt = dataUpdatedAt;
    }

    public Date getDataUpdatedAt() 
    {
        return dataUpdatedAt;
    }
    public void setAgentPhone(String agentPhone) 
    {
        this.agentPhone = agentPhone;
    }

    public String getAgentPhone() 
    {
        return agentPhone;
    }
    public void setAgentEmail(String agentEmail) 
    {
        this.agentEmail = agentEmail;
    }

    public String getAgentEmail() 
    {
        return agentEmail;
    }
    public void setAgentName(String agentName) 
    {
        this.agentName = agentName;
    }

    public String getAgentName() 
    {
        return agentName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("propertyId", getPropertyId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("price", getPrice())
            .append("address", getAddress())
            .append("city", getCity())
            .append("postalCode", getPostalCode())
            .append("country", getCountry())
            .append("region", getRegion())
            .append("bedrooms", getBedrooms())
            .append("bathrooms", getBathrooms())
            .append("gardenSize", getGardenSize())
            .append("propertyType", getPropertyType())
            .append("buildYear", getBuildYear())
            .append("squareFeet", getSquareFeet())
            .append("squareMeters", getSquareMeters())
            .append("floors", getFloors())
            .append("parkingSpaces", getParkingSpaces())
            .append("energyRating", getEnergyRating())
            .append("listedDate", getListedDate())
            .append("isAvailable", getIsAvailable())
            .append("status", getStatus())
            .append("sourceWebsite", getSourceWebsite())
            .append("sourceId", getSourceId())
            .append("sourceUrl", getSourceUrl())
            .append("listingDate", getListingDate())
            .append("dataCollectedAt", getDataCollectedAt())
            .append("dataUpdatedAt", getDataUpdatedAt())
            .append("agentPhone", getAgentPhone())
            .append("agentEmail", getAgentEmail())
            .append("agentName", getAgentName())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
