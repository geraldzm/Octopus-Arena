package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
public class Cluster {

    @Getter
    private ArrayList<ClusterPoint> points;
    private double currentValuesNoNormalized[];
    private double currentValuesNormalized[];

    public Cluster (int values) {
        points = new ArrayList<>(values);
        currentValuesNoNormalized = new double[values];
        currentValuesNormalized = new double[values];
    }

    public void addPoint(ClusterPoint point) {

        points.add(point);

        addToNoNormalized(point.getValues());

        for (int i = 0; i < currentValuesNormalized.length; i++)
            currentValuesNormalized[i] = currentValuesNoNormalized[i] / points.size();

    }

    private void addToNoNormalized(double[] values) {
        
        if(values.length != currentValuesNoNormalized.length) return;

        for (int i = 0; i < currentValuesNoNormalized.length; i++)
            currentValuesNoNormalized[i] += values[i];

    }


    public ClusterPoint getValue() {
        return new ClusterPoint(currentValuesNormalized);
    }
    
}
