package graph;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphTraversal {

    public static Integer businessTrip(Graph<String> graph, String[] cities) {
        if (cities.length < 2) {
            // A trip with less than two cities is not possible
            return null;
        }

        int totalCost = 0;

        for (int i = 0; i < cities.length - 1; i++) {
            Vertex<String> currentCity = new Vertex<>(cities[i]);
            Vertex<String> nextCity = new Vertex<>(cities[i + 1]);

            if (!graph.adjacencyLists.containsKey(currentCity) || !graph.adjacencyLists.containsKey(nextCity)) {
                // If either current or next city is not in the graph, the trip is not possible
                return null;
            }

            boolean hasDirectFlight = false;

            for (Edge<String> edge : graph.adjacencyLists.get(currentCity)) {
                if (edge.destination.equals(nextCity)) {
                    // Found a direct flight to the next city
                    hasDirectFlight = true;
                    totalCost += edge.weight;
                    break;
                }
            }

            if (!hasDirectFlight) {
                // If there is no direct flight to the next city, the trip is not possible
                return null;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        // Example usage:
        Graph<String> flightGraph = new Graph<>(6);
        Vertex<String> cityA = flightGraph.addVertex("A");
        Vertex<String> cityB = flightGraph.addVertex("B");
        Vertex<String> cityC = flightGraph.addVertex("C");
        Vertex<String> cityD = flightGraph.addVertex("D");

        flightGraph.addEdge(cityA, cityB, 100); // A to B
        flightGraph.addEdge(cityB, cityC, 150); // B to C
        flightGraph.addEdge(cityB, cityD, 200); // B to D

        String[] tripCities = {"A", "B", "C"};

        Integer cost = businessTrip(flightGraph, tripCities);

        if (cost != null) {
            System.out.println("The cost of the trip is: $" + cost);
        } else {
            System.out.println("The trip is not possible.");
        }
    }
}

