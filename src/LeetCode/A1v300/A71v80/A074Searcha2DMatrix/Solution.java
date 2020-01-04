package LeetCode.A1v300.A71v80.A074Searcha2DMatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int yLength = matrix.length;
        if (yLength == 0) {
            return false;
        }
        int xLength = matrix[0].length;
        int left = 0, right = yLength * xLength - 1;
        int x = 0;
        int y = 0;
        while (left<=right){
            int mid = (left + right)/2;
            int midNum = matrix[mid/xLength][mid%xLength];
            if (midNum == target){
                return true;
            }else if (midNum>target){
                right = mid - 1;
            }else if (midNum<target){
                left = mid+1;
            }
        }
        return false;
    }
}
