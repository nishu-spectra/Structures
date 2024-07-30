package Structures;
import java.util.Queue;
import java.util.LinkedList;
class BFS{
    int adjacencyMatrix[][];
    int numVertices;
    //constructor for initializing  the graph
    BFS(int adjacencyMatrix[][])
    {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numVertices = adjacencyMatrix.length;
    }
   // method for performing Breadth First Search
    void bfs(int sourceVertex)
    {
        boolean visited[] = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<Integer>(); // initializing queue
        queue.add(sourceVertex); // add the source vertex in the queue
        System.out.print("Breadth First Search Traversal is : ");
        while(!queue.isEmpty())
        {
            sourceVertex = queue.poll(); //remove the fisrt element in the queue
            System.out.print(sourceVertex+" ");
            visited[sourceVertex]= true; //mark the visited vertex as true
            //check for the child nodes of the current visited node
            for(int i=0;i<numVertices; i++)
            {
                if(adjacencyMatrix[sourceVertex][i]==1 && !visited[i])
                {
                    queue.add(i); //add the child nodes in the queue
                    visited[i]= true; //mark the added nodes as true
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
        bfs.bfs(3);
    }
    
}
