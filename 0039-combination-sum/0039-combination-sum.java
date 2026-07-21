class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Invalid case
        if (target < 0 || index == candidates.length) {
            return;
        }

        // Choose current candidate
        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Skip current candidate
        backtrack(candidates, target, index + 1, current, result);
    }
}