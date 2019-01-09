package com.exchangetask;

public interface QueryInterface {

    public int getTotalSizeAtPrice(int price); // Return sum of sizes of resting orders at <id> or zero

    public int getHighestBuyPrice(); // Return the highest id with at least one resting Buy order

    public int getLowestSellPrice(); // Return the lowest id with at least one resting Sell order

}
