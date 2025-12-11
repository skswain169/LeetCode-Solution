class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowlength = matrix.length;
        int collength = matrix[0].length;

        int low = 0;
        int high = rowlength - 1;
        while (low <= high) {

            int mid = (low + high) / 2;

            int rowstart = matrix[mid][0];

            if (target < rowstart) {
                high = mid - 1;
            } else if (target > matrix[mid][collength - 1])
                low = mid + 1;
            else
                return binarySearchCol(matrix[mid], target);
        }
    return false;
    }

    static boolean binarySearchCol(int[] colarr, int target) {

        int low = 0;
        int high = colarr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (colarr[mid] == target)
                return true;
            else if (colarr[mid] > target)

                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;
    }

}
