package LongestPalindromicSubstring;

class Solution2 {
    public String longestPalindrome(String s) {
        if(s==null || s.length() == 0) {
            return "";
        }
        //对原始字符串做处理，将abc变成#a#b#c#
        StringBuilder tmp = new StringBuilder();
        tmp.append("#");
        for(int i = 0; i < s.length(); ++i) {
            tmp.append("#");
            tmp.append(s.charAt(i));
        }
        tmp.append("#");
        int start = 0;
        int maxLen = 0;
        int n = tmp.length();
        //从左到右遍历处理过的字符串，求每个字符的回文半径
        for(int i = 0; i < n; ++i) {
            //计算当前以i 为中心的回文半径
            int cur = expand(tmp, i, i);
            //如果当前计算的半径大于maxLen，就更新start(原始字符的起始位置)
            if(cur > maxLen) {
                start = (i - cur) / 2;
                maxLen = cur;
            }
        }
        //根据start和maxLen，从原始字符串中截取一段返回
        return s.substring(start, start + maxLen);
    }

    //以left和right为起点，计算回文半径，由于while循环退出后left和right各多走了一步
    //所以在返回的总长度时要减去2
    private int expand(StringBuilder s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}