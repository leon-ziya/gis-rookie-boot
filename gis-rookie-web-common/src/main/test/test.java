import cn.edu.lnnu.gis.rookie.common.entity.ClusterPointList;
import cn.edu.lnnu.gis.rookie.common.entity.Point2D;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author leon
 * @ClassName test.java
 * @createTime 2020年11月03日 10:47:00
 */
public class test {
    public static void main(String[] args) {
        HashSet<Integer> clusterSet = new HashSet<>();
        clusterSet.add(1);
        clusterSet.add(2);
        clusterSet.add(3);
        ClusterPointList[] clusterPointLists = new ClusterPointList[clusterSet.size()];

        for(int n=0; n< clusterSet.size(); n++){
            clusterPointLists[n] = new ClusterPointList(new ArrayList<Point2D>());
        }
        Point2D point2D = new Point2D();
        point2D.setLongitude(123D);
        point2D.setLatitude(122D);

        for(int i=0; i< clusterPointLists.length; i++){
            clusterPointLists[i].getPoints().add(point2D);
        }
        System.out.println(clusterPointLists[2].toString());
    }
}
