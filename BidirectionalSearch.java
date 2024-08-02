package Structures;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class BiDS {
    int graph[][];
    int numNodes;
    BiDS(int graph[][]){
        this.graph = graph;
        this.numNodes= graph.length;
    }

    void BDS (int sourceNode, int goalNode)
    {
        //queues to keep the track of current nodes
        Queue<Integer> frontQueue = new  LinkedList<Integer>();
        Queue<Integer> backQueue = new  LinkedList<Integer>();

        //sets to record the visited nodes
        Set<Integer> frontVisiter = new HashSet<>();
        Set<Integer> backVisiter = new HashSet<>();

        //maps to keep the track of path
        Map<Integer, Integer> frontParent = new HashMap<>();
        Map<Integer, Integer> backParent = new HashMap<>();
        
        frontQueue.add(sourceNode);
        frontVisiter.add(sourceNode);
        frontParent.put(sourceNode, null);

        backQueue.add(goalNode);
        backVisiter.add(goalNode);
        backParent.put(goalNode, null);

        while(!frontQueue.isEmpty()  && !backQueue.isEmpty())
        {
            sourceNode = frontQueue.poll();
            goalNode = backQueue.poll();
            for(int i=0;i<numNodes;i++)
            {
                if(graph[sourceNode][i]==1 && !frontVisiter.contains(i))
                {
                    frontQueue.add(i);
                    frontVisiter.add(i);
                    frontParent.put(i,sourceNode);
                    if(backVisiter.contains(i))
                    {
                        pathPrinter(i,frontParent, backParent);
                        return;
                    }
                    
                }
                if(graph[goalNode][i]==1 && !backVisiter.contains(i))
                {
                    backQueue.add(i);
                    backVisiter.add(i);
                    backParent.put(i,goalNode);
                    if(frontVisiter.contains(i))
                    {
                        pathPrinter(i,frontParent, backParent);
                        return;
                    }
                }
            }

        }
        System.out.println("No path found between "+frontParent+ "and"+backParent);

    }

    void pathPrinter (int meetingPoint, Map<Integer,Integer> frontParent,Map<Integer,Integer> backParent)
    {
        List<Integer> path = new LinkedList<>();

        // Trace the path from the meeting point back to the source node
        Integer node = meetingPoint;
        while (node != null) {
            path.add(0, node);  // Add to the front of the list
            node = frontParent.get(node);
        }

        // Trace the path from the meeting point to the goal node
        node = backParent.get(meetingPoint);
        while (node != null) {
            path.add(node);  // Add to the back of the list
            node = backParent.get(node);
        }

        // Print the path in the required format
        System.out.print("Bidirectional graph traversal path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

public class BidirectionalSearch {
    public static void main(String[] args) {
        int graph[][] = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0}
        };
        BiDS bds = new BiDS(graph);
       bds.BDS(0,5);
        
    }
    
}
