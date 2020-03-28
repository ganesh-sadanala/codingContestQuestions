// source ->
// https://practice.geeksforgeeks.org/contest-problem/number-of-minimum-picks-to-get-k-pairs-of-socks-from-a-drawer/1/
// Tags: Adhoc Question, Math
/*
 * A drawer contains socks of n different colours. Number of socks available of
 * ith colour is given by a[i] where a is an array of n elements. Tony wants to
 * take k pairs of socks out of the drawer. However he cannot see the colour of
 * the sock that he is picking. You have to tell what is the minimum number of
 * socks Tony has to pick in one attempt from the drawer such that he can be
 * absolutely sure, without seeing their colours, that he will have at least k
 * matching pairs.
 *
 * Input: First line of input contains number of test cases T. Then T test cases
 * follow. In each test case, first line contains the value n. Second line of
 * each test case contains n space separated elements of the array a. Third line
 * contains the value k. Input will be read by driver code.
 *
 * Output: The minimum number of socks required to pick in one draw to get
 * atleast k pairs. Output will be printed by driver code.
 *
 * Your Task: You don't need to take input. Just return the minimum number of
 * picks corresponding to the array and value of n and k passed to the function.
 * Do not print anything. Expected time complexity is O(n).
 *
 * Constraints: 1<= T <= 1000 1 <= n <= 105 1 <= a[i] < 106
 *
 * Example: Input: 2 4 3 4 5 3 6 2 4 6 3
 *
 * Output: 15 7
 *
 * Explanation: Testcase 1 : The worst case scenario, after 14 picks will be
 * 3,3,3,3 or 3,1,5,3 where each number represents picks of socks of one colour.
 * Hence, 15th pick will get the 5th pair for sure. Testcase 2 : Worst case
 * scenario after 6 picks can be 3,3 or 1,5 or 5,1 of each coloured socks. Hence
 * 7th pick will ensure 3rd pair.
 *
 *
 */
class Min {
  public int find_min(int[] a, int n, int k) {

    // Maximum number of pairs that can be formed (atleast k)
    int comp_pairs = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      comp_pairs += (a[i] / 2);
      if (a[i] % 2 == 0) {
        sum += (a[i] - 2) / 2;
      } else {
        sum += (a[i] - 1) / 2;
      }
    }
    if (k > comp_pairs)
      return -1;

    if (k <= sum)
      return 2 * (k - 1) + n + 1;

    return 2 * sum + n + (k - sum);

  }
}
