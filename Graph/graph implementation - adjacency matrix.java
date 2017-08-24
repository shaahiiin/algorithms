class AdjMatrix{
	int[][] matrix;
	AdjMatrix(int V){
		matrix = new int[V][V];
	}
	void addEdge(int src, int dest){
		matrix[src][dest] = 1;
		matrix[dest][src] = 1;
	}

	boolean isAdjacent(int src, int dest){
		if(matrix[src][dest] == 1)
		    return true;
		return false;
	}

	void printAdjMatrix(){
		for(int i = 0; i < matrix.length; i++){
			System.out.print(i + " >	");
			for(int j = 0; j < matrix.length; j++){
				if(matrix[i][j] == 1)
					System.out.print(j + " -> ");
			}
			System.out.println("null");
		}
		System.out.println();
	}
}

class Main{
	public static void main(String[] args){
		int V = 5;
		AdjMatrix graph = new AdjMatrix(V);
		
		graph.addEdge(0, 1);
	    graph.addEdge(0, 4);
	    graph.addEdge(1, 2);
	    graph.addEdge(1, 3);
	    graph.addEdge(1, 4);
	    graph.addEdge(2, 3);
	    graph.addEdge(3, 4);

	    System.out.println(graph.isAdjacent(2,3));
	    System.out.println(graph.isAdjacent(2,4));
		graph.printAdjMatrix();
	}
}