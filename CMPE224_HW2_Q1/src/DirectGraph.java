public class DirectGraph{
	//-----------------------------------------------------
	// Title: DirectGraph class
	// Author: Arda Baran
	// ID: 19172802022
	// Section: 2
	// Assignment: 2 Q 1 
	// Description: This class implements Directed graph data structure. This Directed Graph consists of vertices which are 
	//nodes of this directed graph and edges which connects these vertices to each other directly.The meaning of connection
	//for undirected graph is that when we add edge between two vertices such as if we add edge between
	//vertex 1 and vertex 2 , it bounds vertex 1 to vertex 2 and vertex 2 to vertex 1.But in directed graph,if we add edge 
	//between vertex 1 and vertex 2 , it only bounds vertex 1 to vertex 2,does not bound vertex 2 to vertex 1. 
	//adjacency matrix is implemented as two dimensional array .
	//isConnected(int,int) returns true if first parameter vertex is connected to the second parameter vertex ,else  returns
	//false.indegree(int) returns the number of parent vertices of parameter vertex.
	//outdegree(int) returns the number of of edges emanating from that vertex,sumOfOutDegrees(int) returns
	// the total number of reachable paths from a vertex.
	//For example if our source vertex is 3,we can reach 
	//3 2 5 
	//3 2 6 
	//3 4 5 
	//3 4 7 
	//3 6 0 
	//3 7 2 
	//3 7 4 
	//3 7 8 
	//As we can see,we can reach 8 different path.This method is implemented for EdgeTo array which type is Singly Linked List
	//-----------------------------------------------------
	//fundamental elements of directed graph data structure for this question1 .
	int numOfVertices;
	int numOfEdges;
	int[][]adjMatrix;
	DirectGraph(int numOfVertices){
		//constructor
		
		this.numOfVertices=numOfVertices;
	    this.numOfEdges=numOfEdges;
        this.adjMatrix=new int[numOfVertices][numOfVertices];	    
	
	}
	//getter and setters of number of vertices ,number of edges,and adjancency matrix.
	public int getNumOfVertices() {
		return numOfVertices;
	}
	public void setNumOfVertices(int numOfVertices) {
		this.numOfVertices = numOfVertices;
	}
	public int getNumOfEdges() {
		return numOfEdges;
	}
	public void setNumOfEdges(int numOfEdges) {
		this.numOfEdges = numOfEdges;
	}
	public int[][] getAdjMatrix() {
		return adjMatrix;
	}
	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}
void addEdge(int v1,int v2) {
	      //--------------------------------------------------------
		 // Summary: adds edge from v1 to v2
		 // Precondition: v1 index is an integer and v2 index is an
		 // integer
		 //--------------------------------------------------------
	adjMatrix[v1][v2]=1;
}
boolean isConnected(int v1, int v2) {
	//--------------------------------------------------------
		 // Summary: returns true if v1 has any edges to v2
		 // Precondition: v1 index is an integer and v2 index is an
		 // integer
		 //--------------------------------------------------------
    return (adjMatrix[v1][v2] == 1);
}
int inDegree(int root) {
	//--------------------------------------------------------
		 // Summary: returns the number of edges from any vertex to root vertex
		 // Precondition:vertex which is named as root,is an integer		 
		 //--------------------------------------------------------
	
	int inDegreeOfVertex=0;
	for(int i = 0 ; i<numOfVertices;i++) {
		if(isConnected(i,root)) {
			inDegreeOfVertex ++;
		}
	}
return inDegreeOfVertex;
}
int outDegree(int root) {
	//--------------------------------------------------------
	 // Summary: returns the total number of edges from root to any vertex
	 // Precondition:vertex which is named as root,is an integer		 
	 //--------------------------------------------------------
	int outd=0;
	for(int i = 0 ; i<numOfVertices;i++) {
		if(isConnected(root,i)) {
			outd ++;
		}
	}
return outd;
}	

