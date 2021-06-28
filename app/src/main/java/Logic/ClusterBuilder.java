package Logic;

import lombok.Getter;
import model.Cluster;
import model.ClusterPoint;

import java.util.ArrayList;

@Getter
public class ClusterBuilder {

    private ArrayList<Cluster> clusterResults;

    public ClusterBuilder() {
        clusterResults = new ArrayList<>();
    }

    public ArrayList<Cluster> makeClusters(ArrayList<ClusterPoint> points) {

        Cluster selectedCluster = null;
        Double maxSimilarity = Double.MAX_VALUE;

        for (ClusterPoint pointToClassify: points) {

            for (Cluster currentCluster: clusterResults) {

                ClusterPoint clusterValue = currentCluster.getValue();
                Double similarity = clusterValue.calculateSimilarity(pointToClassify);

                if(similarity < 0.5 && similarity < maxSimilarity) {
                    selectedCluster = currentCluster;
                }

            }

            if(selectedCluster != null) {
                addToCluster(selectedCluster, pointToClassify);
            } else {
                createNewClusterFrom(pointToClassify);
            }

        }
        return clusterResults;
    }

    private void createNewClusterFrom(ClusterPoint pointToClassify) {
        double[] values = pointToClassify.getValues();

        Cluster newCluster = new Cluster(values.length);
        newCluster.addPoint(pointToClassify);

        clusterResults.add(newCluster);
    }

    private void addToCluster(Cluster selectedCluster, ClusterPoint pointToClassify) {
        selectedCluster.addPoint(pointToClassify);
    }

}
