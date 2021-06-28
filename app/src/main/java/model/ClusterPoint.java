package model;

import lombok.Getter;

@Getter
public class ClusterPoint {

    private double values[];
    private double norm;

    public ClusterPoint(double [] values) {
        this.values = values;
        calculateNorm();
    }

    private void calculateNorm() {
        double sum = 0;
        for(double d: values) {
            sum += d * d;
        }

        norm = Math.sqrt(sum);
    }


    public double calculateSimilarity (ClusterPoint oPoint) {
        if(oPoint.values.length != values.length) return -1;

        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i] * oPoint.values[i];
        }

        return(Math.acos(sum/(norm*oPoint.norm)) ) * 180 / 3.141592654;

    }

}
