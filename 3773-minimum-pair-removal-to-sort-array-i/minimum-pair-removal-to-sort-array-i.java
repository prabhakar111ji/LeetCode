import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        int operations = 0;
        while (true) {
            int violationIndex = -1;
            for (int i = 0; i < numsList.size() - 1; i++) {
                if (numsList.get(i) > numsList.get(i + 1)) {
                    violationIndex = i;
                    break;
                }
            }

            if (violationIndex == -1) {
                break;
            }

            int minPairSum = Integer.MAX_VALUE;
            int minPairIndex = -1;

            for (int i = 0; i < numsList.size() - 1; i++) {
                int currentSum = numsList.get(i) + numsList.get(i + 1);
                if (currentSum < minPairSum) {
                    minPairSum = currentSum;
                    minPairIndex = i;
                }
            }
            
            numsList.set(minPairIndex, minPairSum);
            numsList.remove(minPairIndex + 1);
            operations++;
        }

        return operations;
    }
}