int sumOfOutDegrees(int root) {
	/* //--------------------------------------------------------
	 // Summary: returns the minimum number of reachable path.This method used to create path slots from root vertex
		//consider starting point is 3 ,outdegree of 3 is 4 ,so in the first step we guraanteed to we have 4 slot.then we look for the neighbor of 3 ,if outdegree of 
	//starting point neighbors's outdegree is greater than 1 , then the number of slots increase,for example 7 is neighbor of 3 and outdegree of 7 is 3 then slot number 
	//increases by 2,also 6 is neighbor of 3 and outdegree of 6 is 1 ,so the slot number is not increases.
	//totally , we have 8 slots.4 slots for neighbor of 3 ,2 slot for outdegree of 7 ,1 slot for 4 and 1 slot for 2 .
	 sum Of Outdegree is for , if all neighbors  of 3 has only outdegree 1 or zero ,sum not increases,if more than one outdegree increases 
	  // Precondition:vertex which is named as root,is an integer		 
	 //-------------------------------------------------------- 
	*/
	
	int sum = 0; // Initialize sum with the outdegree of the root vertex    
    // Iterate over all vertices
    for (int i = 0; i < numOfVertices; i++) {
      
    	//if there is a connection from the root to vertex i or from vertex i to i+1
        if (isConnected(root, i) ) {
            // Add the outdegree of vertex i to the sum
            sum += outDegree(i);
        }
    }
    return sum;//return the number of path slots.
}
}
class QueueArrayImplementation{
	//-----------------------------------------------------
	// Title: Queue Array Implementation class
	// Author: Arda Baran
	// ID: 19172802022
	// Section: 1
	// Assignment: 2 Q 1
	// Description: This class implements queue data structure with array data structure
	//-----------------------------------------------------
	int front,rear,capacity;
	int[]bag;
	QueueArrayImplementation(int capacity){
		this.capacity=capacity;
		this.front=0;
		this.rear=0;
		this.bag=new int[this.capacity];
	}
boolean isEmpty() {
	return (front==0 && rear==0);
}
boolean isFull() {
	return (rear==capacity);
}
 void add(int data) {
	//adds vertex to rear	
	 if(isFull()) {
		return;
	}else {
		bag[rear]=data;
	rear++;
	}
return;
}
 void delete() {
	//deletes vertex based on FIFO.
	 
	 if(isEmpty()) {
		return;
	}

	else {
		for(int i = 0 ;i<rear;i++) {
			bag[i]=bag[i+1];
		}
	if(rear < capacity)
	bag[rear]=0;
	rear--;
	}
return;
}
int peek() {
//returns front element of queue.	
	
	if(isEmpty()) {
		return Integer.MIN_VALUE;
	}
return bag[front];
}
}
class BFS {
	//-----------------------------------------------------
	// Title: BFS class
	// Author: Arda Baran
	// ID: 19172802022
	// Section: 1
	// Assignment: 2 Q 1
	// Description: This class implements BFS algorithm and print all possible paths by step forwarding two legal steps.
	//----------------------------------------------------- 
	List edgeTo[];//instance of SinglyLinkedList array to store possible paths from vertex root,I implemented as array because
	              //there are  sumOfOutDegrees(root) slots so array size must be sumOfDegrees and List can contain at least one
	              //vertex to at most three vertex
	//consider starting point is 3 ,outdegree of 3 is 4 ,so in the first step we guraanteed to we have 4 slot.then we look for the neighbor of 3 ,if outdegree of 
	//starting point neighbors's outdegree is greater than 1 , then the number of slots increase,for example 7 is neighbor of 3 and outdegree of 7 is 3 then slot number 
	//increases by 2,also 6 is neighbor of 3 and outdegree of 6 is 1 ,so the slot number is not increases.
	//totally , we have 8 slots.4 slots for neighbor of 3 ,2 slot for outdegree of 7 ,1 slot for 4 and 1 slot for 2 .
	boolean visited[];//visited array,it is initialized false at the beggining.
	  int root;//source root that we desire to print all possible paths from source root.
	  DirectGraph g;//instance of DirectGraph data structure
	  int adjM[][] ;//two dimensional adjancency matrix array
	  QueueArrayImplementation q;//instance of queue data structure
	  BFS(DirectGraph g, int root) {
	        this.edgeTo = new List[g.sumOfOutDegrees(root)];//edgeTo array capacity is set to size which equals to sumOfOutDegrees
	        this.root = root;//source
	        this.g = g;
	        this.adjM = g.getAdjMatrix();
	        this.visited = new boolean[g.getNumOfVertices()];
	        // Set queue capacity to the number of vertices
	        this.q = new QueueArrayImplementation(g.getNumOfVertices());
	        // Initialize the edgeTo  array
	        for (int i = 0; i <g.sumOfOutDegrees(root); i++) {
	            edgeTo[i] = new List();//number of sum of outdegrees for lists are created with indexes 
//For example , if root is 3 ,according to the txt file 8 empty lists are created
	            edgeTo[i].add(root);
	        //root is added to all slots in the constructor,the slots are look like
	        //3
	        //3
	        //3
	        //3
	        //3
	        //3
	        //3
	        //3
	        }
	    }
	  //getter and setters
	public List[] getEdgeTo() {
		return edgeTo;
	}
	public void setEdgeTo(List[] edgeTo) {
		this.edgeTo = edgeTo;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	void bfs(DirectGraph g, int root) {
		//--------------------------------------------------------
		 // Summary: performs bfs algorithm and adds the all slots neigbors of root,then adds neighborNeighbors
		 // Precondition: g index is a DirectGraph and root index is an
		 // integer
		 //--------------------------------------------------------
		q.add(root); // Enqueue the root
	    addNodesToEdgeToListArrayByTwoStepForwarding(root);//adds the all slots neigbors of root,then adds neighborNeighbors
	    visited[root] = true; // Mark root as visited
	    while (!q.isEmpty()) {
	        root = q.peek(); // Get the front of the queue
	        q.delete(); // Dequeue the current vertex	        
	        // Visit adjacent vertices of the current vertex
	        for (int i = 0; i < g.getNumOfVertices(); i++) {
	            if (g.isConnected(root, i) && !visited[i]) {
	                q.add(i); // Enqueue the adjacent vertex
	                visited[i] = true; // Mark the adjacent vertex as visited                 
	            }	      
	            }
	    }
	}
	void addNodesToEdgeToListArrayByTwoStepForwarding(int root) {
	 //---------------------------------------------------------------- 
	 //Summary:We are looking for all possible road combinations which is limited with two legal steps.
	 // at the beggining ,all slots are like 
	 // 3
	 // 3
	 // 3
	 // 3
	 // 3
	 // 3
	 // 3
	 // 3
	 // Then , neighbors of starting point which is 3 is adding for number of outdegree of neighbors,such as the outdegree of 2 equals 2 which is neighbor of starting point 3.  
	 //2 is added to 2 slots ,outdegree of 4 is 2 which is neighbor of staring point so 4  added to 2 slot,outdegree of 6 is 1 which is neighbor of 3 and 6 added to only 1 slot.  
	 //outdegree of 7 is 3  which is neighbor of 3 and 7 is added to 3 slot.
	 //List Becomes Like this:
	 //3 2
	 //3 2
	 //3 4
	 //3 4
	 //3 6
	 //3 7
	 //3 7
	 //3 7
	 //In the final step, the neighbors of 2 ,4,6 and 7 are added to slots where they belong to.
	 //In the Final step , edgeTo path array becomes like this:
	 //3 2 5
	 //3 2 6
	 //3 4 5
	 //3 4 7
	 //3 6 0
	 //3 7 2
	 //3 7 4
	 //3 7 8
	 //----------------------------------------------------------------- 
	    List rootNeighbors = addNeighbor(root); // Get adjacent vertices of the root
	    int[] rootNeighborsArray = rootNeighbors.getListDatas();//convert list to array 
        int counter=0;//to prevent array bounds of exception error,create counter
	    // Iterate  each adjacent vertex of the root
	    for (int i = 0; i < rootNeighborsArray.length; i++) {
	        int neighborVertex = rootNeighborsArray[i];
	        int outDegreeOfNeighbor = g.outDegree(neighborVertex);//how many slot will have neighbor
	        //such as if outdegree of neigbor is 2 , neighbor will occupy two slots.
	        List neighborNeighbors = addNeighbor(neighborVertex); // Get adjacent vertices of the neighbor
	        int[] neighborNeighborsArray = neighborNeighbors.getListDatas();
	        // Iterate  each adjacent vertex of the neighbor vertex
	        for (int j = 0; j < neighborNeighborsArray.length; j++) {
	            int neighborNeighborVertex = neighborNeighborsArray[j];
                edgeTo[counter].add(neighborVertex);//add neighbor of root to slot
	            edgeTo[counter].add(neighborNeighborVertex);//add neighbor of neighbor to slot
	              counter++;
	        }
	    }
	}
	void printEdgeTo(DirectGraph g,int root) {
	//----------------------------------------	
	//Summary:Prints all two step forward paths from starting point.	
	//----------------------------------------	
	    for(int i = 0 ; i<g.sumOfOutDegrees(root);i++) {
	        edgeTo[i].printList();
	    }
	}
	List addNeighbor(int root) {
	//----------------------------------------	
	//Summary:Adds all neighbors of root to list and returns to List type.	
	//----------------------------------------	
		List n = new List();
		for(int i = 0 ; i<g.getNumOfVertices();i++) {
			if(g.isConnected(root, i)) {
			n.add(i);	
			}
		}
	return n;
	}
    int [] lastElements() {
    	List finalStep=new List();
    	int arr[] = new int [g.sumOfOutDegrees(root)];
    	for(int i = 0 ; i<8;i++) {
			if(g.isConnected(root, i)) {
			arr[i]=edgeTo[i].getLast();	
			}
		}
	return arr;
	}
}
class List{
	//-----------------------------------------------------
	// Title:List class
	// Author: Arda Baran
	// ID: 19172802022
	// Section: 1
	// Assignment: 2 Q 1
	// Description: This class implements Singly Linked List data structure with node.
	//-----------------------------------------------------
	int size;
	Node root;	
List(){	
	this.root=null;
}
int getSize() {
	return size;
}
 void setSize(int size) {
	this.size = size;
}
Node getRoot() {
	return root;
}
 void setRoot(Node root) {
	this.root = root;
}
Node add(Node n,int data) {
//------------------------------
//	Summary:adds data to list recursively
//
//--------------------------------	
	int s = getSize();
	if(n==null) {
		n=new Node(data);
		s=s+1;
		setSize(s); 
	return n;
	}
//recursively adds data.	
n.setNext(add(n.getNext(),data));
return n;
}
void add(int data) {
	root = add(root,data);
}
void printList() {
    Node current = root;
    while (current != null) {
        System.out.print(current.getData() + " ");
        current = current.getNext();
    }
System.out.println("");
}
int[] getListDatas() {
//---------------------------------	
//Summary:converts list to array	
//----------------------------------	
	size=size();
int arr[]=new int[size];
	   Node current = root;
int j = 0;
	    while (current != null) {
	       arr[j]= current.getData();
	        current = current.getNext();
	   j++;
	    }
return arr;
}
public int size() {
	int count = 0 ;
	Node current =root;
while(current!=null) {
	count++;
current = current.getNext();
}
return count ;
}
public Node getLastNode() {
//---------------------------------	
//Summary:returns the last element of the list as type of Node structure.	
//---------------------------------	
	if (root==null) {
		return null;
	}
	if( root.getNext() == null) {
		return root;
	}
	Node current = root ;
	while(current.getNext()!=null ) {
		current=current.getNext();	
}
	return current;

}
int getLast() {
	return getLastNode().getData();//converts Node structure to int type
}
}
class Node{
	//-----------------------------------------------------
	// Title: Node class
	// Author: Arda Baran
	// ID: 19172802022
	// Section: 1
	// Assignment: 2 Q 1
	// Description: This class implements a basic Node Structure for singly linked list , which is implemented in this 
	//program as List class.
	//-----------------------------------------------------
	
	int data;
	Node next;
	Node (int data){
		this.data=data;
	   this.next=null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}         
 

