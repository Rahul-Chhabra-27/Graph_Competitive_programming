import java.util.*;
import java.io.*;

public class DSU {
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
		int n = 5;
		int parent[] = new int[n];
		int rank[] = new int[n];
		for(int i = 0;i<n;i++) {
			rank[i] = 1;
			parent[i] = i;
		}
		Union(1,2);
		Union(2,3);
		Union(1,4);
		long end = System.currentTimeMillis();
		System.out.println("[executed in : " + (end-start) + "]");
	}
	// 	find -->>> optimised with path compression and rank of union
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
}
