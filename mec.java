import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class mec {

	public static void main(String[] args) throws IOException {
		BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
		String inputdata = inn.readLine();
		String[] parts = inputdata.split(" ");
	    int n = Integer.parseInt(parts[0]);
	    int m = Integer.parseInt(parts[1]);
	    int[][] teams = new int [m][n];
	    // teams is a matrix m x n
	    // left half is team A, right half team B
	    for (int j = 0; j < m; j++) {
	    	String currentgame = inn.readLine();
	    	for (int k = 0; k < n; k++) {
	    		teams[j][k] = Integer.parseInt(currentgame.split(" ")[k]);
	    	}
	    }
	    boolean[][] rivals = new boolean[n][n];
	    for (int i = 0; i < n; i++) {
	    	rivals[i][i] = true;
	    }
	    for (int j = 0; j < m; j++) {
	    	for (int k = 0; k < n/2; k++) {
	    		for (int l = n/2; l < n; l++) {
	    			int a = teams[j][k]-1;
    				int b = teams[j][l]-1;
	    			if (rivals[a][b] == false) {
	    				rivals[a][b] = true;
	    				rivals[b][a] = true;
	    			}
	    		}
	    	}
	    }
	    int answer = 1;
	    for (int p = 0; p < n; p++) {
	    	for (int q = 0; q < n; q++) {
	    		if (rivals[p][q] != true) {
	    			answer = 0;
	    			break;
	    		}
	    	}
	    	if (answer == 0) {
	    		break;
	    	}
	    }
	    if (answer == 1) {
	    	System.out.println("TAK");
	    } else {
	    	System.out.println("NIE");
	    }
	}
}
