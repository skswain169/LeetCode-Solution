class Solution {
    public int trap(int[] height) {

        /*Calculated the water getting trapped at each height
        i.e (lmax or rmax)- curr height, eventually water at each level will sum up to total water*/
        int l = 0, r = height.length - 1, res = 0;
        int lmax = height[l], rmax = height[r];
        while (l < r) {
            if (height[l] < height[r]) {

                lmax = Math.max(height[l], lmax);
                res += lmax - height[l];
                l++;

            } else {

                rmax = Math.max(height[r], rmax);
                res += rmax - height[r];
                r--;

            }

            // System.out.print(res+",");
        }

        return res;
    }
}