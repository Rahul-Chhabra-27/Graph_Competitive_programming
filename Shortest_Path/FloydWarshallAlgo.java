import java.util.*;
import java.io.*;

public class FloydWarshallAlgo {
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
		long graph[][] = new long[n+1][n+1];
		for(long i []:graph)Arrays.fill(i,Integer.MAX_VALUE);
		for(int i = 0;i<m;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			long wt = sc.nextInt();
			graph[x][y] = wt;
		}
		System.out.println(AllPairShortestPath(graph,n,1,3));
		long end = System.currentTimeMillis();
		System.out.println("[executed in : " + (end-start) + "]");
	}
	static long AllPairShortestPath(long graph[][],int n,int src,int des){

		for(int k= 1;k<=n;k++){
			// considering every vertex as an intermediate vertex...
			for(int i = 1;i<=n;i++){
				for(int j = 1;j<=n;j++){

					if(i == j){
						graph[i][j] = 0;
					}
					else if(i == k || j == k) {
						continue;
					}
					else {
						if(graph[i][j] > graph[i][k]+graph[k][j]) {
							graph[i][j] = graph[i][k] + graph[k][j];
						}
					}
				}
			}
		}
		for(long i[] : graph){
			for(long j : i) System.out.print(j + " ");
			System.out.println();
		}
		return graph[src][des];
	}
}