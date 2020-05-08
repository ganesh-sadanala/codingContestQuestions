
import java.io.*;
import java.util.*;

class GFG {

  static int v, p;
  static int vcnt[] = new int[3001];

  static class Wrapper implements Comparable<Wrapper> {
    int pre;
    int c;

    Wrapper(int pre, int c) {
      this.pre = pre;
      this.c = c;
    }

    public int compareTo(Wrapper w) {
      return this.c - w.c;
    }
  }

  static ArrayList<Wrapper> list = new ArrayList<>();

  static long solveUtil() {
    long cost = Long.MAX_VALUE;
    Collections.sort(list);
    boolean flag[] = new boolean[v + 1];

    for (int m = 1; m <= (v - vcnt[1]); m++) {

      long lcost = 0;
      int cnt = 0;
      Arrays.fill(flag, true);
      Arrays.fill(vcnt, 0);
      for (int i = 1; i <= v; i++)
        vcnt[list.get(i - 1).pre]++;

      for (int i = 1; i <= v; i++) {
        if (list.get(i - 1).pre != 1 && vcnt[list.get(i - 1).pre] >= m) {
          flag[i] = false;
          vcnt[list.get(i - 1).pre]--;
          cnt++;
          lcost += list.get(i - 1).c;
        }
      }

      for (int i = 1; i <= v && cnt < m - vcnt[1]; i++) {
        if (list.get(i - 1).pre != 1 && flag[i]) {
          flag[i] = false;
          vcnt[list.get(i - 1).pre]--;
          cnt++;
          lcost += list.get(i - 1).c;
        }
      }

      // System.out.println(lcost+" "+cnt);

      if (cnt >= (m - vcnt[1]))
        cost = Math.min(lcost, cost);
    }
    return cost;
  }

  static long solve() {
    if (v == 1) {
      if (list.get(0).pre == 1)
        return 0;
      else
        return (list.get(0).c);
    }
    for (int i = 1; i <= v; i++)
      vcnt[list.get(i - 1).pre]++;

    boolean flag = false;
    for (int i = 2; i <= p; i++) {
      if (vcnt[i] >= vcnt[1]) {
        flag = true;
        break;
      }
    }
    if (!flag)
      return 0;

    return solveUtil();
  }

  public static void main(String[] args) throws Exception {

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String s[] = bf.readLine().trim().split("\\s+");
    v = Integer.parseInt(s[0]);
    p = Integer.parseInt(s[1]);
    for (int i = 0; i < v; i++) {
      s = bf.readLine().trim().split("\\s+");
      int pre = Integer.parseInt(s[0]);
      int c = Integer.parseInt(s[1]);
      list.add(new Wrapper(pre, c));
    }
    System.out.println(solve());
  }
}
