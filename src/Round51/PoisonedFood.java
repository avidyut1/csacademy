package Round51;

import java.io.*;
import java.util.*;
import java.math.*;

public class PoisonedFood {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            IndexProb[] ar = new IndexProb[n];
            for (int i = 0; i < n; i++) {
                int pi = in.readInt();
                int ti = in.readInt();
                double prob = (double)ti / pi;
                ar[i] = new IndexProb(i + 1, prob);
            }
            Arrays.sort(ar);
            out.write(Integer.toString(ar[0].id));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class IndexProb implements Comparable<IndexProb>{
    int id;
    double prob;
    public IndexProb(int id, double prob) {
        this.id = id;
        this.prob = prob;
    }
    public int compareTo(IndexProb that){
        if ((this.prob - that.prob) < (int)1e-9) {
            return -1;
        }
        else if ((this.prob - that.prob) > (int)1e-9) {
            return 1;
        }
        else {
            if (this.id < that.id) {
                return -1;
            }
            return 1;
        }
    }
}
