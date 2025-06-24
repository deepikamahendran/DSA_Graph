import java.util.*;


class GraphOperations
{
    static void printAdjMatrix(int[][] graph,int nodes)
    {
        for(int snode=0;snode<nodes;snode++)
        {
            for(int enode=0;enode<nodes;enode++)
            {
            System.out.print(graph[snode][enode]+" ");
                
            }
        System.out.println();
        }
    }
}
public class Main
{

	public static void main(String[] args) 
	{
	    Scanner s = new Scanner(System.in);
	    System.out.print("Enter the number of nodes in a graph: ");
	    int nodes = s.nextInt();
	    System.out.print("Enter the number of edges in the graph: ");
	    int edges = s.nextInt();
	    System.out.print("is the graph direct? (Yes/No) : ");
	    String directed = s.next();
	    
	    int[][] graph=new int[nodes][nodes];
	    for(int ed=0;ed<edges;ed++)
	    {
	        System.out.printf("Enter the start node , end node, weight of edge node %d: ",ed+1);
	        int snode = s.nextInt();
	        int enode = s.nextInt();
	        int weight = s.nextInt();
	        
	        graph[snode][enode]=weight;
	        if(directed.equals("No"))
	        {
	            graph[enode][snode]=weight;
	        }
	        
	    }
	    System.out.println("The Adjancey Matrix : ");
	        GraphOperations.printAdjMatrix(graph,nodes);
	}
}
