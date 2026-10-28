class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int l = 1;
    int r = Arrays.stream(piles).max().getAsInt();
    int res = r;

    while (l <= r) {
      int m = (l+r)/2;
      int totalTime = 0;
      for (int i : piles) {
        totalTime += Math.ceil((double) i/m);
      }
      if(totalTime > h) {
        l = m + 1;
      } else {
        res = m;
        r = m - 1;
      }
    }
    return res;
  }
}
