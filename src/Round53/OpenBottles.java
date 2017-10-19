package Round53;

import Round51.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class OpenBottles {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int ans = 0;
            for (int i = 0; i < 3; i++) {
                int ar[] = new int[3];
                for (int j = 0; j < 3; j++) {
                    ar[j] = in.readInt();
                }
                Arrays.sort(ar);
                ans += ar[0];
            }
            out.write(Integer.toString(ans));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
