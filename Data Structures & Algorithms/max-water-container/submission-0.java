class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        int l = 0, r = heights.length -1;
        
        while(l < r) {
            int area = (r-l) * Math.min(heights[r], heights[l]);
            res = Math.max(res, area);
            if(heights[r]>heights[l]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
