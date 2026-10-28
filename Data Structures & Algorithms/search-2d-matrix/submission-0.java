class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0; int b = matrix.length - 1;

        while (t <= b){
            int m = (t+b)/2;
            // System.out.println("m: "+m);
            if(matrix[m][0] > target) {
                b = m-1;
            } else if (matrix[m][matrix[m].length - 1] < target) {
                t = m+1;
            } else {
                int l = 0; int r = matrix[m].length - 1;
                while (l <= r) {
                    int mid = (l+r)/2;
                    // System.out.println("mid: "+mid);
                    int n = matrix[m][mid];
                    if(n<target) {
                        l = mid +1;
                    } else if(n>target){
                        r = mid -1;
                    } else {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
