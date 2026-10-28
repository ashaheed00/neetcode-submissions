class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[26];
        int i = 0;
        for(char c : s.toCharArray()){
            freq[c - 'a'] = freq[c - 'a'] + 1;
            freq[t.charAt(i) - 'a'] = freq[t.charAt(i) - 'a'] - 1;
            i++;
        }

        for (int n : freq) {
            if (n != 0) return false;
        }
        return true;
    }
}
