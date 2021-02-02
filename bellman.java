

import java.util.Scanner;

public class bell {

 static int vn, source;




	static void bellman(int source, int a[][],int vn) {
		
		
		int[] d=new int[vn+1];
		for (int node = 1; node <= vn; node++)
			d[node] = 99;
		d[source] = 0;
		

		for (int node = 1; node <= vn - 1; node++) {

			for (int sn = 1; sn <= vn; sn++) {
				for (int dn = 1; dn <= vn; dn++) {

					if (a[sn][dn] != 99) {
						if (d[dn] > (a[sn][dn] + d[sn]))
							d[dn] = a[sn][dn] + d[sn];

					}
				}

			}
		}
		

		for (int sn = 1; sn <= vn; sn++) {
			for (int dn = 1; dn <= vn; dn++) {

				if (a[sn][dn] != 99) {
					if (d[dn] > (a[sn][dn] + d[sn]))
						System.out.println("negative cycle detected");
					
					
					

				}
			}

		}
		

		for (int node = 1; node <= vn; node++)
			System.out.println("the distance from" + source + "to"+ node +"is"+ d[node]);

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("enter the no. of vertices");
		int vn = in.nextInt();

		int a[][] = new int[vn + 1][vn + 1];

		System.out.println("enter adjacency matrix");

		for (int sn = 1; sn <= vn; sn++) {
			for (int dn = 1; dn <= vn; dn++) {

				a[sn][dn] = in.nextInt();

				if (sn == dn) {
					a[sn][dn] = 0;
				}
				if (a[sn][dn] == 0) {
					a[sn][dn] = 99;
				}
			}
		}

		System.out.println("enter source vertex");

		source = in.nextInt();
		
	
		bellman(source,a,vn);
		

	}

}
