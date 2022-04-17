package graph.adjacency_matrix;

import org.junit.Test;

public class AdjacencyMatrixTest {
    @Test
    public void testMatrix() {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(4);
        //adjacencyMatrixGraph.printMatrix();
        adjacencyMatrixGraph.addEdge(0,1);
        adjacencyMatrixGraph.addEdge(2,3);
        adjacencyMatrixGraph.addEdge(3,3);
        adjacencyMatrixGraph.printMatrix();
    }
}
