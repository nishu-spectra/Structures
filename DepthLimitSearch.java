package Structures;

import java.util.Stack;

class DPLS {
    class Node {
        int vertex;
        int depth;
        
        Node(int vertex, int depth) {
            this.vertex = vertex;
            this.depth = depth;
        }
    }

    int numNodes;
    int[][] adjacencyMatrix;

    DPLS(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numNodes = adjacencyMatrix.length;   
    }

    void dpLS(int limit, int sourceNode) {
        Stack<Node> stack = new Stack<>();
        boolean[] visited = new boolean[numNodes];
        stack.push(new Node(sourceNode, 0));
        System.out.print("Depth Limit Search traversal: ");
        
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            int currentVertex = currentNode.vertex;
            int currentDepth = currentNode.depth;

            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                System.out.print(currentVertex + " ");
            }

            if (currentDepth < limit) {
                for (int i = 0; i < numNodes; i++) {
                    if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
                        stack.push(new Node(i, currentDepth + 1));
                    }
                }
            }
        }
    }
}

public class DepthLimitSearch {
    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0}
        };
        int limit = 1;
        int sourceNode = 3;
        DPLS dpls = new DPLS(adjacencyMatrix);
        dpls.dpLS(limit, sourceNode);
    }
}
