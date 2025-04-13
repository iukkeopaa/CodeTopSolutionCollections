import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: 无重复字符的最长子串
 * @Author: wjh
 * @Date: 2025/4/10 下午3:41
 */
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度


// "abcabcbb" -> "abc"

//
public class lengthOfLongestSubstring {


    public static int Solution(String s) {

        //定义一个map来记录字符最新出现的位置
        Map<Character, Integer> charIndexMap = new HashMap<>();

        //定义滑动窗口的七点
        int start = 0;

        //定义变量来接收结果
        int res = 0;


        for (int end = 0; end < s.length() - 1; end++) {

            char c = s.charAt(end);

            if (charIndexMap.containsKey(c) && charIndexMap.get(c) >= start) {

                start = charIndexMap.get(c) + 1;
            }
            charIndexMap.put(c, end);
            int currentLength = end - start + 1;

            res = Math.max(res, currentLength);

        }


        return res;
    }



    //不同的是对map的利用，上面的方法中的value是字符在数组中的位置，但是这里value记录的是字符在数组中的位置+1
    public static int Solution2(String s){

        Map<Character, Integer> map = new HashMap<>();
        int length = s.length()-1;

        int start = 0;


        int res = 0;

        for(  int end = 0;end<length;end++){


            char c = s.charAt(end);

            if(map.containsKey(c)){

                start=Math.max(start,map.get(c));
            }

            res = Math.max(res,end-start+1);

            map.put(c,end+1);


        }


        //






        return res;
    }




    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符");

        String input = scanner.nextLine();

        int result =Solution2(input);
        System.out.println("不含有重复字符的最长子串的长度是:"+result);

        scanner.close();




    }


}
