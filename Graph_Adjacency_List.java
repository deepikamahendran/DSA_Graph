import java.util.*;

class Node {
    int enode;
    int weight;
    Node link;

    Node(int enode, int weight) {
        this.enode = enode;
        this.weight = weight;
        this.link = null;
    }
}

class GraphOperation {
    Node[] list;
    int nodes;

    GraphOperation(int nodes) {
        list = new Node[nodes];
        this.nodes = nodes;
    }

    public static void printAdjacentMatrix(int[][] graph, int nodes) {
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void convertMatrixToList(int[][] graph) {
        for (int snode = 0; snode < nodes; snode++) {
            Node head = null;
            Node tail = null;

            for (int enode = 0; enode < nodes; enode++) {
                if (graph[snode][enode] != 0) {
                    Node newNode = new Node(enode, graph[snode][enode]);
                    if (head == null) {
                        head = newNode;
                        tail = newNode;
                    } else {
                        tail.link = newNode;
                        tail = newNode;
                    }
                }
            }

            list[snode] = head;
        }
    }

    public void printAdjacencyList() {
      
        for (int i = 0; i < nodes; i++) {
            System.out.print(i + " -> ");
            Node temp = list[i];
            while (temp != null) {
                System.out.print("(" + temp.enode + ", weight=" + temp.weight + ") ");
                temp = temp.link;
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int nodes = ip.nextInt();

        System.out.print("Enter number of edges in graph: ");
        int edges = ip.nextInt();

        System.out.print("Is it directed? (y/n): ");
        String directed = ip.next();

        int[][] graph = new int[nodes][nodes];

        for (int ed = 0; ed < edges; ed++) {
            System.out.printf("Enter start node, end node, weight of edge %d: ", ed + 1);
            int snode = ip.nextInt()-1;
            int enode = ip.nextInt()-1;
            int weight = ip.nextInt();

            graph[snode][enode] = weight;

            if (directed.equalsIgnoreCase("n")) {
                graph[enode][snode] = weight;
            }
        }

        GraphOperation.printAdjacentMatrix(graph, nodes);

        GraphOperation gp = new GraphOperation(nodes);
        gp.convertMatrixToList(graph);
        System.out.println("\n Adjacency List: ");
        gp.printAdjacencyList();
    }
}
