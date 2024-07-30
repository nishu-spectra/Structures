package Structures;
import java.util.Stack;

class IDS {

    class Node {
        int depth;
        int vertex;

        Node(int depth, int vertex) {
            this.depth = depth;
            this.vertex = vertex;
        }
    }

    int[][] adjacencyMatrix;
    int numVertices;

    IDS(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    void ids(int sourceVertex, int maxLimit) {
        for (int limit = 0; limit <= maxLimit; limit++) {
            System.out.print("\nDepth limit: " + limit);
            dpLS(limit, sourceVertex);
        }
    }

    void dpLS(int limit, int sourceNode) {
        Stack<Node> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];
        stack.push(new Node(0, sourceNode)); // Push the source node onto the stack
        System.out.print("\nIDS traversal : ");

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop(); // Pop a node from the stack
            int currentVertex = currentNode.vertex; // Get the vertex of the node
            int currentDepth = currentNode.depth; // Get the depth value of the node

            // Check if the node has been visited
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                System.out.print(currentVertex + " "); // Print the vertex of the node
            }

            // Check for the child nodes of the current node
            if (currentDepth < limit) {
                // Push nodes onto the stack if their depth is less than the depth limit
                for (int i = 0; i < numVertices; i++) {
                    if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                        stack.push(new Node(currentDepth + 1, i));
                    }
                }
            }
        }
    }
}

public class IterativeDeepeningSearch {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}
        };

        IDS ids = new IDS(adjacencyMatrix);
        ids.ids(0, 10);  // Run IDS from source vertex 0 to a maximum depth of 10
    }
}
