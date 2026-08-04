import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int min = nums[0];
        int max = nums[0];

        // Find minimum and maximum
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Store elements in a HashSet
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Find missing numbers
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}