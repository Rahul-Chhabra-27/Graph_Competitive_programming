import java.util.*;
import java.io.*;

public class DijkstrasAlgorithm {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		try{
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		}
		catch(Exception e) {
			System.err.println(e);
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int edges = sc.nextInt();
		List<List<Node>> graph = new ArrayList<>();
		for(int i = 0;i<n;i++) graph.add(new ArrayList<>());
		for(int i  = 0;i< edges;i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			int wt = sc.nextInt();
			graph.get(u).add(new Node(v,wt));
			graph.get(v).add(new Node(u,wt));
		}
		dijkstrasAlgorithm(n,graph);
		long end = System.currentTimeMillis();
		System.out.println("[executed in : " + (end-start) + "ms]");
	}
	static void dijkstrasAlgorithm(int v,List<List<Node>> graph){
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0));
		int dis[] = new int[v];
		Arrays.fill(dis,Integer.MAX_VALUE);
		dis[0] = 0;
		while(!pq.isEmpty()){
			// write your code here.....
			Node curr = pq.poll();
			for(Node adj : graph.get(curr.ver)){
				if(dis[curr.ver]+adj.wt < dis[adj.ver]){
					if(pq.contains(adj)){
						pq.remove(adj);
					}
					dis[adj.ver] = dis[curr.ver] + adj.wt;
					pq.add(new Node(adj.ver,dis[curr.ver]+adj.wt));
				}
			}
		}
		for(int i : dis)System.out.println(i);
	}
}
class Node implements Comparable<Node> {
	int wt;
	int ver;
	@Override
	public int compareTo(Node curr){
		return this.wt - curr.wt;
	}
	public Node(int ver,int wt){
		this.wt = wt;
		this.ver = ver;
	}
}
