import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long mod = 1_000_000_007L;

        int[] H = new int[hFences.length + 2];
        int[] V = new int[vFences.length + 2];

        H[0] = 1; H[H.length - 1] = m;
        V[0] = 1; V[V.length - 1] = n;

        System.arraycopy(hFences, 0, H, 1, hFences.length);
        System.arraycopy(vFences, 0, V, 1, vFences.length);

        Arrays.sort(H);
        Arrays.sort(V);

        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < H.length; i++)
            for (int j = i + 1; j < H.length; j++)
                hs.add(H[j] - H[i]);

        long best = -1;
        for (int i = 0; i < V.length; i++)
            for (int j = i + 1; j < V.length; j++) {
                int d = V[j] - V[i];
                if (hs.contains(d)) best = Math.max(best, d);
            }

        return best == -1 ? -1 : (int)((best * best) % mod);
    }
}
