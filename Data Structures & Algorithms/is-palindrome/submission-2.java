class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }

            if(Character.toLowerCase(arr[left]) != 
            Character.toLowerCase(arr[right])) {
                return false;
            } else {
                left++;
                right--;   
            }
        }

        return true;
    }
}
