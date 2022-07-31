import java.util.Arrays;

public class week3 {
    class Edge implements Comparable<Edge>{
        int src, dest, weight;
        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };

    // A class to represent a subset for union-find
    static class subset{
        int parent, rank;
    };

    int vertex, edges; // V-> number of vertices & E->number of edges
    Edge edge[]; // collection of all edges

    // Creates a graph with vertices and edges
    week3(int v, int e){
        vertex = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset[] subsets, int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent
                    = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset[] subsets, int x, int y){
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST(){
        // This will store the result MST
        Edge result[] = new Edge[vertex];

        int e = 0;

        int i = 0;
        for (i = 0; i < vertex; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset[] subsets = new subset[vertex];
        for (i = 0; i < vertex; ++i)
            subsets[i] = new subset();


        for (int v = 0; v < vertex; ++v){
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        // Number of edges to be taken is equal to -1 vertex
        while (e < vertex - 1){
            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }

        int minimumCost = 0;
        for (i = 0; i < e; ++i){
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost to construct road connecting all the houses is " + minimumCost);
    }

    // Driver Code
    public static void main(String[] args){
        int V = 6; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        week3 graph = new week3(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 4;

        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 9;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 4;

        graph.edge[3].src = 3;
        graph.edge[3].dest = 4;
        graph.edge[3].weight = 3;

        graph.edge[4].src = 4;
        graph.edge[4].dest = 5;
        graph.edge[4].weight = 4;

        graph.KruskalMST();
    }
}