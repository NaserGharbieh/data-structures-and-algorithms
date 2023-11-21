package graph;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
public class BreadthFirstTest {
    @Test
    void testBreadthFirstTraversal() {
        // Create a graph
        Graph<String> graph = new Graph<>(10);
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

        // Perform breadth-first traversal starting from A
        LinkedList<Vertex<String>> result = graph.breadthFirst(A);

        // Verify the order of visited nodes
        assertEquals(A, result.get(0));
        assertEquals(B, result.get(1));
        assertEquals(C, result.get(2));
        assertEquals(D, result.get(3));
        assertEquals(E, result.get(4));
    }

    @Test
    void testBreadthFirstTraversalWithSingleNode() {
        // Create a graph
        Graph<Integer> graph = new Graph<>(1);
        Vertex<Integer> singleNode = graph.addVertex(42);

        // Perform breadth-first traversal starting from the single node
        LinkedList<Vertex<Integer>> result = graph.breadthFirst(singleNode);

        // Verify that the result contains only the single node
        assertEquals(1, result.size());
        assertEquals(singleNode, result.getFirst());
    }

    @Test
    void testBreadthFirstTraversalWithDisconnectedGraph() {
        // Create a graph with disconnected components
        Graph<Character> graph = new Graph<>(10);
        Vertex<Character> A = graph.addVertex('A');
        Vertex<Character> B = graph.addVertex('B');
        Vertex<Character> C = graph.addVertex('C');
        Vertex<Character> X = graph.addVertex('X');
        Vertex<Character> Y = graph.addVertex('Y');

        // Add edges within one component
        graph.addEdge(A, B);
        graph.addEdge(B, C);

        // Perform breadth-first traversal starting from X (disconnected component)
        LinkedList<Vertex<Character>> result = graph.breadthFirst(X);

        // Verify that the result contains only the starting node X
        assertEquals(1, result.size());
        assertEquals(X, result.getFirst());
    }
}
