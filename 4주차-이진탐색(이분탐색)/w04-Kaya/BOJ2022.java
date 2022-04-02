import java.io.*;
import java.util.*;

public class Main {
    static double x, y, c;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        double lo = 0, hi = Math.min(x,y);
        double mid = 0;
        while(lo < hi) {
            mid = (lo+hi)/2;

            double h = getHeight(mid);
            if(h-c > 0.001) {
                lo = mid;
            } else if(h-c < -0.001) {
                hi = mid;
            } else break;
        }

        System.out.printf("%.3f\n", mid);
    }

    public static double getHeight(double w) {
        double res = 0;

        res = Math.sqrt(x*x - w*w) - c*Math.sqrt(x*x - w*w)/Math.sqrt(y*y-w*w);

        return res;
    }
}

