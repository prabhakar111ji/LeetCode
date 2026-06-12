class Solution {
        String[] map ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        StringBuilder s = new StringBuilder(); 
        backtrack(0, digits, s);
        return result;
        
    }
    private void backtrack(int index, String digits, StringBuilder s){
        if(index == digits.length()){
            result.add(s.toString());
            return;
        }
        String letter = map[digits.charAt(index)-'0'];
        for(char ch:letter.toCharArray()){
            s.append(ch);
            backtrack(index+1, digits,s);
            s.deleteCharAt(s.length()-1);
        }
    }
} 