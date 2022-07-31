package GUI.WaterSupplyDSA.src.main.algo;

public class GraphExe {
    int vertices;
    int matrix[][];
    public GraphExe(int vertices){
        this.vertices = vertices;
        matrix = new int[vertices][vertices];

    }

    public void addEdge(int source, int destination, int weight){
        matrix[source][destination]=weight;
        matrix[destination][source]=weight;

    }

    public void printGraph(){
        //travelling to rows
        for (int i=0;i<vertices;i++){
            //travelling to columns
            for (int j=0;j<vertices;j++){
                //printing values of matrix
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public void dijakstra(int source, int destination){
        int distance[] = new int[vertices];
        int prevpath[] = new int[vertices];
        boolean visited[] = new boolean[vertices];

        //initially updating distance to infinity
        // and updating prevpath to -1
        for(int i =0; i<vertices;i++){
            distance[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;


        }
        // distance from source to source is zero
        distance[source] = 0;

        for(int i =0; i<vertices;i++){}
        //finding minimum vertices i.e vertices having minimum distance
        int u = findMinVertex( distance,visited);
        visited[u] =true;

        //finding adjacent node of u
        for (int j=0;j<vertices;j++){
            if(matrix[u][j]!=0 & !visited[j]){
                int v = j;
                int newdistance = distance[u] + matrix[u][j];
                if(newdistance < distance[v]){
                    distance[v] = newdistance;
                    prevpath[v] = u;
                }
            }

        }

        System.out.println("distance from source : "+source+ "to distination : "+destination + " is : " + distance[destination]);

    }

    public int findMinVertex(int distance[], boolean visited[]){
        int minvertex = -1 ;
        for(int i =0; i<vertices;i++){
            /*if(minvertex == -1 && !visited[i]){minvertex = i;}
            else if (distance[minvertex]>distance[i] && !visited[i]){
                minvertex = i;
            }*/

            if((minvertex ==-1 || distance[minvertex]>distance[i]  ) & !visited[i]){
                minvertex = i;
            }
        }
        return minvertex;
    }
    public void printAdjEdges(){
        //travelling to rows
        for (int i=0;i<vertices;i++){
            System.out.print(i + " connected to: ");
            for (int j=0;j<vertices;j++){
                if(matrix[i][j]!=0){
                    System.out.print(j + ", ");
                }

            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        GraphExe g = new GraphExe(6);
        g.addEdge(0,1,10);
        g.addEdge(0,2,5);
        g.addEdge(0,5,100);
        g.addEdge(1,3,20);
        g.addEdge(1,2,30);
        g.addEdge(2,4,10);
        g.addEdge(3,4,5);
        g.addEdge(3,5,5);
        g.addEdge(4,5,15);
        g.printGraph();
        g.printAdjEdges();
    }
}
