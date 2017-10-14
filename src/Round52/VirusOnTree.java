package Round52;

import Round51.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class VirusOnTree {
    static Vector<Integer> subtrees;
    static int size[];
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int k = in.readInt();
            Vector<Edge> graph[] = new Vector[n];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new Vector<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int a = in.readInt() - 1;
                int b = in.readInt() - 1;
                int t = in.readInt();
                graph[a].add(new Edge(a, b, t));
                graph[b].add(new Edge(b, a, t));
            }
            subtrees = new Vector<>();
            size = new int[n];
            dfs1(graph, new boolean[n], 0);
            dfs2(graph, new boolean[n], 0);
            Collections.sort(subtrees, Collections.reverseOrder());
            int saved = 0;
            int cuts = 0;
            for (int i = 0; i < subtrees.size(); i++) {
                if (saved >= n - k) {
                    break;
                }
                saved += subtrees.get(i);
                cuts += 1;
            }
            if (saved >= n - k) {
                out.write(Integer.toString(cuts));
            }
            else {
                out.write(Integer.toString(-1));
            }
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dfs1(Vector<Edge> g[], boolean v[], int ver) {
        v[ver] = true;
        size[ver] = 1;
        for (Edge ch: g[ver]) {
            if (!v[ch.b]) {
                dfs1(g, v, ch.b);
                size[ver] += size[ch.b];
            }
        }
    }
    public static void dfs2(Vector<Edge> g[], boolean v[], int ver) {
        v[ver] = true;
        for (Edge ch: g[ver]) {
            if (!v[ch.b]) {
                if (ch.type == 1) {
                    subtrees.add(size[ch.b]);
                }
                else {
                    dfs2(g, v, ch.b);
                }
            }
        }
    }
}
class Edge {
    int a; int b; int type;

    public Edge(int a, int b, int type) {
        this.a = a;
        this.b = b;
        this.type = type;
    }
}
