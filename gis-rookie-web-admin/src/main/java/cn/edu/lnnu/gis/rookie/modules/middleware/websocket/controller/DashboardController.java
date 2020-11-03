package cn.edu.lnnu.gis.rookie.modules.middleware.websocket.controller;

import cn.edu.lnnu.gis.rookie.common.constant.BusinessConstant;
import cn.edu.lnnu.gis.rookie.common.entity.ClassificationPositions;
import cn.edu.lnnu.gis.rookie.common.entity.ClusterPointList;
import cn.edu.lnnu.gis.rookie.modules.middleware.websocket.entity.Positions;
import cn.edu.lnnu.gis.rookie.modules.middleware.websocket.entity.VehiclePosition;
import cn.edu.lnnu.gis.rookie.modules.middleware.websocket.service.DashboardService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.record.DVALRecord;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.constant.WebsocketConst;
import org.jeecg.common.system.api.ISysBaseAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author leon
 * @ClassName DashboardController.java
 * @createTime 2020年10月20日 11:13:00
 */
@Api(tags = "消息推送")
@RestController
@RequestMapping("/websocket/dashboard")
public class DashboardController {

    @Autowired
    private ISysBaseAPI sysBaseAPI;

    @Autowired
    private DashboardService dashboardService;

    @ApiOperation("实时位置-广播消息")
    @PostMapping("/vehicle/position/")
    public Result<?> sendPositionToAll(@RequestBody Positions positions){
        JSONObject obj = new JSONObject();
        obj.put(WebsocketConst.CMD_TOPIC, BusinessConstant.WEBSOCKET_TOPIC_POSITION_VEHICLE_POSITION);
        obj.put(WebsocketConst.MSG_TXT, positions.getVehiclePositions());
        sysBaseAPI.sendWebSocketBroadcastMsg(obj.toJSONString());

        return Result.ok("实时位置消息投递成功");
    }

    @ApiOperation("聚类数据-广播消息")
    @PostMapping("/vehicle/classification/position/")
    public Result<?> sendClassificationPositionToAll(@RequestBody ClassificationPositions classificationPositions){
        JSONObject obj = new JSONObject();
        obj.put(WebsocketConst.CMD_TOPIC, BusinessConstant.WEBSOCKET_TOPIC_POSITION_VEHICLE_CLASSIFICATION_POSITION);
        ClusterPointList[] clusterPointLists = dashboardService.getClassificationPointList(classificationPositions);
        obj.put(WebsocketConst.MSG_TXT, clusterPointLists);
        sysBaseAPI.sendWebSocketBroadcastMsg(obj.toJSONString());
        System.out.println("=================\n"+obj.toJSONString()+"===================");
        return Result.ok("密度聚类数据投递成功");
    }


}
