package cn.edu.lnnu.gis.rookie.modules.device.vehicle.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 自动驾驶车辆
 * @Author: jeecg-boot
 * @Date:   2020-07-16
 * @Version: V1.0
 */
@Data
@TableName("ccu_sys_auto_drived_vehicle")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ccu_sys_auto_drived_vehicle对象", description="自动驾驶车辆")
public class CcuSysAutoDrivedVehicle implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "主键")
    private String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private String sysOrgCode;
	/**车牌*/
	@Excel(name = "车牌", width = 15)
    @ApiModelProperty(value = "车牌")
    private String plateNumber;
	/**所有者ID*/
	@Excel(name = "所有者ID", width = 15)
    @ApiModelProperty(value = "所有者ID")
    private Integer owner;
	/**车辆类型*/
	@Excel(name = "车辆类型", width = 15)
    @ApiModelProperty(value = "车辆类型")
    private String vehicleType;
	/**车辆颜色*/
	@Excel(name = "车辆颜色", width = 15)
    @ApiModelProperty(value = "车辆颜色")
    private String color;
	/**品牌*/
	@Excel(name = "品牌", width = 15)
    @ApiModelProperty(value = "品牌")
    private String brand;
	/**型号*/
	@Excel(name = "型号", width = 15)
    @ApiModelProperty(value = "型号")
    private String productModel;
}
