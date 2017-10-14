package Round52;

import Round51.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class LuckyDays {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int maxSofar[] = new int[n];
            maxSofar[0] = ar[0];
            for (int i = 1; i < n; i++) {
                maxSofar[i] = Math.max(ar[i], maxSofar[i - 1]);
            }
            int ans = 0;
            for (int i = 1; i < n; i++) {
                if (ar[i] > maxSofar[i - 1]) {
                    ans++;
                }
            }
            out.write(Integer.toString(ans + 1));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
