package cn.edu.lnnu.gis.rookie.common.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author leon
 * @ClassName ClassificationPointArray.java
 * @createTime 2020年11月02日 20:26:00
 */
@Data
public class ClusterPointList {
    private ArrayList<Point2D> points;

    public ClusterPointList(ArrayList<Point2D> points) {
        this.points = points;
    }
}
