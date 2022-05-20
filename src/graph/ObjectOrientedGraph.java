package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObjectOrientedGraph {

    private class Vertex {
        private String label;
        private Set<Edge> connectedEdges;

        public Vertex() {
        }

        public Vertex(String label) {
            this.label = label;
            this.connectedEdges = new HashSet<>();
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Set<Edge> getConnectedEdge() {
            return connectedEdges;
        }

        public void setConnectedEdge(Set<Edge> connectedEdge) {
            this.connectedEdges = connectedEdge;
        }

        boolean addEdge(Edge edge){
            return connectedEdges.add(edge);
        }
    }


    private class Edge {
        Vertex vertexTo;
        int weight;

        public Edge() {
        }

        public Edge(Vertex vertexTo, int weight) {
            this.vertexTo = vertexTo;
            this.weight = weight;
        }

        public Vertex getVertexTo() {
            return vertexTo;
        }

        public void setVertexTo(Vertex vertexTo) {
            this.vertexTo = vertexTo;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }


    private class Graph {
        Set<Vertex> vertices;

        public Graph() {
            vertices = new HashSet<>();
        }

        List<Vertex> getVertices() {
            return new ArrayList<>(vertices);
        }


        boolean addVertex(Vertex vertex){
            return vertices.add(vertex);
        }
    }


    @Test
    public void createGraph() {
        Graph graph = new Graph();

        //construct vertices
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        //to make the graph un directed use the same weight
        //both ways
        v1.addEdge(new Edge(v2, 1)); //connect v1 v2
        v2.addEdge(new Edge(v1, 1));

        v2.addEdge(new Edge(v3, 2)); //connect v2 v3
        v3.addEdge(new Edge(v2, 2));

        v2.addEdge(new Edge(v4, 3)); //connect v2 v4
        v4.addEdge(new Edge(v2, 3));

        v4.addEdge(new Edge(v5, 1)); //connect v4 v5
        v5.addEdge(new Edge(v4, 1));

        graph.addVertex(v1); graph.addVertex(v2); graph.addVertex(v3);
        graph.addVertex(v4); graph.addVertex(v5);
    }
}
