import java.util.LinkedList;
import java.util.Iterator;
import java.util.Queue;

// directed graph using adjacency list
class Graph{
    private int V;
    private LinkedList<Integer>[] adj;
    @SuppressWarnings("unchecked")
    Graph(int V){
        this.V = V;
        adj = new LinkedList[this.V];   // "unchecked" warning => use List of List next time
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int u, int v){
        adj[u].add(v);
    }

    void BFS(int s){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> itr = adj[s].listIterator();
            while(itr.hasNext()){
                int n = itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
        System.out.println();
    }

}

class Main{
    // Driver method
    public static void main(String args[]){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");

        g.BFS(2);
    }
}
