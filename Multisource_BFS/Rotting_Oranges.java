import java.util.*;
import java.io.*;

public class Rotting_Oranges {
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
		int grid[][] = new int[n][m];
		Queue<pair> q = new LinkedList<>();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				grid[i][j] = sc.nextInt();

				if(grid[i][j] == 2) {
					q.add(new pair(i,j));
					grid[i][j] = 0;
				}
			}
		}
		q.add(null);
		System.out.println(rotting_Oranges(grid,n,m,q));
		long end = System.currentTimeMillis();
		System.out.println("[executed in : " + (end-start) + "ms]");
	}

	static int dx[] = { -1,1,0,0 };
	static int dy[] = { 0,0,1,-1 };

	static int rotting_Oranges(int grid[][],int n,int m,Queue<pair> q) {

		int round_counter = 0;
		while(q.size()>1) {

			if(q.peek() == null) {
				q.poll();
				q.add(null);
				round_counter++;
			}
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for(int i = 0;i<4;i++) {

				int xx = x-dx[i];
				int yy = y-dy[i];

				if(xx >= 0 && xx < n && yy >= 0 && yy < m && grid[xx][yy] == 1) {
					q.add(new pair(xx,yy));
					grid[xx][yy] = 0;
				}
			}

		}
		return checkForValid(grid,n,m)?round_counter:-1;
	}
	static boolean checkForValid(int grid[][],int n,int m) {
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(grid[i][j] == 1){
					return false;
				}
			}
		}
		return true;
	}
}
class pair{
	int x;
	int y;

	public pair(int x,int y) {
		this.x = x;
		this.y = y;
	}
}