import java.util.*;
import java.io.*;

public class PrimsAlgo {
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
		graph = new ArrayList<>();
		int n = sc.nextInt();
		for(int i = 0;i<n;i++)graph.add(new ArrayList<>());
		int m = sc.nextInt();
		while(m-- != 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int wt = sc.nextInt();
			u--;
			v--;
			graph.get(u).add(new Node(wt,v));
			graph.get(v).add(new Node(wt,u));
		}
		int src = sc.nextInt();
		src--;
		System.out.println(Prims_MST(n,src));
		long end = System.currentTimeMillis();
		System.out.println("[executed in : " + (end-start) + "]");
	}
	static List<List<Node>> graph;
	static long Prims_MST(int v,int src) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Set<Integer> mst = new HashSet<>();
		List<Integer> MST = new ArrayList();
		long ans = 0;
		pq.add(new Node(0,src));

		while(!pq.isEmpty()) {

			Node curr = pq.poll();
			int to = curr.ver;
			int dis = curr.dis;

			if(mst.contains(to)) {
				continue;
			}
			else {
				MST.add(to);
				mst.add(to);
				ans += (long) dis;

				for(Node adj : graph.get(to)) {

					if(!mst.contains(adj.ver)) {
						pq.add(new Node(adj.dis,adj.ver));
					}
				}
			}

		}
		System.out.println(MST);
		return ans;
	}
}
class Node implements Comparable<Node>{
	int ver;
	int dis;

	public int compareTo(Node obj) {
		return this.dis-obj.dis;
	}

	public Node(int wt,int des) {
		this.dis = wt;
		this.ver = des;
	}
}