class Solution {
    List<Integer> prevSmall = new ArrayList<>();
    List<Integer> nextSmall = new ArrayList<>();

    public int largestRectangleArea(int[] heights) {
        getPrevSmall(heights);
        getNextSmall(heights);

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int width = heights[i] * (nextSmall.get(i) - prevSmall.get(i) - 1);
            ans = Math.max(width, ans);
        }
        return ans;
    }

    private void getPrevSmall(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                prevSmall.add(-1);
            } else {
                prevSmall.add(stack.peek());
            }
            stack.push(i);
        }
    }

    private void getNextSmall(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i > -1; i--) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                nextSmall.add(arr.length);
            } else {
                nextSmall.add(stack.peek());
            }
            stack.push(i);
        }
        Collections.reverse(nextSmall);
    }
}
