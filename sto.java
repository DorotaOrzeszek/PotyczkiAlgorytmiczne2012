import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class sto {

	public static void main(String[] args) throws IOException {
		BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
		String inputdata = inn.readLine();		
	    String[] parts = inputdata.split(" ");
	    int AB1 = Integer.parseInt(parts[0]);
	    int AB2 = Integer.parseInt(parts[1]);	    
	    int K = Integer.parseInt(parts[2]);
	    int A;	// longer edge
	    int B;	// shorter edge
	    if (AB1 > AB2) {
	    	A = AB1;
	    	B = AB2;
	    } else {
	    	A = AB2;
	    	B = AB1;
	    }
	    int chairs;
	    if (K > B) {
	    	chairs = 0;
	    }
	    else if (2*K > B) {
	    	chairs = A/K;
	    } else {
	    	chairs = 2*(A/K+(B-2*K)/K);
	    }
	    System.out.println(chairs);
	}
}
