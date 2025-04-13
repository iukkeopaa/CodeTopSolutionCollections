package repeatedSubstringPattern;

class Solution {
   public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
}

    //暴力代码
    public  boolean repeatedSubstringPattern2(String s) {
        for(int i = 1; i < s.length(); i++) {
            String str = rotate(s.toCharArray(),i);
            if(s.equals(str)) return true;
        }
        return false;
    }


    public  String rotate(char[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return String.valueOf(nums);
    }

    public  void reverse(char[] nums, int begin, int end) {
        int i = begin, j = end;
        while(i < j) {
            char temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}