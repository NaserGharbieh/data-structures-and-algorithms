package graph;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class GraphTest {

    @Test
    void testAddVertex() {
        Graph<String> graph = new Graph<>(1);
        Vertex<String> vertex = graph.addVertex("A");

        assertNotNull(vertex);
        assertEquals("A", vertex.value);
        assertEquals(1, graph.size());
    }

    @Test
    void testAddEdge() {
        Graph<String> graph = new Graph<>(2);
        Vertex<String> vertexA = graph.addVertex("A");
        Vertex<String> vertexB = graph.addVertex("B");

        graph.addEdge(vertexA, vertexB, 5);

        LinkedList<Edge<String>> neighbors = graph.getNeighbors(vertexA);
        assertEquals(1, neighbors.size());

        Edge<String> edge = neighbors.get(0);
        assertEquals(vertexB, edge.destination);
        assertEquals(5, edge.weight);
    }

    @Test
    void testGetVertices() {
        Graph<Integer> graph = new Graph<>(3);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        LinkedList<Vertex<Integer>> vertices = graph.getVertices();

        assertEquals(3, vertices.size());
        assertTrue(vertices.contains(new Vertex<>(1)));
        assertTrue(vertices.contains(new Vertex<>(2)));
        assertTrue(vertices.contains(new Vertex<>(3)));
    }

    @Test
    void testGetNeighbors() {
        Graph<Character> graph = new Graph<>(10);
        Vertex<Character> vertexA = graph.addVertex('A');
        Vertex<Character> vertexB = graph.addVertex('B');
        Vertex<Character> vertexC = graph.addVertex('C');

        graph.addEdge(vertexA, vertexB, 3);
        graph.addEdge(vertexA, vertexC, 7);

        LinkedList<Edge<Character>> neighborsA = graph.getNeighbors(vertexA);
        assertEquals(2, neighborsA.size());

        Edge<Character> edgeAB = neighborsA.get(0);
        assertEquals(vertexB, edgeAB.destination);
        assertEquals(3, edgeAB.weight);

        Edge<Character> edgeAC = neighborsA.get(1);
        assertEquals(vertexC, edgeAC.destination);
        assertEquals(7, edgeAC.weight);
    }

    @Test
    void testSize() {
        Graph<String> graph = new Graph<>(0);
        assertEquals(0, graph.size());

        graph.addVertex("A");
        graph.addVertex("B");
        assertEquals(2, graph.size());

        graph.addEdge(graph.getVertices().get(0), graph.getVertices().get(1));
        assertEquals(2, graph.size());
    }

    @Test
    void testGraphWithOneVertexAndEdge() {
        Graph<String> graph = new Graph<>(1);
        Vertex<String> vertexA = graph.addVertex("A");
        graph.addEdge(vertexA, vertexA, 10);

        assertEquals(1, graph.size());

        LinkedList<Edge<String>> neighborsA = graph.getNeighbors(vertexA);
        assertEquals(1, neighborsA.size());

        Edge<String> edgeAA = neighborsA.get(0);
        assertEquals(vertexA, edgeAA.destination);
        assertEquals(10, edgeAA.weight);
    }
}
