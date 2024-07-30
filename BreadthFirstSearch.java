package Structures;
import java.util.Queue;
import java.util.LinkedList;
class BFS{
    int adjacencyMatrix[][];
    int numVertices;
    BFS(int adjacencyMatrix[][])
    {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }

    void BFS(int sourceVertex)
    {
        boolean visited[] = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sourceVertex);
        System.out.print("Breadth First Search Traversal is : ");
        while(!queue.isEmpty())
        {
            sourceVertex = queue.poll();
            System.out.print(sourceVertex+" ");
            visited[sourceVertex]= true;
            for(int i=0;i<numVertices; i++)
            {
                if(adjacencyMatrix[sourceVertex][i]==1 && !visited[i])
                {
                    queue.add(i);
                    visited[i]= true;
                }
            }
            
        }
    }

}
public class BreadthFirstSearch {
    public static void main(String [] args)
    {
        int adjacencyMatrix[][]= 
        {{0, 1, 1, 0},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {0, 0, 1, 0}};
        BFS bfs = new BFS(adjacencyMatrix);
        bfs.BFS(3);
    }
    
}
