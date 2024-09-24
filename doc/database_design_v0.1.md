
# 数据库设计文档 - V0.1

## 1. 房源信息表 (`pw_property`)

该表用于存储房源的详细信息，涵盖了房产的基本属性、地址、价格、楼层、面积等多个维度。具体字段及其作用说明如下：

| 字段名               | 数据类型         | 默认值          | 描述                                   |
|----------------------|------------------|-----------------|----------------------------------------|
| `property_id`         | bigint(20)       | 无              | 房产ID，主键，自增，唯一标识每个房产。  |
| `title`              | varchar(255)     | 无              | 房产标题，用于简要描述房产。            |
| `description`        | text             | `''`            | 房产描述，详细介绍房产特点。            |
| `price`              | decimal(15, 2)   | 无              | 房产价格，以货币形式存储房产售价。      |
| `address`            | varchar(255)     | `''`            | 房产详细地址。                         |
| `city`               | varchar(100)     | `''`            | 城市名称，房产所在的城市。              |
| `postal_code`        | varchar(10)      | `''`            | 邮政编码，便于准确定位房产。            |
| `country`            | varchar(50)      | `'UK'`          | 国家，默认值为`UK`。                   |
| `region`             | varchar(100)     | `''`            | 房产所在的区域，如伦敦、曼彻斯特等。     |
| `bedrooms`           | int(11)          | `'0'`           | 卧室数量。                             |
| `bathrooms`          | int(11)          | `'0'`           | 卫生间数量。                           |
| `garden_size`        | decimal(10, 2)   | `'0.00'`        | 花园面积，以平方米计算。                 |
| `property_type`      | varchar(50)      | `''`            | 房产类型，如独立屋、联排别墅、公寓等。   |
| `build_year`         | year             | `'0'`           | 建造年份，记录房产的建成年份。           |
| `square_feet`        | decimal(10, 2)   | `'0.00'`        | 建筑面积，以平方英尺计算。               |
| `square_meters`      | decimal(10, 2)   | `'0.00'`        | 建筑面积，以平方米计算。                 |
| `floors`             | int(11)          | `'0'`           | 房产楼层数量。                         |
| `parking_spaces`     | int(11)          | `'0'`           | 停车位数量。                           |
| `energy_rating`      | char(2)          | `''`            | 房产的能源评级，如A、B、C等。            |
| `listed_date`        | date             | `NULL`          | 房产上市日期。                         |
| `is_available`       | char(1)          | `'1'`           | 房产是否可用，`1`表示可用，`0`表示不可用。|
| `status`             | char(1)          | `'0'`           | 房源状态，`0`表示启用，`1`表示停用。    |
| `source_website`     | varchar(100)     | `''`            | 信息来源网站的名称。                    |
| `source_id`          | varchar(100)     | `''`            | 来源网站中房产的唯一编号。               |
| `source_url`         | varchar(255)     | `''`            | 来源网站的网址链接。                    |
| `listing_date`       | date             | `NULL`          | 房产挂牌时间。                         |
| `data_collected_at`  | datetime         | `NULL`          | 数据采集时间，通常用于记录抓取数据的时间。|
| `data_updated_at`    | datetime         | `NULL`          | 数据更新时间。                         |
| `agent_phone`        | varchar(100)     | `''`            | 房产中介的联系电话。                   |
| `agent_email`        | varchar(100)     | `''`            | 房产中介的联系邮件。                   |
| `agent_name`         | varchar(100)     | `''`            | 房产中介的名称。                       |
| `create_by`          | varchar(64)      | `''`            | 记录的创建者。                         |
| `create_time`        | datetime         | `NULL`          | 记录的创建时间。                       |
| `update_by`          | varchar(64)      | `''`            | 记录的更新者。                         |
| `update_time`        | datetime         | `NULL`          | 记录的更新时间。                       |
| `remark`             | varchar(500)     | `''`            | 备注信息。                             |

## 2. 用户常去地址表 (`pw_user_address`)

该表用于存储用户常去的地址，例如公司、学校等。用户可以根据这些地址计算不同房源的通勤时间。

| 字段名               | 数据类型         | 默认值          | 描述                                   |
|----------------------|------------------|-----------------|----------------------------------------|
| `address_id`         | bigint(20)       | 无              | 地址ID，主键，自增。                   |
| `user_id`            | bigint(20)       | 无              | 用户ID，外键关联`pw_profile`表中的用户。|
| `address_name`       | varchar(255)     | 无              | 地址名称，如“公司”、“学校”等。         |
| `address`            | varchar(255)     | 无              | 详细地址。                             |
| `create_by`          | varchar(64)      | `''`            | 记录的创建者。                         |
| `create_time`        | datetime         | `NULL`          | 记录的创建时间。                       |
| `update_by`          | varchar(64)      | `''`            | 记录的更新者。                         |
| `update_time`        | datetime         | `NULL`          | 记录的更新时间。                       |
| `remark`             | varchar(500)     | `''`            | 备注信息。                             |

## 3. 用户房源收藏表 (`pw_user_property`)

该表用于存储用户收藏的房源信息，包含用户的喜好程度、对房源的评价、别名，以及到不同常去地址的通勤时间等信息。

| 字段名               | 数据类型         | 默认值          | 描述                                   |
|----------------------|------------------|-----------------|----------------------------------------|
| `id`                 | bigint(20)       | 无              | 主键ID，自增。                         |
| `user_id`            | bigint(20)       | 无              | 用户ID，外键关联`pw_profile`表中的用户。|
| `property_id`        | bigint(20)       | 无              | 房源ID，外键关联`pw_property`表中的房产。|
| `favorite_level`     | int(11)          | `'0'`           | 用户对房源的喜欢程度，范围1到5。         |
| `review`             | varchar(500)     | `''`            | 用户对房产的评价。                     |
| `alias`              | varchar(255)     | `''`            | 用户对房产的别名或昵称。               |
| `commute_time_car`   | varchar(100)     | `''`            | 用户从房产驾车到常去地址的通勤时间。   |
| `commute_time_bike`  | varchar(100)     | `''`            | 用户从房产骑自行车到常去地址的通勤时间。|
| `commute_time_walk`  | varchar(100)     | `''`            | 用户从房产步行到常去地址的通勤时间。   |
| `commute_time_transit`| varchar(100)    | `''`            | 用户从房产乘坐公共交通到常去地址的通勤时间。|
| `favorite_date`      | datetime         | `CURRENT_TIMESTAMP` | 收藏时间，默认值为当前时间。         |
| `create_by`          | varchar(64)      | `''`            | 记录的创建者。                         |
| `create_time`        | datetime         | `NULL`          | 记录的创建时间。                       |
| `update_by`          | varchar(64)      | `''`            | 记录的更新者。                         |
| `update_time`        | datetime         | `NULL`          | 记录的更新时间。                       |
| `remark`             | varchar(500)     | `''`            | 备注信息。                             |
