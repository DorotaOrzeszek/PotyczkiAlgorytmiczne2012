import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class mal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader inn = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(inn.readLine());
		ArrayList<Long> x0s = new ArrayList<Long>(n);
		ArrayList<Long> y0s = new ArrayList<Long>(n);
		ArrayList<Long> x1s = new ArrayList<Long>(n);
		ArrayList<Long> y1s = new ArrayList<Long>(n);
		for (int i = 0; i < n; i++) {
			String[] nextchild = inn.readLine().split(" "); // x0 y0 x1 y1
			x0s.add((long) Integer.parseInt(nextchild[0]));
			y0s.add((long) Integer.parseInt(nextchild[1]));
			x1s.add((long) Integer.parseInt(nextchild[2]));
			y1s.add((long) Integer.parseInt(nextchild[3]));
		}
		Long x0max = Collections.max(x0s);
		int x0maxindex = x0s.indexOf(x0max);
		Long y0max = Collections.max(y0s);
		int y0maxindex = y0s.indexOf(y0max);
		Long x1min = Collections.min(x1s);
		int x1minindex = x1s.indexOf(x1min);
		Long y1min = Collections.min(y1s);
		int y1minindex = y1s.indexOf(y1min);
		Long commonareaall;
		if ((x1min - x0max) >= 0 && (y1min - y0max) >= 0) {
			commonareaall = (x1min - x0max) * (y1min - y0max);
		} else {
			commonareaall = (long) 0;
		}
		ArrayList<Long> commonareaexcept1 = new ArrayList<Long>();
		for (int k = 0; k < n; k++) {
			Long x0, y0, x1, y1;
			x0 = x0max;
			y0 = y0max;
			x1 = x1min;
			y1 = y1min;
			if (x0s.get(k) == x0max) {
				x0s.remove(x0maxindex);
				x0 = Collections.max(x0s);
				x0s.add(x0maxindex,x0max);
			}
			if (y0s.get(k) == y0max) {
				y0s.remove(y0maxindex);
				y0 = Collections.max(y0s);
				y0s.add(y0maxindex,y0max);
			}
			if (x1s.get(k) == x1min) {
				x1s.remove(x1minindex);
				x1 = Collections.min(x1s);
				x1s.add(x1minindex,x1min);
			}
			if (y1s.get(k) == y1min) {
				y1s.remove(y1minindex);
				y1 = Collections.min(y1s);
				y1s.add(y1minindex,y1min);
			}
			long currentarea = (x1 - x0) * (y1 - y0);
			if ((x1 - x0 < 0) || (y1 - y0 < 0)) {
				currentarea = 0;
			}
			commonareaexcept1.add(currentarea);
		}
		long answer = 0;
		for (int i = 0; i < commonareaexcept1.size(); i ++) {
			answer += commonareaexcept1.get(i);
		}
		answer -= (n-1)*commonareaall;
		System.out.println(answer);
	}
}
