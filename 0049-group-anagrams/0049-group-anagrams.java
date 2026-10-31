import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string into character array
            char[] chars = str.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Create a sorted string as key
            String key = new String(chars);

            // Add original string to its group
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        // Return all grouped anagrams
        return new ArrayList<>(map.values());
    }
}