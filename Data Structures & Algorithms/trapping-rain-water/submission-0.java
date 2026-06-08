class Solution {
    public int trap(int[] height) {
        int maxLoc = 0;
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            if(height[maxLoc] < height[i]) {
                maxLoc = i;
            }
        }

        int maxLeft = 0;

        for(int i = 0; i < maxLoc; i++) {
            if(height[i] > height[maxLeft]) {
                maxLeft = i;
            }

            ans += height[maxLeft] - height[i];
        }

        int maxRight = height.length - 1;

        for(int i = height.length - 1; i > maxLoc; i--) {
            if(height[i] > height[maxRight]) {
                maxRight = i;
            }

            ans += height[maxRight] - height[i];
        }

        return ans;
    }
}
