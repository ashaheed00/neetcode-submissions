class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] taken = new int[strs.length];
        List<List<String>> res = new ArrayList<>();

        for(int i=0; i< strs.length; i++) {
            if(taken[i]==1) continue;
            String a = strs[i];
            List<String> anagrams = new ArrayList<>();
            anagrams.add(a);
            for (int j=i+1; j<strs.length;j++) {
                String b = strs[j];
                if(taken[j]==0 && isAnagram(a,b)){
                    taken[j] = 1;
                    anagrams.add(b);
                }
            }
            res.add(anagrams);
        }
        return res;
    }

    public boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;
        int[] freq = new int[26];
        for(int i=0; i<a.length();i++){
            int ai = a.charAt(i) - 'a';
            int bi = b.charAt(i) - 'a';
            freq[ai] = freq[ai] + 1;
            freq[bi] = freq[bi] - 1;
        }

        for(int n : freq) {
            if (n != 0) return false;
        }
        return true;
    }
    
}
