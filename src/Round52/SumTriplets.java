package Round52;

import Round51.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SumTriplets {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            int freq[] = new int[5001];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
                freq[ar[i]]++;
            }
            final int MAX_VAL = 500001;
            // 0, 0, 0
            long ans = freq[0] * (freq[0] - 1) * (freq[0] - 2) / 6;
            // 0, x, x
            for (int i = 1; i <= MAX_VAL; ++i) {
                ans += freq[0] * freq[i] * (freq[i] - 1) / 2;
            }
            // x, x, 2*x
            for (int i = 1; 2 * i <= MAX_VAL; ++i) {
                ans += freq[i] * (freq[i] - 1) / 2 * freq[2 * i];
            }
            // x, y, x + y
            for (int i = 1; i <= MAX_VAL; ++i) {
                for (int j = i + 1; i + j <= MAX_VAL; ++j) {
                    ans += freq[i] * freq[j] * freq[i + j];
                }
            }
            out.write(Long.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
