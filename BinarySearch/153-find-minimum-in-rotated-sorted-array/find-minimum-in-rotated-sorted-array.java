class Solution {
    public int findMin(int[] nums) {

        int l = 0, r = nums.length-1;

        int result = Integer.MAX_VALUE;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (nums[l] < nums[r])
                return Math.min(result, nums[l]);
            else if (nums[mid] >= nums[l]) {
                l = mid + 1;

            } else
                r = mid - 1;
            result = Math.min(result, nums[mid]);
        }

        return result;

    }
}