class Solution {
    public int findMin(int[] nums) {

        /* Intuition is there will be 2 partions(sorted and unsorted),
            considering mid as minimum, check in between the partition and update the l,r accordingly
        */
        int l = 0, r = nums.length - 1;

        int result = Integer.MAX_VALUE;

        while (l <= r) { //index of array

            int mid = (l + r) / 2;

            /*if rotated array is at original state after rotation,
                means 1st element is min , since in ascending order.*/
            if (nums[l] < nums[r])
                return Math.min(result, nums[l]);
            /*
            if mid> then left mean min lies at right after rotation.
            e.g 4,5,6,0,1,2
            */
            else if (nums[mid] >= nums[l]) {
                l = mid + 1;

            }
            /*
            mid < left mean , min could be in left since at right every element will be greater
            e.g 7,1,2,4,5,6
            */else
                r = mid - 1;
            result = Math.min(result, nums[mid]);
        }

        return result;

    }
}