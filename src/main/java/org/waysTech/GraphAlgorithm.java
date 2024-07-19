package org.waysTech;

import java.util.*;

class GraphAlgorithm {
    private int numVertices;
    private LinkedList<Edge>[] adjacencyList;

    class Edge {
        int targetVertex;
        int weight;
        Edge(int targetVertex, int weight) {
            this.targetVertex = targetVertex;
            this.weight = weight;
        }
    }

    public GraphAlgorithm(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int targetVertex, int weight) {
        adjacencyList[sourceVertex].add(new Edge(targetVertex, weight));
        adjacencyList[targetVertex].add(new Edge(sourceVertex, weight)); // For undirected graph
    }

    public void dijkstra(int startVertex) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(numVertices, Comparator.comparingInt(edge -> edge.weight));
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        priorityQueue.add(new Edge(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            int currentVertex = currentEdge.targetVertex;

            for (Edge neighborEdge : adjacencyList[currentVertex]) {
                int newDist = distances[currentVertex] + neighborEdge.weight;
                if (newDist < distances[neighborEdge.targetVertex]) {
                    distances[neighborEdge.targetVertex] = newDist;
                    priorityQueue.add(new Edge(neighborEdge.targetVertex, newDist));
                }
            }
        }

        printSolution(distances);
    }

    public void printSolution(int[] distances) {
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    public static void main(String[] args) {
        GraphAlgorithm graph = new GraphAlgorithm(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 5, 6);
        graph.dijkstra(0);
    }
}
