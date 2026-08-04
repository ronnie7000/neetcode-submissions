class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(strs.length != pattern.length()) {
            return false;
        }

        Map<Character, String> mapA = new HashMap<>();
        Map<String, Character> mapB = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char ch = pattern.charAt(i);

            if(!mapA.getOrDefault(ch, word).equals(word) || mapB.getOrDefault(word, ch) != ch) {
                return false;
            }

            mapA.put(ch, word);
            mapB.put(word, ch);
        }
        return true;
    }
}