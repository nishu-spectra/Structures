package Structures;

import java.util.Stack;

class DPLS {
    //Node class that contains the value of node and its depth
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
        stack.push(new Node(sourceNode, 0)); //push the source node in the stack
        System.out.print("Depth Limit Search traversal: ");
        
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop(); // pop a node from the stack
            int currentVertex = currentNode.vertex; // get the vertex of the node
            int currentDepth = currentNode.depth; // get the depth value of the node

            //check if the node is already visited or not
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                System.out.print(currentVertex + " "); // print the vertex of the node
            }
            //check for the child nodes of the current visited node 
            if (currentDepth < limit) {
                //push the nodes having depth less than the depth-limit
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
        DPLS dpls = new DPLS(adjacencyMatrix); //creation of object of DPLS class
        dpls.dpLS(limit, sourceNode); // callig the method 
    }
}
