// Easy one -> I got the similar idea but failed to take first and
// last elements ..
// Maxima and minima pbm
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

#define pb push_back
#define vi vector<int>
#define vpii vector<pair<int, int>>
#define N 2e5 + 5
#define f first
#define s second
#define all(x) x.begin(), x.end()
#define forn(i, n) for (int i = 0; i < n; i++)
#define fore(i, l, r) for (int i = l; i < r; i++)
#define sz(a) (int)((a).size())
#define ll long long
#define ar array
#define init(arr) memset(arr, 0, sizeof(arr))
#define endl "\n"
#define mp make_pair

void solve()
{
  int n;
  cin >> n;
  int a[n];
  forn(i, n)
          cin >>
      a[i];
  vector<int> ans;
  for (int i = 0; i < n; i++)
  {
    if (i == 0 || i == n - 1 || ((a[i - 1] < a[i]) != (a[i] < a[i + 1])))
      ans.pb(a[i]);
  }
  int sz = ans.size();
  cout << sz << endl;
  for (int i = 0; i < sz; i++)
    cout << ans[i] << " ";
  cout << endl;
}
int main()
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--)
    solve();
}
