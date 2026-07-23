class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int c = 0;

        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || c != 0) {
            int x = c;

            if (i >= 0)
                x += num1.charAt(i--) - '0';

            if (j >= 0)
                x += num2.charAt(j--) - '0';

            ans.append(x % 10);
            c = x / 10;
        }

        return ans.reverse().toString();
    }
}