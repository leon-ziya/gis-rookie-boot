package cn.edu.lnnu.gis.rookie.modules.middleware.websocket.entity;

import lombok.Data;

/**
 * @author leon
 * @ClassName VehiclePosition.java
 * @createTime 2020年10月20日 11:23:00
 */
@Data
public class VehiclePosition {
    private String driverId;
    private String orderId;
    private Long timeStamp;
    private Double longitude;
    private Double latitude;
}
