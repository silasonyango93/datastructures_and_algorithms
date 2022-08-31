package turing;

import java.util.HashMap;

/*
* Given an array of integers arr, a lucky integer is an integer that has a frequency in the array equal to its value.

Return the largest lucky integer in the array. If there is no lucky integer return -1.
* */

public class LuckyNumber {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap();
        int ret = -1;
        for(int x : arr) {
            map.put(x, map.getOrDefault(x,0) + 1);
        }
        for(int x : arr) {
            ret = (x == map.get(x)) ? Math.max(ret,x) : ret;
        }
        return ret;
    }
}
