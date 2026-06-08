class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();
        int left = 0, right = arr.length - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(arr[left])) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(arr[right])) {
                right--;
            }

            if(arr[left] != arr[right]) {
                return false;
            } else {
                left++;
                right--;   
            }
        }

        return true;
    }
}
