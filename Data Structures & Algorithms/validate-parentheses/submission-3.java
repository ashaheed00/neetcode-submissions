class Solution {
  public boolean isValid(String s) {
    if (s.length() % 2 == 1)
      return false;
    Deque<Character> openingBrackets = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        openingBrackets.push(c);
      } else {
        if (openingBrackets.isEmpty()) {
          return false;
        }
        char top = openingBrackets.pop();
        if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
          return false;
        }
      }
    }
    return openingBrackets.isEmpty();
  }
}
