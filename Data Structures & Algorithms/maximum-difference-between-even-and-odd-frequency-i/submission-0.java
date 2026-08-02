class Solution {
    public int maxDifference(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        int[] freq = new int[26];
        int maxOdd = Integer.MIN_VALUE;
        int minEve = Integer.MAX_VALUE;
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) {
                continue;
            }
            
            if(freq[i] % 2 == 0) {
                minEve = Math.min(minEve, freq[i]);
            } else {
                maxOdd = Math.max(maxOdd, freq[i]);
            }
        }

        return maxOdd - minEve;
    }
}