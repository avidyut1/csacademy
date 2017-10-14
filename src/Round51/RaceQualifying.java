package Round51;

import java.io.*;
import java.util.*;
import java.math.*;

public class RaceQualifying {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            IndexPenalty ar[] = new IndexPenalty[n];
            for (int i = 0; i < n; i++) {
                ar[i] = new IndexPenalty(i + 1, in.readInt());
            }
            Arrays.sort(ar);
            for (int i = 0; i < n; i++) {
                out.write(Integer.toString(ar[i].index)+" ");
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class IndexPenalty implements Comparable<IndexPenalty>{
    public int index, penalty;
    public IndexPenalty(int index, int penalty) {
        this.index = index;
        this.penalty = penalty;
    }
    public int compareTo(IndexPenalty that) {
        if (this.penalty < that.penalty) {
            return -1;
        }
        else if (this.penalty > that.penalty) {
            return 1;
        }
        return 0;
    }
}
