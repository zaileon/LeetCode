
public class BuySellStockCooldown {
	public int maxProfit(int[] prices) {
        int prev_buy = 0, prev_sell = 0, buy = Integer.MIN_VALUE, sell = 0;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(buy, prev_sell - price);
            prev_sell = sell;
            sell = Math.max(sell, prev_buy + price);
        }
        return sell;
    }
}
