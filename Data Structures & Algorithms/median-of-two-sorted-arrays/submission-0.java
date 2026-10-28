class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        int total = A.length + B.length;
        int half = (total+1)/2;

        if (B.length < A.length) {
            int[] tmp = B;
            B = A;
            A = tmp;
        }

        int l = 0; int r = A.length;

        while(l <= r) {
            int i = (l+r)/2;
            int j = half - i;

            int al = i > 0 ? A[i-1] : Integer.MIN_VALUE;
            int ar = i < A.length ? A[i] : Integer.MAX_VALUE;
            int bl = j > 0 ? B[j-1] : Integer.MIN_VALUE;
            int br = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (al <= br && bl <= ar) {
                if(total%2 != 0) {
                    return Math.max(al, bl);
                }
                return (Math.max(al, bl) + Math.min(ar, br))/2.0;
            } else if(al > br) {
                r = i - 1;
            } else {
                l = i+1;
            }
        }
        return -1;
    }
}
