package graph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTraversalTest {

    @Test
    void testBusinessTripPossible() {
        // Create a graph
        Graph<String> flightGraph = new Graph<>(4);
        Vertex<String> cityA = flightGraph.addVertex("A");
        Vertex<String> cityB = flightGraph.addVertex("B");
        Vertex<String> cityC = flightGraph.addVertex("C");

        // Add direct flights
        flightGraph.addEdge(cityA, cityB, 100); // A to B
        flightGraph.addEdge(cityB, cityC, 150); // B to C

        // Perform a business trip
        String[] tripCities = {"A", "B", "C"};
        Integer cost = GraphTraversal.businessTrip(flightGraph, tripCities);

        // Verify the cost
        assertNotNull(cost);
        assertEquals(250, cost);
    }

    @Test
    void testBusinessTripNotPossible() {
        // Create a graph
        Graph<String> flightGraph = new Graph<>(3);
        Vertex<String> cityA = flightGraph.addVertex("A");
        Vertex<String> cityB = flightGraph.addVertex("B");
        Vertex<String> cityC = flightGraph.addVertex("C");

        // Add direct flights
        flightGraph.addEdge(cityA, cityB, 100); // A to B

        // Perform a business trip (missing direct flight from B to C)
        String[] tripCities = {"A", "B", "C"};
        Integer cost = GraphTraversal.businessTrip(flightGraph, tripCities);

        // Verify that the cost is null (trip not possible)
        assertNull(cost);
    }


}
