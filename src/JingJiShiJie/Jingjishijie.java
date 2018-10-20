package JingJiShiJie;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 竞技世界笔试题
 * @author: Ya
 * @create: 2018-10-20 11:23
 **/
public class Jingjishijie {
    /**

     竞技世界 笔试 2018.10.20
     */
    //是否套嵌 {}[]()
    static boolean isMatch(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++ ) {
            char c = str.charAt(i);
            if (c != '{'&& c != '}' && c != '[' && c != ']' && c != '(' && c != ')'){
                return false;
            }

            if(stack.isEmpty()){
                stack.push(c);
            }else {
                if(isMatch(stack.peek(),c)){  //是否配对
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    static boolean isMatch(char c1, char c2){
        if(c1 == '{' && c2 == '}')return true;
        if(c1 == '[' && c2 == ']')return true;
        if(c1 == '(' && c2 == ')')return true;
        return false;
    }

    //二分法查找  返回下标
    static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; //如果没有  返回-1
        }
        int p = 0;
        int q = nums.length - 1;
        return binarySearch(nums, target, p, q);

    }

    //二分查找
    static int binarySearch(int[] nums, int target, int p, int q) {
        if (p > q) {
            return -1; //没有
        }
        int mid = (p + q) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, q);
        } else {
            return binarySearch(nums, target, p, mid - 1);
        }
    }


    //~~~~~~~~~
    static String reversePinYin(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] ss = str.split(" ");

        //ssss test
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i] + " test");
        }
        //char[] chars = str.toCharArray();


        for (int i = 0; i < ss.length; i++) {
            sb.append(reverse(ss[i]));
            sb.append(' ');
        }
        return sb.toString();

    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length() - 1 - i));
        }
        return sb.toString();
    }
}
