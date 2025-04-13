package LongestPalindromicSubstring;

class Solution3 {
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
        int n = tmp.length();
        //right表示目前计算出的最右端范围，right和左边都是已探测过的
        int right = 0;
        //center最右端位置的中心对称点
        int center = 0;
        int start = 0;
        int maxLen = 0;
        //p数组记录所有已探测过的回文半径，后面我们再计算i时，根据p[i_mirror]计算i
        int[] p = new int[n];
        //从左到右遍历处理过的字符串，求每个字符的回文半径
        for(int i = 0; i < n; ++i) {
            //根据i和right的位置分为两种情况：
            //1、i<=right利用已知的信息来计算i
            //2、i>right，说明i的位置时未探测过的，只能用中心探测法
            if(right >= i) {
                //这句是关键，不用再像中心探测那样，一点点的往左/右扩散，根据已知信息
                //减少不必要的探测，必须选择两者中的较小者作为左右探测起点
                int minArmLen = Math.min(right - i, p[2 * center - i]);
                p[i] = expand(tmp, i - minArmLen, i + minArmLen);
            }
            else {
                //i落在right右边，是没被探测过的，只能用中心探测法
                p[i] = expand(tmp, i, i);
            }
            //大于right，说明可以更新最右端范围了，同时更新center
            if(i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
            //找到了一个更长的回文半径，更新原始字符串的start位置
            if(p[i] > maxLen) {
                start = (i - p[i]) / 2;
                maxLen = p[i];
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