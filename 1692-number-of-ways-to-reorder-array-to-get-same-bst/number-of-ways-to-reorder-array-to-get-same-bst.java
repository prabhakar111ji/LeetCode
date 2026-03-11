import java.util.*;
class Solution {
    long mod = 1000000007;
    long[][] comb = new long[1001][1001];

    public int numOfWays(int[] nums) {
    build(nums.length);
    List<Integer> list = new ArrayList<>();
    for (int x : nums) list.add(x);
    return (int)((dfs(list) - 1 + mod) % mod);
    }

    long dfs(List<Integer> arr) {
    if (arr.size() <= 2) return 1;

    int root = arr.get(0);
    List<Integer> left = new ArrayList<>();
                                                                                    List<Integer> right = new ArrayList<>();
for (int i = 1; i < arr.size(); i++) {
        if (arr.get(i) < root) left.add(arr.get(i));
        else right.add(arr.get(i));
        }
        long l = dfs(left);
        long r = dfs(right);
        return (((comb[left.size() + right.size()][left.size()] * l) % mod) * r) % mod;
        }
        void build(int n) {
        for (int i = 0; i <= n; i++) {
        comb[i][0] = comb[i][i] = 1;
        for (int j = 1; j < i; j++)
        comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % mod;
        }
        }
        }