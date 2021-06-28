package Logic;

import Util.Utility;
import model.Cluster;
import model.ClusterPoint;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class ClusterBuilderTest {

    @Test
    void oneUserTest() {

        ClusterPoint point = new ClusterPoint(new double[] {10.0, 100.0, 2.0, 6.0});

        ArrayList<ClusterPoint> points = new ArrayList<>();
        points.add(point);

        ClusterBuilder bilder = new ClusterBuilder();
        bilder.makeClusters(points);

        ArrayList<Cluster> clusters = bilder.getClusterResults();

        assertTrue(clusters.size() == 1);
        assertTrue(clusters.get(0).getPoints().size() == 1);

        double[] clusterValues = clusters.get(0).getPoints().get(0).getValues();
        for (int i = 0; i < point.getValues().length; i++) {
            assertEquals(point.getValues()[i], clusterValues[i]);
        }

    }


    @Test
    void twoUserTest() {

        ClusterPoint point0 = new ClusterPoint(new double[] {10.0, 150.0, 2.0, 3.0});
        ClusterPoint point1 = new ClusterPoint(new double[] {12.0, 100.0, 2.0, 6.0});

        ArrayList<ClusterPoint> points = new ArrayList<>();
        points.add(point0);
        points.add(point1);

        ClusterBuilder bilder = new ClusterBuilder();
        bilder.makeClusters(points);

        ArrayList<Cluster> clusters = bilder.getClusterResults();

        assertTrue(clusters.size() == 1);
        assertTrue(clusters.get(0).getPoints().size() == 2);

        double[] correctValues = new double[] {11.0, 125.0, 2.0, 4.5};
        double[] clusterValues = clusters.get(0).getValue().getValues();

        for (int i = 0; i < clusters.get(0).getValue().getValues().length; i++) {
            assertEquals(correctValues[i], clusterValues[i]);
        }

    }

    @Test
    void twoDiferentUserTest() {

        ClusterPoint point0 = new ClusterPoint(new double[] {10.0, 200.0, 20.0, 4.0});
        ClusterPoint point1 = new ClusterPoint(new double[] {120.0, 1000.0, 2.0, 1.0});

        ArrayList<ClusterPoint> points = new ArrayList<>();
        points.add(point0);
        points.add(point1);

        ClusterBuilder bilder = new ClusterBuilder();
        bilder.makeClusters(points);

        ArrayList<Cluster> clusters = bilder.getClusterResults();

        assertTrue(clusters.size() == 2);

    }

    @Test
    void manyUsersTest() {

        ArrayList<ClusterPoint> points = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            double w = Utility.random(2, 19);
            double x = Utility.random(10.0,1500.0);
            double y = Utility.random(1,100);
            double z = Utility.random(0,5);
            ClusterPoint point = new ClusterPoint(new double[] { w,x, y,z});
            points.add(point);
        }

        ClusterBuilder builder = new ClusterBuilder();
        builder.makeClusters(points);

        ArrayList<Cluster> clusters = builder.getClusterResults();

        clusters.forEach(c -> {
            System.out.println("\nCluster# ");
            System.out.println("\tPoints: " + c.getPoints().size());
            System.out.println("\tValue: " + c.getValue());
        });

        System.out.println(Arrays.toString(points.get(0).getValues()));
        System.out.println(Arrays.toString(points.get(20).getValues()));
        System.out.println(points.get(0).calculateSimilarity(points.get(20)));
    }

    @Test
    void manyUsersTestNunez() {

        ArrayList<ClusterPoint> points = new ArrayList<>();
        points.add(new ClusterPoint(new double[] {10.0, 100.0, 0, 4.0}));
        points.add(new ClusterPoint(new double[] {18.0, 300.0, 0, 1.0}));
        points.add(new ClusterPoint(new double[] {2.0, 200.0, 3, 4.0}));
        points.add(new ClusterPoint(new double[] {8.0, 500.0, 10, 1.0}));
        points.add(new ClusterPoint(new double[] {10.0, 50.0, 5, 4.0}));
        points.add(new ClusterPoint(new double[] {2, 100.0, 0, 1.0}));
        points.add(new ClusterPoint(new double[] {10.0, 50.0, 5, 4.0}));
        points.add(new ClusterPoint(new double[] {2, 100.0, 0, 1.0}));
        points.add(new ClusterPoint(new double[] {10.0, 50.0, 5, 4.0}));
        points.add(new ClusterPoint(new double[] {2, 1000.0, 0, 1.0}));

        ClusterBuilder builder = new ClusterBuilder();
        builder.makeClusters(points);

        ArrayList<Cluster> clusters = builder.getClusterResults();

        clusters.forEach(c -> {
            System.out.println("\nCluster# ");
            System.out.println("\tPoints: " + c.getPoints().size());
            System.out.println("\tValue: " + Arrays.toString(c.getValue().getValues()) );
        });

    }

}