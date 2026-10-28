class TrieNode {
    List<TrieNode> children;
    int childCount;
    boolean isLeaf;
    
    public TrieNode() {
        children = new ArrayList<>(26);
        for(int i=0; i<26; i++){
            children.add(null);
        }
        childCount = 0;
        isLeaf = false;
    }
}

class Solution {
    public void insert(TrieNode root, String s){
        TrieNode curr = root;

        for(char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if(curr.children.get(idx) == null) {
                curr.children.set(idx, new TrieNode());
                curr.childCount++;
            }
            curr = curr.children.get(idx);
        }
        curr.isLeaf = true;
    }

    public String walkTrie(TrieNode root, String s){
        TrieNode curr = root;
        int i = 0;
        while (curr.childCount == 1 && !curr.isLeaf) {
            curr = curr.children.get(s.charAt(i) - 'a');
            i++;
        }
        return s.substring(0,i);
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();

        for(String s : strs) insert(root, s);

        return walkTrie(root, strs[0]);
    }
}