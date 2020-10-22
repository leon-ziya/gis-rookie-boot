package cn.edu.lnnu.gis.rookie.common.constant;

/**
 * 业务常量
 */
public interface BusinessConstant {

	/**
	 * 正常状态
	 */
	public static final Integer STATUS_NORMAL = 0;

	/**
	 * 禁用状态
	 */
	public static final Integer STATUS_DISABLE = -1;

	/**
	 * Websocket主题：交通主体的实时位置 vehiclePosition
	 */
	String WEBSOCKET_TOPIC_POSITION_VEHICLE_POSITION = "VehiclePosition";


}
