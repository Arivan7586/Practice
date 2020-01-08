package practice2020.test1_8;

public class Practice1_8 {

    public static void main(String[] args) {
//        String[] words = {"cat","bt","hat","tree"};
//        String chars = "atach";
//        System.out.println(new Solution().countCharacters(words,chars));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.tribonacci(25));

    }
}


/**
 * 拼写单词 （LeetCode 1160）
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』
 * （字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        int length = 0;
        for (int i = 0; i < words.length; i++) {
            length += getLength(chars, words[i]);
        }
        return length;
    }

    private int getLength(String chars, String word) {
        int length = 0;
        for (int i = 0; i < word.length(); i++) {
            String v = String.valueOf(word.charAt(i));
            if (chars.contains(v)) {
                length++;
                chars = chars.replaceFirst(v, "");
            } else {
                return 0;
            }
        }
        return length;
    }
}

/**
 * 第N个泰波那契数列 （LeetCode 1137）
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
class Solution1 {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        } else if (n == 2) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int c = 1;
            int value = 0;
            while (n >= 3) {
                value = a + b + c;
                a = b;
                b = c;
                c = value;
                n--;
            }
            return value;
        }
    }
}