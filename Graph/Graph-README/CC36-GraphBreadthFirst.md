# Code Challenge 36: Graph Breadth First Search Implementation

## Description of the Challenge

The Graph class in Java represents a directed graph using an adjacency list.

This implementation supports key operations for manipulating vertices and edges in the graph. 

### The class includes the following methods:

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
    public LinkedList<Vertex<T>> breadthFirst(Vertex<T> start) {
        if (!adjacencyLists.containsKey(start)) {
            throw new IllegalArgumentException("Start vertex not found in the graph");
        }

        LinkedList<Vertex<T>> visitedNodes = new LinkedList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visitedSet = new HashSet<>();

        queue.add(start);
        visitedSet.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();
            visitedNodes.add(currentVertex);

            for (Edge<T> edge : adjacencyLists.get(currentVertex)) {
                Vertex<T> neighbor = edge.destination;
                if (!visitedSet.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedSet.add(neighbor);
                }
            }
        }
        System.out.println("Breadth-First Traversal: " + visitedNodes);

        return visitedNodes;}

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

```