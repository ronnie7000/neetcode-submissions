class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freqArr = new int[26];

        for(char ch : text.toCharArray()) {
            freqArr[ch - 'a']++;
        }

        return Math.min(
            Math.min(
                freqArr['b' - 'a'],
                freqArr['a' - 'a']
            ),
            Math.min(
                Math.min(
                    freqArr['l' - 'a'] / 2,
                    freqArr['o' - 'a'] / 2
                ),
                freqArr['n' - 'a']
            )
        );
    }
}