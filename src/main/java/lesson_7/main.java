package main.java.lesson_7;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Graph graph =new Graph();
        Vertex v1=new Vertex(1);
        Vertex v2=new Vertex(2);
        Vertex v3=new Vertex(3);
        Vertex v4=new Vertex(4);
        Vertex v5=new Vertex(5);
        Vertex v6=new Vertex(6);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addEdge(v1,v2,5);
        graph.addEdge(v2,v5,10);
        graph.addEdge(v1,v3,3);
        graph.addEdge(v3,v5,2);
        graph.addEdge(v1,v4,1);
        graph.addEdge(v4,v5,3);
        graph.addEdge(v5,v6,10);
        System.out.println(Arrays.toString(graph.Dijkstra(v1,v6)));
    }
}
