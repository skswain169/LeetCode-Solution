class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /*
        Making sure the num1 is the smallest array,
        so that all the numbers both the  arrays are correctly covered in partition logic, 
        since if small array is taken later there might be case where there are not enough elements such that half - first_arrmid
        */
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int l = 0, r = nums1.length;
        int total = nums1.length + nums2.length;
        int half = total / 2;

        while (l <= r) {
            int mid_nums1 = (l + r) / 2;
            int nums1_left = mid_nums1-1 < 0 ? Integer.MIN_VALUE : nums1[mid_nums1-1];
            int nums1_right = mid_nums1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid_nums1];
            int nums2_pivot = half - mid_nums1; //2nd array partition index
            int nums2_left = nums2_pivot-1 < 0 ? Integer.MIN_VALUE : nums2[nums2_pivot-1];
            int nums2_right = nums2_pivot >= nums2.length ? Integer.MAX_VALUE : nums2[nums2_pivot ];

            //If partition valid for becoming a sorted merged array
            if (nums1_left <= nums2_right && nums2_left <= nums1_right) {
                if (total % 2 == 0) {
                    return (double) (Math.max(nums2_left, nums1_left) + Math.min(nums1_right, nums2_right)) / 2;
                } else
                    return Math.min(nums2_right, nums1_right);
            }
            //partition not valid
            else if (nums1_left > nums2_right)
                r = mid_nums1 - 1;
            else
                l = mid_nums1 + 1;

        }
    return 0.0;    
    }
}