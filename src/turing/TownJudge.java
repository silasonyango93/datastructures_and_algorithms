package turing;

import org.junit.Test;

import java.util.*;

/*
* In a town, there are N people labelled from 1 to N. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge. Otherwise, return -1.

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
Note:

1 <= N <= 1000
trust.length <= 10000
trust[i] are all different
trust[i][0] != trust[i][1]
1 <= trust[i][0], trust[i][1] <= N
* */

public class TownJudge {
    public static int findJudge(int N, int[][] trust) {
        if (trust.length == 0) return 1;
        /**
         * Simple parents tracker
         * */
        int[] parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
        /**
         * Extracting the possible town judge
         * */
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] data : trust) {
            int a = data[0];
            int b = data[1];
            parents[a] = b;
            map.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            ArrayList<Integer> members = (ArrayList<Integer>) e.getValue();
            if (members.size() == N - 1) { //all the citizen except the judge
                int key = (int) e.getKey();
                if (parents[key] != key) return -1;// if judge trust someone else
                return (int) e.getKey();
            }
        }
        return -1;
    }

    @Test
    public void townJudgeFirstPositive() {
        int res = findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}});
        assert 3 == res;
    }

    @Test
    public void townJudgeSecondPositive() {
        int res = findJudge(2, new int[][]{{1, 2}, {2, 3}});
        assert -1 == res;
    }

    @Test
    public void townJudgeThirdPositive() {
        int res = findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}});
        assert -1 == res;
    }

    @Test
    public void townJudgeFourthPositive() {
        int res = findJudge(3, new int[][]{{1, 3}, {2, 3}});
        assert 3 == res;
    }

    @Test
    public void townJudgeFifthPositive() {
        int res = findJudge(4, new int[][]{{1, 2}, {1, 3}, {2, 1}, {2, 3}, {1, 4}, {4, 3}, {4, 1}});
        assert 3 == res;
    }
}
