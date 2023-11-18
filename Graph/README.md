# Code Challenge 35: Graphs Implementation

## Description of the Challenge

The Graph class in Java represents a directed graph using an adjacency list.

This implementation supports key operations for manipulating vertices and edges in the graph. 

### The class includes the following methods:

- `Graph(int maxNumberOfVertices)`: Initializes the graph with a maximum specified number of vertices and creates an empty adjacency list using a HashMap.

- `addVertex(value)`: Adds a new vertex to the graph with the given value. Initializes an empty list of edges for the new vertex and returns the added vertex.

- `addEdge(start, destination)`: Adds an edge between two vertices with a default weight of 0.

- `addEdge(start, destination, weight)`: Adds an edge between two vertices with the specified weight. Throws an `IllegalArgumentException` if either vertex is not in the graph.

- `getVertices()`: Returns a collection of all vertices in the graph.

- `getNeighbors(vertex)`: Returns a collection of edges connected to the specified vertex. Throws an `IllegalArgumentException` if the vertex is not in the graph.

- `size()`: Returns the total number of vertices in the graph.

- `compareTo(Graph<T> o)`: Overrides the `compareTo` method from the `Comparable` interface. Throws an `UnsupportedOperationException` since comparison is not implemented.

- `toString()`: Returns a string representation of the graph, showing vertices and their connected edges. Note: The order of elements in the output is not guaranteed due to the nature of `HashMap`.

## Class Whiteboard Process
![GraphClassWhiteboard.png](./Graph-README/GraphClassWhiteboard.png)

**This implementation follows good coding practices, provides error handling, and offers a clear string representation for testing and debugging. It serves as a fundamental tool for modeling and manipulating graph structures in Java applications.**
## Whiteboard Process
![CC30-SetHashmapWhiteboard.png](./Hashmap-README/HashmapWhiteborads/CC30-HashmapWhiteboard.png)

**The time complexity of these methods should be O(1) on average.**
 - **except for getting vertices and getting neighbors,** which have linear time complexity in the number of vertices and edges, respectively.

**The overall space complexity is O(V + E), where :**
 - **V is the number of vertices in the graph.**
 - **E is the number of edges connected to the specified vertex.**

## Code

```java
package graph;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph<T extends Comparable<? super T>> implements Comparable<Graph<T>>  // just in case you have Comparable data structures
{
    public HashMap<Vertex<T>, LinkedList<Edge<T>>> adjacencyLists;
    private int numberOfVertices = 0;

    public Graph(int maxNumberOfVertices)
    {
        adjacencyLists = new HashMap<>(maxNumberOfVertices);
    }

    public Vertex<T> addVertex(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        adjacencyLists.put(vertex, new LinkedList<>());
        numberOfVertices++;
        return vertex;
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination) {
        addEdge(start, destination, 0);
    }

    public void addEdge(Vertex<T> start, Vertex<T> destination, int weight) {
        if (!adjacencyLists.containsKey(start) || !adjacencyLists.containsKey(destination)) {
            throw new IllegalArgumentException("Both vertices should already be in the graph");
        }

        Edge<T> edge = new Edge<>(destination, weight);
        LinkedList<Edge<T>> edges = adjacencyLists.get(start);
        edges.add(edge);
    }

    public LinkedList<Vertex<T>> getVertices() {
        return new LinkedList<>(adjacencyLists.keySet());
    }

    public LinkedList<Edge<T>> getNeighbors(Vertex<T> vertex) {
        if (!adjacencyLists.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex not found in the graph");
        }

        return new LinkedList<>(adjacencyLists.get(vertex));
    }

    public int size() {
        return numberOfVertices;
    }

    @Override
    public int compareTo(Graph<T> o) {
        throw new UnsupportedOperationException("Graph does not implement compareTo()");
    }

    @Override
    public String toString() {
        // Good for testing
        // WARNING: Your HashMap does not guarantee ordering!
        // But you can basically rely on it if you add nodes to your graphs in a consistent way

        StringBuilder result = new StringBuilder();
        for (Vertex<T> vertex : adjacencyLists.keySet()) {
            result.append(vertex.value).append(": ");
            for (Edge<T> edge : adjacencyLists.get(vertex)) {
                result.append(edge.destination.value).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}



```


## Testing


```java
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

```