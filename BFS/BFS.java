package Graph;
import java.util.*;
public class BFS<T> {
	
	 void addEdge(T x , T y,Map<T,ArrayList<T>> map,boolean bidirectional) {
		 
		 if(bidirectional) {
			 
			 if(map.containsKey(x)) {
				 map.get(x).add(y);
			 }
		    else {
			 map.put(x,new ArrayList<T>());
			 map.get(x).add(y);
		     }
			 if(map.containsKey(y)) {
				 map.get(y).add(x);
			 }
		    else {
			 map.put(y,new ArrayList<T>());
			 map.get(y).add(x);
		    }
			 
		 } else {
			 if(map.containsKey(x)) {
				 map.get(x).add(y);
			 }
		    else {
			 map.put(x,new ArrayList<T>());
			 map.get(x).add(y);
		 }
	 }
 }
	 // Breadth first search in undirected(bidirectional) graph
	 void breadth_first_search(Map<T,ArrayList<T>> adj,T s,int V) {
		 
		 if(V == 0) return ;
		 if(V == 1) System.out.println(0);
		 Set<T> visited = new HashSet<>();
		 List<T> ans = new ArrayList<>();
		 	Queue<T> q = new LinkedList<>();
		 	q.add(s);
		 	visited.add(s);
		 	while(!q.isEmpty()) {
		 		
		 		T poll = q.poll();
		 		ans.add(poll);
		 		
		 		for(T i : adj.get(poll)) {
		 			
		 			if(!visited.contains(i)) {
		 				q.add(i);
		 				visited.add(i);
		 			}
		 		}
		 		
		 		
		 	}
		 	for( T i: ans) System.out.print(i + " ");
	 }
	 
	 void Dfs(Map<T,ArrayList<T>> adj,T src) {
		 
		 Set<T> visited = new HashSet<>();
		 ArrayList<T> ans = new ArrayList<>();
		 Dfs_helper(adj,src,ans,visited);
		 
		 for(T i : ans) System.out.print(i + " ");
		 
	 }
	 void Dfs_helper(Map<T,ArrayList<T>> adj,T src,ArrayList<T> ans,Set<T> visited) {
		 
		 ans.add(src);
		 visited.add(src);
		 
		 for(T run : adj.get(src)) {
			 if(!visited.contains(run)) {
				 Dfs_helper(adj,run,ans,visited);
			 }
		 }
	 }
	 

	public static void main(String[] args) {
		   BFS<String> bfs = new BFS<String>();
		   Map<String,ArrayList<String>> map = new HashMap<>();
		   
		   bfs.addEdge("Agra", "Banglore", map, true);
		   bfs.addEdge("Agra", "Calcutta", map, true);
		   bfs.addEdge("Banglore", "Delhi", map, true);
		   bfs.addEdge("Banglore", "East", map, true);
		   bfs.addEdge("Calcutta", "Delhi", map, true);
		   bfs.addEdge("Delhi", "East", map, true);
		   bfs.addEdge("Dehradun", "Mumbai", map, true);
		   
		   for(String i : map.keySet()) {
			   System.out.print(i + "  ->> ");
			   for(String j : map.get(i)) {
				   System.out.print(j + ", ");
			   }
			   System.out.println();
		   }
		   
//		   bfs.breadth_first_search(map, "Mumbai", 5);
		   bfs.breadth_first_search(map, "Agra", 5);
		   System.out.println();
		   bfs.Dfs(map,"Agra");
		

	}

}
