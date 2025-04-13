package ReverseWordsInString;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        // 去除字符串首尾的空格
        s = s.trim();
        // 使用正则表达式将字符串按一个或多个空格分割成单词数组
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        // 从后往前遍历单词数组
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }
}    