class Solution {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        int max = arr[length - 1];
        arr[length - 1] = -1;

        for(int i = length - 2; i > -1; i--) {
            int val = arr[i];
            arr[i] = max;
            max = Math.max(max, val);
        }

        return arr;
    }
}