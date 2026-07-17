class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        List<Character> start = List.of('(', '[', '{');
        for(int i = 0; i < s.length(); i++) {
            if(start.contains(s.charAt(i))){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                Character c = stack.pop();
                if(!isMatching(c, s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private boolean isMatching(Character start, char end) {
        return (start == '(' && end == ')') || (start == '{' && end == '}') || (start == '[' && end == ']');
    }
}
