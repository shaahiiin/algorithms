class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
	}
}

class LinkedList{
	Node head;
	LinkedList(){

	}

	void append(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node temp = head;

		while (temp.next != null){
			temp = temp.next;
		}
		temp.next = new Node(data);
	}

	boolean contains(int data){
		if(head == null){
			return false;
		}
		Node temp = head;
		while(temp != null){
			if(temp.data == data){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
}

class AdjList{
	LinkedList[] list;
	AdjList(int V){
		list = new LinkedList[V];
	}
	void addEdge(int src, int dest){
		if(list[src] == null)
			list[src] = new LinkedList();
		if(list[dest] == null)
			list[dest] = new LinkedList();
		list[src].append(dest);
		list[dest].append(src);
	}

	boolean isAdjacent(int src, int dest){
		if(list[src] == null)
			return false;
		if(list[src].contains(dest))
			return true;
        return false;			
	}

	void printAdjList(){
		for(int i = 0; i < list.length; i++){
			if(list[i] == null){
				System.out.println("i => null");
				continue;
			}
			Node temp = list[i].head;

			System.out.print(i + " >   ");
			while(temp != null){
				System.out.print(temp.data + " -> ");
				temp = temp.next;
			}
			System.out.println("null");
		}
		System.out.println();
	}
}

class Main{
	public static void main(String[] args){
		int V = 5;
		AdjList adjList = new AdjList(V);
		
		adjList.addEdge(0, 1);
	    adjList.addEdge(0, 4);
	    adjList.addEdge(1, 2);
	    adjList.addEdge(1, 3);
	    adjList.addEdge(1, 4);
	    adjList.addEdge(2, 3);
	    adjList.addEdge(3, 4);

	    System.out.println(adjList.isAdjacent(2,3));
	    System.out.println(adjList.isAdjacent(2,4));
		adjList.printAdjList();
	}
}