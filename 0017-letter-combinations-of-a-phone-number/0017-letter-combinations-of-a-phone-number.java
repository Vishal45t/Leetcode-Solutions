class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", map, res);

        return res;
    }

    public void backtrack(String digits, int idx, String curr,
                          String[] map, List<String> res) {

        if (idx == digits.length()) {
            res.add(curr);
            return;
        }

        String letters = map[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            backtrack(digits, idx + 1,
                      curr + letters.charAt(i), map, res);
        }
    }
}