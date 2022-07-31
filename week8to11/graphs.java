package week8to11;
import week1.SingelyLinkedList;

// return adjNode in array of any vertex(v) like node 2==ktm
public class graphs {
     int vertices;
     int matrix[][];
     String [] nodeName;

     graphs() {
          matrix = new int[vertices][vertices];
     }
     void setVertices(int vertices){
          this.vertices=vertices;
          nodeName=new String[vertices];
          for(int i=0;i<vertices;i++){
               nodeName[i]="House"+i;
          }
     }
     int getVertices(){
          return vertices;
     }
     void setNodeName(int indx, String a){
          nodeName[indx]=a;
     }
     String getNodeName(int a){
          return nodeName[a];
     }
     public void addEdge(int source, int destination, int weight) {
          matrix[source][destination] = weight;
          matrix[destination][source] = weight;
     }

     public void printAdjVertices() { // matrix[0].length for column length
          for (int i = 0; i < vertices; i++) {
               System.out.print(nodeName[i] + " is connected to: ");
               for (int j = 0; j < vertices; j++) {
                    if (matrix[i][j] != 0) {
                         System.out.print(nodeName[j] + ", ");
                    }
               }
               System.out.println(" ");
          }
     }

     public SingelyLinkedList getAdjNodes(int i) {
          SingelyLinkedList ll = new SingelyLinkedList();
          for (int j = 0; j < vertices; j++) {
               if (matrix[i][j] != 0) {
                    ll.addNode(j);
               }
          }
          ll.printList();
          return ll;
     }

     public void dijakstra(int source, int destination) {
          int[] distance = new int[vertices];
          boolean[] visited = new boolean[vertices];
          int[] prevPath = new int[vertices];

          for (int i = 0; i < distance.length; i++) {
               distance[i] = Integer.MAX_VALUE;
               prevPath[i] = -1;
          }
          // distance from source to source is 0
          distance[source] = 0;

          for (int r = 0; r < vertices; r++) {
               // find minimum vertex among unvisited vertices
               int u = -1;
               for (int i = 0; i < distance.length; i++) {
                    if (u == -1 && !visited[i]) {
                         u = i;
                    } else if (distance[0] > distance[i] && !visited[i]) {
                         u = i;
                    }
               }
               visited[u] = true;

               // get Adjacent nodes of u
               for (int v = 0; v < vertices; v++) {
                    if (matrix[u][v] != 0 & !visited[v]) {
                         int newDistance = distance[u] + matrix[u][v];
                         if (newDistance < distance[v]) {
                              distance[v] = newDistance;
                              prevPath[v] = u;
                         }
                    }
               }
          }
          int d = destination;
          System.out.println("distance from source '" + source + "' to destination '" + destination + "' is:- "
                    + distance[destination]);

          // finding the shortest path
          int cout = 0;
          stack0 s = new stack0(vertices);
          while (destination != -1) {
               s.push(destination);
               cout++;
               destination = prevPath[destination];
          }
          System.out.print("Shortest path from " + source + " to " + d + " is:-  ");
          while (cout != 0) {
               System.out.print(s.pop() + "  ");
               cout--;
          }
          System.out.println();
     }

     public void bellman(int source, int destination) {
          int distance[] = new int[vertices];
          int prevPath[] = new int[vertices];
          int cycle = 0;
          for (int i = 0; i < vertices; i++) {
               distance[i] = Integer.MAX_VALUE;
               prevPath[i] = -1;
          }
          distance[source] = 0;
          for (int i = 0; i < vertices; i++) {
               for (int j = 0; j < vertices; j++) {
                    if (matrix[i][j] != 0) {
                         int newDistance = distance[i] + matrix[i][j];
                         if (newDistance < distance[j]) {
                              if (cycle == vertices) {
                                   System.out.println("Cycle detected");
                                   return;
                              }
                              distance[j] = newDistance;
                              prevPath[j] = i;
                              cycle++;
                         }
                    }
               }
          }
          System.out.println("distance from '" + source + "' to '" + destination + "' is:- " + distance[destination]);
     }

     public void ModifiedBFS(int source, int destination) {
          boolean visited[] = new boolean[vertices];
          int distance[] = new int[vertices];
          int prevPath[] = new int[vertices];
          queueExample q = new queueExample(vertices);

          for (int i = 0; i < vertices; i++) {
               distance[i] = Integer.MAX_VALUE;
               prevPath[i] = -1;
          }
          q.enq(source);
          visited[source] = true;
          distance[source] = 0;
          while (!q.isEmpty()) {
               int u = q.deq();
               for (int i = 0; i < vertices; i++) {
                    if (matrix[u][i] != 0 && !visited[i]) {
                         int v = i;
                         distance[u] = distance[u] + 1;
                         if (distance[u] < distance[v]) {
                              distance[v] = distance[u];
                              prevPath[v] = i;
                         }
                         q.enq(v);
                         visited[v] = true;
                    }
               }
          }
          System.out.println(
                    "distance from '" + source + "' to '" + destination + "' is:- " + distance[destination]);
     }

     public static void main(String[] args) {
          graphs g = new graphs();
          g.setVertices(3);
     }
}
