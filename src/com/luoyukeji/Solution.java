package com.luoyukeji;

import java.util.HashMap;

/**
 * 409. 最长回文串
 * 简单
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串的长度。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */
public class Solution {
    public int longestPalindrome(String s) {
        //创建一个哈希表记录每个字符的出现次数
        HashMap<Character, Integer> countMap = new HashMap<>();

        //遍历字符串没统计每个字符出现的次数
        for(char c : s.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }

        int length = 0;
        boolean oddFound = false;  //是否已使用一个奇数字符作为中心

        //遍历哈希表，计算可以用来构造回文串的字符个数
        for(int count : countMap.values()){

            //如果字符个数是偶数，则可以用来构造回文串
            if(count %2 ==0){
                length += count;
            }else{
                //如果字符的数量是奇数，最多能用count -1 哥字数
                length += count -1;
                //如果没用使用奇数个字符作为中心，允许使用一个字符作为中心
                oddFound = true;
            }
        }

        //如果找到奇数个字符。就可以在回文的中间方一个字符；
        if(oddFound){
            length += 1;
        }
return length;
        //
    }
}
