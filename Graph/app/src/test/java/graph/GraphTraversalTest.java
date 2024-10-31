package graph;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

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


    @Test
    void testDepthFirstTraversal() {
        // Create a graph
        Graph<String> graph = new Graph<>(5);
        Vertex<String> A = graph.addVertex("A");
        Vertex<String> B = graph.addVertex("B");
        Vertex<String> C = graph.addVertex("C");
        Vertex<String> D = graph.addVertex("D");
        Vertex<String> E = graph.addVertex("E");

        // Add edges
        graph.addEdge(A, B);
        graph.addEdge(A, C);
        graph.addEdge(B, D);
        graph.addEdge(C, E);

        // Perform depth-first traversal starting from A
        LinkedList<Vertex<String>> result = graph.depthFirst(A);

        // Verify the order of visited nodes
        assertEquals(A, result.get(0));
        assertTrue(result.contains(B));
        assertTrue(result.contains(C));
        assertTrue(result.contains(D));
        assertTrue(result.contains(E));
    }

    @Test
    void testDepthFirstTraversalWithSingleNode() {
        // Create a graph
        Graph<Integer> graph = new Graph<>(5);
        Vertex<Integer> singleNode = graph.addVertex(42);

        // Perform depth-first traversal starting from the single node
        LinkedList<Vertex<Integer>> result = graph.depthFirst(singleNode);

        // Verify that the result contains only the single node
        assertEquals(1, result.size());
        assertEquals(singleNode, result.getFirst());
    }

    @Test
    void testDepthFirstTraversalWithDisconnectedGraph() {
        // Create a graph with disconnected components
        Graph<Character> graph = new Graph<>(5);
        Vertex<Character> A = graph.addVertex('A');
        Vertex<Character> B = graph.addVertex('B');
        Vertex<Character> C = graph.addVertex('C');
        Vertex<Character> X = graph.addVertex('X');
        Vertex<Character> Y = graph.addVertex('Y');

        // Add edges within one component
        graph.addEdge(A, B);
        graph.addEdge(B, C);

        // Perform depth-first traversal starting from X (disconnected component)
        LinkedList<Vertex<Character>> result = graph.depthFirst(X);

        // Verify that the result contains only the starting node X
        assertEquals(1, result.size());
        assertEquals(X, result.getFirst());
    }


}
