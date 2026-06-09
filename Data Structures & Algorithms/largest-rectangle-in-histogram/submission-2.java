class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] prevMin = getPrevMin(heights);
        int[] nextMin = getNextMin(heights);

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            int area = (nextMin[i] - prevMin[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private int[] getNextMin(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = heights.length - 1; i > -1; i--) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = heights.length; 
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    private int[] getPrevMin(int[] heights) {
        int[] res = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}