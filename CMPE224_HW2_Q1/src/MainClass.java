
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		DirectGraph graph = new DirectGraph(10);
	        graph.addEdge(0, 1);
	        graph.addEdge(0, 9);
	        graph.addEdge(1, 3);
	        graph.addEdge(2, 5);
	        graph.addEdge(2, 6);
	        graph.addEdge(3, 2);
	        graph.addEdge(3, 4);
	        graph.addEdge(3, 6);
	        graph.addEdge(3, 7);
	        graph.addEdge(4, 5);
	        graph.addEdge(4, 7);
	        graph.addEdge(5, 2);
	        graph.addEdge(5, 3);
	        graph.addEdge(6, 0);
	        graph.addEdge(7, 2);
	        graph.addEdge(7, 4);
	        graph.addEdge(7, 8);
	        graph.addEdge(9, 8);
	        BFS bfs = new BFS(graph,3);
	         bfs.bfs(graph, 3);
	         bfs.printEdgeTo(graph, 3);
	         
	         
	
	}

}
