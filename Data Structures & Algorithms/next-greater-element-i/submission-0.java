class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++) {
            int query = nums1[i];
            int max = -1;
            
            for(int j = nums2.length - 1; j > -1; j--) {
                if(nums2[j] == query) {
                    if(query < max) {
                        ans[i] = max;
                    } else {
                        ans[i] = -1;
                    }
                    break;
                }
                max = query < nums2[j] ? nums2[j] : max;
            }
        }

        return ans;
    }
}