class Solution {

    // Mapping digits to letters
    private static final String[] KEYPAD = {
        "",     "",     "abc",  "def",  "ghi", 
        "jkl",  "mno",  "pqrs", "tuv",  "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) return result;

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    public void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = KEYPAD[digits.charAt(index) - '0'];

        for(char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }



    // Map<Character, String> phoneMap = Map.of('2', "abc",
    //                             '3', "def",
    //                             '4', "ghi",
    //                             '5', "jkl",
    //                             '6', "mno",
    //                             '7', "pqrs",
    //                             '8', "tuv",
    //                             '9', "wxyz");

    // public List<String> letterCombinations(String digits) {
    //     int n = digits.length();

    //     List<String> results = new ArrayList<>();

    //     if(n == 0) {
    //         return new ArrayList<>();
    //     } else if(n == 1) {
    //         String letters = phoneMap.get(digits.charAt(0));
    //         String[] letterArry = letters.split("");
    //         return Arrays.asList(letterArry);
    //     } else if(n == 2) {
    //         // 2 loops
    //         String one = phoneMap.get(digits.charAt(0));
    //         String two = phoneMap.get(digits.charAt(1));

    //         for(int i = 0; i < one.length(); i++) {
    //             char iChar = one.charAt(i);
    //             for(int j = 0; j < two.length(); ++j) {
    //                 char jChar = two.charAt(j);
    //                 results.add("" + iChar + jChar);
    //             }
    //         }



    //     } else if(n == 3) {
    //         // 3 loops

    //         String one = phoneMap.get(digits.charAt(0));
    //         String two = phoneMap.get(digits.charAt(1));
    //         String three = phoneMap.get(digits.charAt(2));

    //         for(int i = 0; i < one.length(); i++) {
    //             char iChar = one.charAt(i);
    //             for(int j = 0; j < two.length(); ++j) {
    //                 char jChar = two.charAt(j);
    //                 for(int k = 0; k < three.length(); ++k) {
    //                     char kChar = three.charAt(k);
    //                     results.add("" + iChar + jChar + kChar);
    //                 }
    //             }
    //         }


    //     } else {
    //         // 4 loops
    //         String one = phoneMap.get(digits.charAt(0));
    //         String two = phoneMap.get(digits.charAt(1));
    //         String three = phoneMap.get(digits.charAt(2));
    //         String four = phoneMap.get(digits.charAt(3));

    //         for(int i = 0; i < one.length(); i++) {
    //             char iChar = one.charAt(i);
    //             for(int j = 0; j < two.length(); ++j) {
    //                 char jChar = two.charAt(j);
    //                 for(int k = 0; k < three.length(); ++k) {
    //                     char kChar = three.charAt(k);
    //                     for(int l = 0; l < four.length(); ++l) {
    //                         char lChar = four.charAt(l);
    //                         results.add("" + iChar + jChar + kChar + lChar);
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     return results;
    // }
}