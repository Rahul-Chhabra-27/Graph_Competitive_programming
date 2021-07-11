import java.util.*;
import java.io.*;

public class JourneyToTheMoon {
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
		int p = sc.nextInt();
		graph = new ArrayList<>();
		visited = new boolean[n];
		for(int i = 0;i<n;i++) graph.add(new ArrayList<>());
		for(int i = 0;i<p;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		long pair = 0;
		long different = 0;
		for(int i = 0;i<n;i++) {
			countDiff = 0;
			if(!visited[i]) {
				Dfs(i);
				pair += countDiff*different;
				different += countDiff;
			}
		}
		System.out.println(pair);
		long end = System.currentTimeMillis();
		System.out.println("[executed in : " + (end-start) + "]");
	}
	static List<List<Integer>> graph;
	static boolean visited[];
	static int countDiff;

	static void Dfs(int src) {

		visited[src] = true;
		countDiff++;

		for(int adj : graph.get(src)) {
			if(!visited[adj]) {
				Dfs(adj);
			}
		}
	}
}