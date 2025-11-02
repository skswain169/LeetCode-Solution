class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<int[]> hstack = new Stack();
        int maxArea = Integer.MIN_VALUE;
        int[] ind_height ;
        for (int i = 0; i < heights.length; i++) {

            int start_index = i;
            
            while (!hstack.isEmpty() && heights[i] < hstack.peek()[1]) {
                ind_height = hstack.pop();
                maxArea = Math.max(maxArea, ind_height[1] * (i-ind_height[0]));
                start_index = ind_height[0];

            }

            hstack.push(new int[] { start_index, heights[i] });
        }

        while (!hstack.isEmpty()) {
            ind_height = hstack.pop();
            maxArea = Math.max(maxArea, ind_height[1] * (heights.length-ind_height[0]));
        }

        return maxArea;

    }
}