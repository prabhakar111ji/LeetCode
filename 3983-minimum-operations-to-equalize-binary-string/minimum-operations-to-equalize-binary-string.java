import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int initialZeros = 0;
        for (char c : s.toCharArray()) if (c == '0') initialZeros++;
        
        if (initialZeros == 0) return 0;

        TreeSet<Integer> even = new TreeSet<>();
        TreeSet<Integer> odd = new TreeSet<>();
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) even.add(i);
            else odd.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(initialZeros);
        (initialZeros % 2 == 0 ? even : odd).remove(initialZeros);

        int operations = 0;
        while (!queue.isEmpty()) {
            operations++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                
                // Calculate valid range [L, R] for the next number of zeros
                int min_x = Math.max(0, k - (n - cur));
                int max_x = Math.min(cur, k);
                
                int L = cur + k - 2 * max_x;
                int R = cur + k - 2 * min_x;

                // Parity of next state is (cur + k) % 2
                TreeSet<Integer> targetSet = ((cur + k) % 2 == 0) ? even : odd;
                
                Integer next = targetSet.ceiling(L);
                while (next != null && next <= R) {
                    if (next == 0) return operations;
                    queue.offer(next);
                    targetSet.remove(next);
                    next = targetSet.ceiling(L);
                }
            }
        }
        return -1;
    }
}
