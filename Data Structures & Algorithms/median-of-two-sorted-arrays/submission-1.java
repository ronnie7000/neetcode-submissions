class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;
        int top = 0, end = nums1.length;
        while(top <= end) {
            int mid = top + (end - top) / 2;

            int leftA = getSafe(nums1, mid - 1, true);
            int rightA = getSafe(nums1, mid, false);
            int leftB = getSafe(nums2, half - mid - 1, true);
            int rightB = getSafe(nums2, half - mid, false);

            if(leftA <= rightB && leftB <= rightA) {
                if(total % 2 == 0) {
                    int maxLeft = Math.max(leftA, leftB);
                    int minRight = Math.min(rightA, rightB);

                    return (double) (maxLeft + minRight) / 2;
                } else {
                    return (double) Math.max(leftA, leftB);
                }

            } else if (leftA > rightB) {
                end = mid - 1;
            } else {
                top = mid + 1;
            }
        }
        return 0.00;
    }

    private int getSafe(int[] nums, int pos, boolean isLeft) {
        if(-1 < pos && pos < nums.length) {
            return nums[pos];
        }
        return isLeft ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        // return 0;
    }
}
