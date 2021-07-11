import java.util.*;
import java.io.*;

public class KruskalAlgorithm {
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
		int m = sc.nextInt();
		ArrayList<Node> edges = new ArrayList<>();
		for(int i = 0;i<m;i++){
			int source = sc.nextInt();
			source--;
			int destination = sc.nextInt();
			destination--;
			int wt = sc.nextInt();
			edges.add(new Node(wt,source,destination));
		}
		Collections.sort(edges);
		int parent[] = new int[n];
		int rank[] = new int[n];
		Arrays.fill(rank,1);
		for(int i = 0;i<n;i++)parent[i] = i;

		// kruskal Algorithm
		long ans = 0;
		for(int i = 0;i<m;i++) {
			Node curr = edges.get(i);
			int src = curr.src;
			int des = curr.des;
			int wt = curr.wt;

			if(find(parent,src) != find(parent,des)) {
				ans += (long) wt;
				Union(src,des,parent,rank);
			}
		}
		System.out.println(ans);
		long end = System.currentTimeMillis();
		System.out.println("[executed in : " + (end-start) + "ms]");
	}

	// 	DSU
	static int find(int parent[],int i) {

		if(parent[i] == i){
			return i;
		}
		else {
			return parent[i] = find(parent,parent[i]);
		}
	}
	static void Union(int x,int y,int parent[],int rank[]) {
		x = find(parent,x);
		y = find(parent,y);

		if(x != y) {

			if(rank[x] > rank[y]) {
				parent[y] = x;
				rank[x] += rank[y];
			}
			else {
				parent[x] = y;
				rank[y] += rank[x];
			}
		}
	}
}


class Node implements Comparable<Node>{
	int src;
	int des;
	int wt;

	public int compareTo(Node obj) {
		return this.wt-obj.wt;
	}

	public Node(int wt,int src,int des) {
		this.wt = wt;
		this.src = src;
		this.des = des;
	}
}