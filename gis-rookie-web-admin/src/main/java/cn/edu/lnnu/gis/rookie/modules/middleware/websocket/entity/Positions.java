package cn.edu.lnnu.gis.rookie.modules.middleware.websocket.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author leon
 * @ClassName Positions.java
 * @createTime 2020年10月21日 10:27:00
 */
@Data
public class Positions {

    private ArrayList<VehiclePosition> vehiclePositions;
}
