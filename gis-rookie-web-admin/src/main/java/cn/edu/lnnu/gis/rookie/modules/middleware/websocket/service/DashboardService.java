package cn.edu.lnnu.gis.rookie.modules.middleware.websocket.service;

import cn.edu.lnnu.gis.rookie.common.entity.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author leon
 * @ClassName DashboardService.java
 * @createTime 2020年11月02日 20:31:00
 */
@Service
public class DashboardService {

    public ClusterPointList[] getClassificationPointList(ClassificationPositions classificationPositions){

        ArrayList<ClassificationPoints> classificationPointsArrayList = classificationPositions.getClassificationPointsArrayList();

        HashMap<Integer, Integer> clusterPointMap = new HashMap<>();
        HashSet<Integer> clusterSet = new HashSet<Integer>();

        // 计算数据聚类个数
        for(int i =0; i< classificationPointsArrayList.size(); i++){
            clusterSet.add(classificationPointsArrayList.get(i).getCluster());
        }
        ClusterPointList[] clusterPointLists = new ClusterPointList[clusterSet.size()];
        for(int n=0; n< clusterSet.size(); n++){
            clusterPointLists[n] = new ClusterPointList(new ArrayList<>());
        }
        Object[] clusterArry = clusterSet.toArray();
        for(int k =0; k < classificationPointsArrayList.size(); k++){
            for(int j =0; j < clusterArry.length; j++){
                if(classificationPointsArrayList.get(k).getCluster().equals(clusterArry[j])){
                    Point2D point2D = new Point2D();
                    point2D.setLatitude(classificationPointsArrayList.get(k).getLatitude());
                    point2D.setLongitude(classificationPointsArrayList.get(k).getLongitude());
                    clusterPointLists[j].getPoints().add(point2D);
                }
            }
        }
        System.out.println(clusterArry);
        System.out.println(clusterPointLists.length);
        return clusterPointLists;
    }
}
