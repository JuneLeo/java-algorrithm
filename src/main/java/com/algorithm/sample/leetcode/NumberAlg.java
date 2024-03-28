package com.algorithm.sample.leetcode;

import java.util.*;

public class NumberAlg {

    // 整数反转
    // 120 -》 21
    // 123 -》 321
    public static int reverse(int x) {
        int returnValue = 0;
        while (x != 0) {
            returnValue = returnValue * 10 + x % 10;
            x = x / 10;
        }
        if (returnValue < 0) {
            returnValue = 0;
        }

        return returnValue;
    }

//    public static void main(String[] args) {
//        System.out.print(reverse(Integer.MAX_VALUE));
//    }


    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        //12321
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return revertedNumber == x || revertedNumber / 10 == x;

    }

//    public static void main(String[] args) {
//        System.out.print(isPalindrome(12313321));
//    }


    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


//    public static void main(String[] args) {
//        isMatch("abcdefggg", "a.cd..g*");
//    }
    /////////////////////////
    // 最大面积
    /////////////////////////

    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int square = (j - i) * Math.min(height[i], height[j]);
                if (square > max) {
                    max = square;
                }
            }
        }

        return max;
    }

//    public static void main(String[] args) {
//        int [] height = {1,8,6,2,5,4,8,3,7};
//        System.out.print(maxArea(height));
//    }

    /////////////////////////
    // 13. 罗马数字转整数
    /////////////////////////
    public static String intToRoman(int num) {
        /**
         * I             1
         * IV            4
         * V             5
         * IX            9
         * X             10
         * XL            40
         * L             50
         * XC            90
         * C             100
         * CD            400
         * D             500
         * CM            900
         * M             1000
         *
         */


        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        // 1 <= num <= 3999
        String label = "";
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            while (num >= value) {
                label += symbols[i];
                num -= value;

            }
        }

        return label;
    }

//    public static void main(String[] args) {
//        System.out.print(intToRoman(3999));
//    }

    /////////////////////////
    // 最长公共前缀
    /////////////////////////
    public static String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String firstStr = strs[0];
        String label = "";

        for (int i = 0; i < firstStr.length(); i++) {
            char c = firstStr.charAt(i);
            boolean finish = false;
            for (int j = 1; j < count; j++) {
                String tmp = strs[j];
                if (i > tmp.length() - 1) {
                    finish = true;
                    break;
                }
                if (c != tmp.charAt(i)) {
                    finish = true;
                    break;
                }
            }

            if (finish) {
                break;
            }
            label += c;
        }
        return label;
    }

//    public static void main(String[] args) {
//        String[] strings = {"dog","racecar","car"};
//        System.out.print(longestCommonPrefix(strings));
//    }

    /////////////////////////
    // 三数之和
    /////////////////////////
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    int a = nums[i];
                    int b = nums[j];
                    int c = nums[k];
                    if (a + b + c == 0) {
                        boolean has = false;

                        for (List<Integer> l : lists) {
                            List<Integer> ll = new ArrayList<>();
                            ll.add(a);
                            ll.add(b);
                            ll.add(c);
                            for (Integer integer : l) {
                                ll.remove(integer);
                            }
                            if (ll.size() == 0) {
                                has = true;
                            }
                        }
                        if (!has) {
                            List<Integer> list = new ArrayList<>();
                            list.add(a);
                            list.add(b);
                            list.add(c);
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


//    public static void main(String[] args) {
//        int[] array = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
//        List<List<Integer>> lists = threeSum2(array);
//        for (List<Integer> list : lists) {
//            for (Integer integer : list) {
//                System.out.print(integer + ",");
//            }
//            System.out.println();
//        }
//    }


    //
    //最接近的三数之和
    //
    public static int threeSumClosest(int[] nums, int target) {
        int value = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int v = nums[i] + nums[j] + nums[k];
                    // v和value比较
                    //

                    if (Math.abs(target - v) < Math.abs(target - value) || value == 0) {
                        value = v;
                    }
                }
            }
        }
        return value;
    }

//    public static void main(String[] args) {
//        int[] values = {1,1,1,0};
//        System.out.println(threeSumClosest(values, -100));
//    }

    //
    //电话号码的字母组合
    //
    public static List<String> letterCombinations(String digits) {

        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        // 2345
        List<String> list = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return list;
        }
        traversalLetter(digits, 0, phoneMap, list, new StringBuffer());
        return list;
    }

    private static void traversalLetter(String digits, int index, Map<Character, String> phoneMap, List<String> list, StringBuffer str) {
        if (index >= digits.length()) {
            list.add(str.toString());
            return;
        }
        String s = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            traversalLetter(digits, index + 1, phoneMap, list, str);
            str.deleteCharAt(index);
        }
    }


    //    public static void main(String[] args) {
//        List<String> list = letterCombinations("23");
//        for (String s : list) {
//            System.out.println(s);
//        }
//    }
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }
        boolean negative = false;
        if (dividend < 0 || divisor < 0) {
            if (dividend > 0) {
                negative = true;
                divisor = -divisor;
            } else if (divisor > 0) {
                negative = true;
                dividend = -dividend;
            } else {
                dividend = -dividend;
                divisor = -divisor;
            }

        }

        int index = 0;
        while (true) {
            if (divisor * index > dividend) {
                break;
            }
            index++;
        }

        if (index > 0) {
            index--;
        }

        return negative ? -index : index;
    }

    public static void main(String[] args) {
        divide(-2147483648
                , -1);
    }

    //
    //    1，3，4，6，8，9
    //    2，3，4，5，9，0
    //    3，4，6，7，9，0
    //    2，3，3，4，5，6
    //


}

