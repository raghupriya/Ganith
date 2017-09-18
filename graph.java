package omssrjgd;

// Java program to print DFS traversal from a given given gr
import java.util.*;
 
// This class represents a directed graph using adjacency list
// representation
class graph
{
    private int V;   // No. of vertices
 
    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
   // boolean visited[] = new boolean[V];
 
    @SuppressWarnings("unchecked")
	// Constructor
    graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>();
        
    }
 
    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }
 
    // A function used by DFS
    int DFSUtil(int v,boolean visited[], boolean[] paired)
    {
        // Mark the current node as visited and print it
    	int x;
        visited[v] = true;
        //System.out.print(v+" ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
            {
              x =  DFSUtil(n, visited, paired);
              if(!paired[x] && !paired[v])
              {
            	  paired[x]=true;
            	  paired[v]=true;
            	  System.out.println(v+","+x);
              }
            }
          //return -1;
        }
       return v;
    }
 
    // The function to do DFS traversal. It uses recursive DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
        boolean paired[] = new boolean[V];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited, paired);
        
        for(int i=0; i<visited.length; i++)
        {
        	if(!visited[i])
        		DFSUtil(i, visited, paired);
        }
    }
 
    public static void main(String[] args)
    {
        graph g = new graph(19);
 
        /*g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);*/
        
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(3, 10);
        g.addEdge(10, 3);
        g.addEdge(5, 4);
        g.addEdge(4,5);
        g.addEdge(6, 4);
        g.addEdge(4, 6);
        g.addEdge(5, 7);
        g.addEdge(7, 5);
        g.addEdge(5, 8);
        g.addEdge(8, 5);
        g.addEdge(9, 8);
        g.addEdge(8, 9);
        g.addEdge(11, 12);
        g.addEdge(12, 11);
        g.addEdge(13, 14);
        g.addEdge(14, 13);
        g.addEdge(15, 16);
        g.addEdge(16,  15);
        g.addEdge(17, 16);
        g.addEdge(16, 17);
        g.addEdge(15, 18);
        g.addEdge(18, 15);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(1);
    }
}