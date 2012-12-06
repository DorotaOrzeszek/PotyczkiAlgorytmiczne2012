import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class obr {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String inputdata = in.readLine();		
	    String[] parts = inputdata.split(" ");
	    int n = Integer.parseInt(parts[0]);
	    int m = Integer.parseInt(parts[1]);
	    String[] rows = new String[n];
	    int k = 0;
	    while (k < n) {
	    	String currentrow = in.readLine();
	    	rows[k] = currentrow;
	    	k ++;
	    }
	    for (int i = 0; i < m; i++) {
	    	for (int j = n; j > 0; j--) {
	    		System.out.print(rows[j-1].charAt(i));
	    	}
	    	System.out.println();
	    }
	System.exit(0);
	}
}
