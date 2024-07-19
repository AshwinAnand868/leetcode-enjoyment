package wordscontainingchars;

import java.util.ArrayList;

public class Solution {

    public static int strStr(String haystack, String needle) {

        final int needleLength = needle.length();
        int index = -1;

        for (int i = 0; i < haystack.length(); i++) {

            char firstChar = needle.charAt(i % needleLength);
            char secondChar = haystack.charAt(i);
            boolean lengthCheck = (i + needleLength) <= haystack.length();

            if (firstChar == secondChar
                    && lengthCheck) {

                String potentialSol = haystack.substring(i, i + needleLength);

                if (potentialSol.equals(needle)) {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int subCal = (high - low) / 2;

        int toReturn = low + subCal;

        return toReturn;
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < target.length; i++) {
            arr.add(index[i], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            target[i] = arr.get(i);
        }

        return target;
    }
    // public List<Integer> findWordsContaining(String[] words, char x) {

    // List<Integer> indices = new ArrayList<>();

    // for (int i = 0; i < words.length; i++) {
    // if (words[i].indexOf(x) != -1) {
    // indices.add(i);
    // }
    // }

    // return indices;
    // }

    public static void main(String[] args) {
        // System.out
        // .println(Arrays.toString(createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new
        // int[] { 0, 1, 2, 2, 1 })));

        // strStr("mississippi", "issi");

        searchInsert(new int[] { 1, 3, 5, 6 }, 2);

    }
}
