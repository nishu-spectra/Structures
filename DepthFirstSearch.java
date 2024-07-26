package Structures;
import java.util.Stack;

class DFS_Stack
{
	int adjacencyMatrix[][];
	int numVertices;
    //constructor for initialization
	DFS_Stack(int[][]  adjacencyMatrix)
	{
		this.adjacencyMatrix= adjacencyMatrix;
		this.numVertices = adjacencyMatrix.length;
	}
    //method to perform depth first search
	void dfs(int sourceVertex)
	{
		boolean visited[]= new boolean[numVertices];
    	Stack<Integer> stack = new Stack<>();
    	stack.push(sourceVertex);
    	while(stack.isEmpty()==false)
    	{
    		sourceVertex=stack.pop();
    		visited[sourceVertex]=true;
    		System.out.print(sourceVertex+" ");
    		for(int i=0;i<numVertices;i++)
    		{
    			if(adjacencyMatrix[sourceVertex][i]==1 && visited[i]==false)
    			{
    				stack.push(i);
    				visited[i]=true;
    			}
    		}
    	}
	}
}
public class DepthFirstSearch {
    public static void main(String[] args) {
        int adjacencyMatrix[][]= 
		    {{0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0}};
	    DFS_Stack d = new DFS_Stack(adjacencyMatrix);
        System.out.print("DFS_Stack traversal for the graph is: ");
        d.dfs(3);
    }
    
}
