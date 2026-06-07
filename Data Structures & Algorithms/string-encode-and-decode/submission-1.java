class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String str : strs) {
            sb.append(String.valueOf(str.length()));
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int left = 0;

        while(left < str.length()) {
            int right = left;

            while(str.charAt(right) != '#') {
                right++;
            }

            int length = Integer.parseInt(str.substring(left, right));
            String word = str.substring(right + 1, right + length + 1);

            strs.add(word);

            left = right + length + 1;
        }

        return strs;
    }
}
