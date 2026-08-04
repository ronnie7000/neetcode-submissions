class NumArray {

    private int[] nums;
    private int[] preSum;
    private int length;

    public NumArray(int[] nums) {
        this.length = nums.length;
        this.nums = new int[length];
        this.preSum = new int[length];
        populateNums(nums);
        calculatePreSum(this.nums);
    }
    
    public int sumRange(int left, int right) {
        return getSafe(preSum, right) - getSafe(preSum, left - 1);   
    }

    private void populateNums(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
        }
    }

    private void calculatePreSum(int[] nums) {
        int carry = 0;
        for(int i = 0; i < length; i++) {
            preSum[i] = nums[i] + carry;
            carry = preSum[i];
        }
    }

    private int getSafe(int[] arr, int pos) {
        if(-1 < pos && pos < arr.length) {
            return arr[pos];
        }
        return 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */