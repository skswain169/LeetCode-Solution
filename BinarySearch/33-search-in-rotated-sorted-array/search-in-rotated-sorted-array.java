class Solution {
    public int search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;

    /*In rotated array there will be always 2 parts
      and one part will be sorted  */
        while (l <= r) {

            int mid = (l + r) / 2;

            if (nums[mid] == target)
                return mid;

             //if mid in left sorted portion   
            if (nums[l] <= nums[mid]) {

                if (target <= nums[mid] && target >= nums[l]) {

                    r = mid - 1;

                } else {
                    l = mid + 1;
                }

            } 
            //if mid is in right sorted portion
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;

                } else
                    r = mid - 1;
            }

        }
        return -1;
    }
}