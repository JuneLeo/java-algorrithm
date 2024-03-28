package com.algorithm.sample.leetcode;

import java.util.*;

public class StringAlg {

//    public static int lengthOfLongestSubstring(String s) {
//        int max = 1;
//        char[] array = new char[s.length()];
//        int index;
//        for (int i = 0; i < s.length(); i++) {
//            index = 0;
//            array[index] = s.charAt(i);
//
//            for (int j = i + 1; j < s.length(); j++) {
//                boolean has = false;
//                char two = s.charAt(j);
//                for (int k = 0; k <= index; k++) {
//                    if (two == array[k]) {
//                        has = true;
//                    }
//                }
//                if (!has) {
//                    array[++index] = two;
//                    if (index > max) {
//                        max = index + 1;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//        return max;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.print(lengthOfLongestSubstring("宋鹏飞"));
//    }

    //    public static void main(String[] args) {
//        int[] array1 = {1, 2};
//        int[] array2 = {3, 4};
//        double medianSortedArrays = findMedianSortedArrays(array1, array2);
//        System.out.print(medianSortedArrays);
//    }


///////////////////////////////////////////
// 最长回文子串

///////////////////////////////////////////

    /**
     * 输入：s = "babad"   输出："bab"
     * 输入：s = "cbbd"    输出："bb"
     * abcbd
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] array = new char[s.length()];
        String label = "";
        int index;
        for (int a = 0; a < s.length(); a++) {
            index = 0;
            for (int i = a; i < s.length(); i++) {
                if (index == 0) {
                    array[index++] = s.charAt(i);
                } else {
                    array[index] = s.charAt(i);
                    boolean pass = true;
                    //abbbc 0和4  5   2
                    // abbb 0和3  4   1
                    // abb 0和2   3   1
                    // ab   0和1  2   0
                    for (int j = 0; j <= index / 2; j++) {
                        if (array[j] != array[index - j]) {
                            pass = false;
                            break;
                        }
                    }
                    if (pass) {
                        String tmp = "";
                        for (int i1 = 0; i1 <= index; i1++) {
                            tmp += array[i1];
                        }
                        if (tmp.length() > label.length()) {
                            label = tmp;
                        }
                    }
                    index++;
                }

            }
        }
        return label;
    }

//    public static void main(String[] args) {
//        System.out.print(longestPalindrome("abcdefed"));
//    }


///////////////////////////////////////////
// Z 字形变换

    ///////////////////////////////////////////
    public static String convert(String s, int numRows) {
        // n行
        // 0和n 是全排，1 - n-1 只排一个
        //
        // 先定义数组大小
        // length = s.length()
        // 如果 numRows > 1
        // numRows * 2 + numRotws - 2
        int col = 0;
        int index = 0;
        int lastIndex = s.length() - 1;
        while (true) {
            if (numRows == 1 || col % (numRows - 1) == 0) {
                if (lastIndex - index > numRows) {
                    index += numRows;
                    col++;
                } else {
                    break;
                }
            } else {
                if (lastIndex - index > 1) {
                    index++;
                    col++;
                } else {
                    break;
                }
            }
        }
        char[][] array = new char[numRows][col + 1];
        int stringIndex = 0;
        int arrayRowIndex = 0;
        int arrayColIndex = 0;
        while (stringIndex <= lastIndex) {
            arrayRowIndex = 0;
            for (int i = 0; i < numRows; i++) {
                if (stringIndex <= lastIndex) {
                    array[arrayRowIndex][arrayColIndex] = s.charAt(stringIndex);
                    stringIndex++;
                    arrayRowIndex++;
                }
            }

            arrayRowIndex--;

            for (int i = 2; i < numRows; i++) {
                if (stringIndex <= lastIndex) {
                    arrayColIndex++;
                    arrayRowIndex--;
                    array[arrayRowIndex][arrayColIndex] = s.charAt(stringIndex);
                    stringIndex++;
                }
            }
            arrayColIndex++;
        }

        String label = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    label += array[i][j];
                }
            }
        }
        return label;
    }


//    public static void main(String[] args) {
//        System.out.print(convert("A", 1));
//    }


    public static int myAtoi(String s) {
        String label = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '-':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    int length = label.length();
                    if (length == 1 && label.charAt(0) == '-') {
                        if (c == '-' || c == '0') {
                            continue;
                        }
                    } else if (length == 0) {
                        if (c == '0') {
                            continue;
                        }
                    }
                    if (label.contains("-")) {
                        if (label.length() > 11) {
                            break;
                        }
                    } else {
                        if (label.length() > 10) {
                            break;
                        }
                    }


                    label += c;
            }
        }
        long tmp = Long.parseLong(label);
        while (true) {
            if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
                tmp = tmp / 10;
                continue;
            }
            break;
        }

        System.out.print(tmp);
        return (int) tmp;
    }

//    public static void main(String[] args) {
//        myAtoi(" -2147483649");
//    }

    //
    //有效的括号
    //
    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }

        };

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                Character last = stack.getLast();
                Character character = map.get(c);
                if (character != null && character.equals(last)) {
                    stack.pollLast();
                } else {
                    stack.addLast(c);
                }
            } else {
                stack.addLast(c);
            }


        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(isValid("([)]"));
//    }


    //
    //括号生成
    //
    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    public static List<String> generateParenthesis2(int n) {
        List<String> composes = new ArrayList<>();
        backtrack(composes, new StringBuilder(), 0, 0, n);
        return composes;
    }

    private static void backtrack(List<String> composes, StringBuilder str, int open, int close, int max) {
        if (str.length() == 2 * max) {
            composes.add(str.toString());
            return;
        }
        if (open < max) {
            str.append('(');
            backtrack(composes, str, open + 1, close, max);
            str.deleteCharAt(str.length() - 1);
        }

        if (close < open) {
            str.append(')');
            backtrack(composes, str, open, close + 1, max);
            str.deleteCharAt(str.length() - 1);
        }
    }


    //    public static void main(String[] args) {
//        generateParenthesis2(3);
//    }
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            boolean has = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    has = false;
                    break;
                }
            }
            if (has) {
                return i;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        System.out.println(strStr("sadbutsad", "tsad"));
//    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>();
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"word", "good", "best", "word"};
        List<Integer> lists = findSubstring("wordgoodgoodgoodbestword", words);
        for (Integer list : lists) {
            System.out.print(list + ",");
        }
    }

}
