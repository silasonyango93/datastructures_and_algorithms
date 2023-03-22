package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int buyingPrice = Integer.MAX_VALUE;
        List<Number> profits = new ArrayList();
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyingPrice) {
                buyingPrice = prices[i];
            } else {
                profits.add(prices[i] - buyingPrice);
            }
        }
        if (profits.isEmpty()) {
            return 0;
        }
        if (profits.size() == 1) {
            return (int)profits.get(0);
        }
        profits.sort(Collections.reverseOrder());
        return (int)profits.get(0) + (int)profits.get(1);
    }

    @Test
    public void testSolution() {
        int [] prices1 = new int[] {7,1,5,3,6,4};
        assert 7 == maxProfit(prices1);
    }
}
