class Solution {
    public int pivotIndex(int[] nums) {
        int length = nums.length;
        int[] preSum = new int[length];
        int[] sufSum = new int[length];
        int carry = 0;
        int pivotIdx = -1;

        for(int i = 0; i < length; i++) {
            preSum[i] = nums[i] + carry;
            carry = preSum[i];
        }

        carry = 0;
        for(int i = length - 1; i > -1; i--) {
            sufSum[i] = nums[i] + carry;
            carry = sufSum[i];
        }

        for(int i = 0; i < length; i++) {
            if(preSum[i] == sufSum[i]) {
                pivotIdx = i;
                break;
            }
        }

        return pivotIdx;
    }
}