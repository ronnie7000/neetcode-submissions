class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int start = s.length() - 1;
        
        while(start > -1 && s.charAt(start) == ' ') {
            start--;
        }

        for(int i = start; i > -1; i--) {
            if(s.charAt(i) == ' ') {
                break;
            }
            length++;
        }

        return length;
    }
}