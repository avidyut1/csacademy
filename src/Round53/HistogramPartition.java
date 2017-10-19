package Round53;

import Round51.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class HistogramPartition {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int ans = 0;
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < n; i++) {
                while(st.size() > 0 && st.peek() > ar[i]) {
                    st.pop();
                    ++ans;
                }
                if (st.empty() || st.peek() < ar[i]) {
                    st.push(ar[i]);
                }
            }
            out.write(Integer.toString(ans + st.size()));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
