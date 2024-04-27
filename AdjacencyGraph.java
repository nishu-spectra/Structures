package Structures;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class UndirectedGraph
{
	int numVertices;
	int adjacencyMatrix[][];
	UndirectedGraph(int numVertices)//constructor
	{
		this.numVertices= numVertices;
		this.adjacencyMatrix= new int[numVertices][numVertices];
	}
	//adds an edge to and from the specified vertices
	void addEdge(int source, int destination)
	{
		adjacencyMatrix[source][destination]= 1;
		adjacencyMatrix[destination][source]=1;
	}
	//adds a new vertex in the graph
	void addVertex()
	{
        int[][] newMatrix = new int[numVertices + 1][numVertices + 1];
        for (int i = 0; i < numVertices; i++) 
        {
            for (int j = 0; j < numVertices; j++)
            {
                newMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }
        adjacencyMatrix = newMatrix;
        numVertices++;
        for (int i = 0; i < numVertices - 1; i++)
        {
            adjacencyMatrix[i][numVertices - 1] = 0; 
            adjacencyMatrix[numVertices - 1][i] = 0; 
        }
    }
	//adds a new vertex in the graph for specified vertex
	void addVertex(int newVertex)
	{
		if(newVertex>=0 && newVertex>=numVertices)
		{
			//checks if there already exists vertex or not
			if(!hasVertex(newVertex))
			{
				int newadjacencyMatrix[][]= new int[numVertices+1][numVertices+1];
				for(int i=0;i<numVertices;i++)
				{
					for(int j=0;j<numVertices;j++)
					{
						newadjacencyMatrix[i][j]= adjacencyMatrix[i][j];
					}
				}
				adjacencyMatrix = newadjacencyMatrix;
				numVertices++;
				for(int i=0;i<numVertices;i++)
				{
					adjacencyMatrix[i][newVertex]=0;
					adjacencyMatrix[newVertex][i]=0;
				}
			}
		}	    
	}
	//checks if the specified vertex is present in graph
	boolean hasVertex(int newVertex)
	{
		if(newVertex>=0 && newVertex<numVertices)
		{
			for(int i=0;i<numVertices;i++)
			{
				if(adjacencyMatrix[i][newVertex]==1 || adjacencyMatrix[newVertex][i]==1)
				{
					return true;
				}
			}
		}
		return false;
	}
	//checks if specified edge is present or not
	boolean hasEdge(int source, int destination)
	{
		if(source<numVertices && destination<numVertices)
		{
			for(int i=0;i<numVertices;i++)
			{
				for(int j=0;j<numVertices;j++)
				{
					if((i==source && j==destination) || (i==destination && j==source))
					{
						if(adjacencyMatrix[i][j]==1 || adjacencyMatrix[j][i]==1)
							return true;
						    break;
					}
				}
			}
		}
		return false;
	}
	//removes the edges to and from the specified vertices
	void removeEdge(int source, int destination)
	{
		adjacencyMatrix[source][destination]=0;
		adjacencyMatrix[destination][source]=0;
	}
	//removes the  specified vertex  from the graph
	void removeVertex(int vertex)
	{
		if(vertex>=0 && vertex<numVertices)
		{
			if(hasVertex(vertex))
			{
				int newadjacencyMatrix[][]= new int[numVertices-1][numVertices-1];
				int row=0;
				int i=0,j=0;
				for(i=0;i<numVertices;i++)
				{
					if(i!=vertex)
					{
						int column=0;
						for(j=0;j<numVertices;j++)
						{
							if(j!=vertex)
							{
								newadjacencyMatrix[row][column]= adjacencyMatrix[i][j];
								column++;
							}
						}
						row++;
					}
				}	
				adjacencyMatrix = newadjacencyMatrix;
				numVertices--;
			}	
		}		
	}
	//returns a list of all the adjacent vertices of the specified vertex
	int[] getNeighbours(int vertex)
	{
		int count=0;
	    for(int i=0;i<numVertices;i++)
	    {
	    	if(adjacencyMatrix[vertex][i]==1)
	    	{
	    		count++;
	    	}
	    }
		int neighbours[]= new int[count];
		int k=0;
		for(int j=0;j<numVertices;j++)
		{
		    if(adjacencyMatrix[vertex][j]==1)
			{
				neighbours[k]= j;
				k++;
			}
		}
		return neighbours;
	}
	//returns the degree of the specified vertex i.e no. of edges of a vertex
	int getDegree(int vertex)
	{
		int count=0;
		for(int i=0;i<numVertices;i++)
	    {
	    	if(adjacencyMatrix[vertex][i]==1)
	    	{
	    		count++;
	    	}
	    }
		return count;
	}
	//returns the size of the graph
	int getGraphSize()
	{
		return numVertices;
	}
	int getEdgeSize()
	{
		int count=0;
		for(int i=0;i<numVertices;i++)
		{
			for(int j=0;j<numVertices;j++)
			{
				if(hasEdge(i,j))
				{
					count++;
				}
			}
		}
		return count/2;
	}
	//returns a list of the vertices of the graph
	int[] getVertices()
	{
		int vertices[]= new int[numVertices];
		for(int i=0;i<numVertices;i++)
		{
			vertices[i]= i;
		}
		return vertices;
	}
	//checks if there is any self loop in the graph
	boolean selfLoop()
	{
		for(int i=0;i<numVertices;i++)
		{
			if(hasEdge(i,i))
			{
				return true;
			}
		}
		return false;
	}
	//returns the number of self loop in the graph
	int selfLoopSize()
	{
		int count=0;
		for(int i=0;i<numVertices;i++)
		{
			if(hasEdge(i,i))
			{
				count++;
			}
		}
		return count;
	}
	//returns a list of edges present in the graph
	int [][] getEdges()
	{
		int count=0;
		for(int i=0;i<numVertices;i++)
		{
			for(int j=0;j<numVertices;j++)
			{
				if(hasEdge(i,j))
				{
					count++;
				}
			}
		}
		int edgeindex=0;
		int edge[][]= new int[count][2];
		for(int i=0;i<numVertices;i++)
		{
			for(int j=0;j<numVertices;j++)
			{
				if(adjacencyMatrix[i][j]==1)
				{
					edge[edgeindex][0]=i;
					edge[edgeindex][1]=j;
					edgeindex++;
				}
			}
		}
		return edge;
	}
	//checks if all the vertices are connected i.e have any path
	public boolean isConnected() 
	{
		boolean visited[] = new boolean[numVertices];
		int sourceVertex=0;
		visited[sourceVertex]=true;
		Queue<Integer> queue = new LinkedList<>();
		int bfstraverse[]= new int[numVertices];
		int index=0;
		queue.offer(sourceVertex);
		while(queue.isEmpty()==false)
		{
			sourceVertex=queue.poll();
			bfstraverse[index]= sourceVertex;
			index++;
			for(int i=0;i<numVertices;i++)
			{
				if(adjacencyMatrix[sourceVertex][i]==1 && visited[i]==false)
				{
					queue.offer(i);
					visited[i]=true;
				}
			}
			
		}
		for(int i=0;i<numVertices;i++)
		{
			if(visited[i]==false)
				return false;
		}
		return true;
    }
	// checks if graph is empty or not i.e no vertex.
	boolean isEmpty()
	{
		if(getGraphSize()==0)
		    return true;
		else
			return false;
	}
	//traverses the vertices in Binary First Serach method
    int[] BFS(int sourceVertex)
	{
		boolean visited[] = new boolean[numVertices];
		visited[sourceVertex]=true;
		Queue<Integer> queue = new LinkedList<Integer>();
		int bfstraverse[]= new int[numVertices];
		int index=0;
		queue.offer(sourceVertex);
		while(queue.isEmpty()==false)
		{
			sourceVertex=queue.poll();
			bfstraverse[index]= sourceVertex;
			index++;
			for(int i=0;i<numVertices;i++)
			{
				if(adjacencyMatrix[sourceVertex][i]==1 && visited[i]==false)
				{
					queue.offer(i);
					visited[i]=true;
				}
			}
		}
		return bfstraverse;
	}
    //traverses all the vertices in Depth-First Search method
    void DFS(int sourceVertex)
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
    			}
    		}
    	}
    }
	//displays the graph in the form of adjacency matrix
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		System.out.println(numVertices);
		for(int i=0;i<numVertices;i++)
		{
			for(int j=0;j<numVertices;j++)
			{
				sb.append(adjacencyMatrix[i][j]+" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
public class AdjacencyGraph {
    public static void main(String []args)
    {
        Scanner obj = new Scanner(System.in);
		UndirectedGraph ug = new UndirectedGraph(4);
		ug.addEdge(0, 1);
		ug.addEdge(1, 2);
		ug.addEdge(3, 0);
		ug.addEdge(3, 2);
		System.out.println(ug);
		ug.addVertex();
		System.out.println(ug);
		ug.addVertex(5);
		System.out.println(ug);
		ug.removeEdge(3,2);
		System.out.println(ug);
		System.out.println("Size of the graph: "+ug.getGraphSize());
		ug.removeVertex(2);
		System.out.println(ug);
		if(ug.hasEdge(0, 2)==true)
		{
			System.out.println("Edge is present.");
		}
		else
		{
			System.out.println("Edge is not present.");
		}
		ug.addEdge(2,3);
		System.out.println(ug);
		int a[]= ug.getNeighbours(3);
		System.out.print("Neighbours of 3 are: ");
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println("\nDegree of vertex(3): "+ug.getDegree(3));
		System.out.println("Size of the graph: "+ug.getGraphSize());
		int vertices[]= ug.getVertices();
		System.out.print("Vertices of the graph: ");
		for(int i=0;i<vertices.length;i++)
		{
			System.out.print(vertices[i]+" ");
		}
		System.out.println("\nNo. of egde: "+ug.getEdgeSize());
		System.out.println("Is there any self lopp in the graph?: "+ug.selfLoop());
		System.out.println("Number of self loop: "+ug.selfLoopSize());
		System.out.println(ug);
		ug.addEdge(3,4);
		System.out.println(ug);
		int edge[][]= ug.getEdges();
		System.out.println("Edges in the graph are: ");
		for(int i=0;i<edge.length;i++)
		{
			System.out.println(edge[i][0]+"---"+edge[i][1]);
		}
		if(ug.isEmpty()==true)
		{
			System.out.println("Graph is empty!");
		}
		else
		{
			System.out.println("Graph is not empty.");
		}
		System.out.print("BFS for source vertex 0 is ");
		int v[] = ug.BFS(0);
		for(int vertex: v)
		{
			System.out.print(vertex+" ");
		}
		if(ug.isConnected()==true)
		{
			System.out.println("\nGraph is connected.");
		}
		else
		{
			System.out.println("\nGraph is not connected.");
		}
		System.out.println("DFS traversal is: ");
		ug.DFS(0);
		obj.close();
    }
    
}
