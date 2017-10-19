package Round53;

import Round51.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Monotone {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                int j = i;
                while(j + 1 < n && ar[j] >= ar[j + 1]) {
                    j++;
                }
                res = Math.max(res, j - i + 1);
                i = j;
            }
            for (int i = 0; i < n; i++) {
                int j = i;
                while(j + 1 < n && ar[j] <= ar[j + 1]) {
                    j++;
                }
                res = Math.max(res, j - i + 1);
                i = j;
            }
            out.write(Integer.toString(res));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
