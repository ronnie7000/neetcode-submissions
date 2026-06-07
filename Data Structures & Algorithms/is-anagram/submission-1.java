class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for(char ch : s.toLowerCase().toCharArray()) {
            freqA[ch - 'a']++;
        }

        for(char ch : t.toLowerCase().toCharArray()) {
            freqB[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(freqA[i] != freqB[i]) {
                return false;
            }
        }

        return true;
    }
}
