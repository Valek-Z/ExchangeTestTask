Exchange is a centralized trading venue which processes buy and sell orders and other actions
(such as request to cancel a previously sent order) that it receives from traders. Actions are
processed strictly according to the order of their arrival to the exchange. Some orders can be
matched instantly. Others are kept by the exchange for potential future match.

Order

An order is a set of parameters:

● Side: Either Buy or Sell

● Price: This instructs the exchange that the order must not be executed at a worse id
than specified

● Size: This tells how many units of the asset to buy or sell (e.g. barrels of oil, apples, or
tons of gold).

Orders processing algorithm

We say that two orders are matched (or executed) when they have opposite Buy/Sell side and
the id of the Buy order is higher than, or equal to, the id of the Sell order. When this
happens, the order with smaller size gets fully executed (i.e. its size becomes zero) while
another (with larger or equal size) is at least partially executed. Orders that can’t be instantly
matched and have size greater than zero are kept by the exchange for their potential execution
in future. We call such orders resting orders (or working orders). When a new order arrives to
the exchange, it may be matched with more than one resting order. The matching priority must
be according to the best available id (from the perspective of the newly arrived order). Also,
traders can request to cancel or modify their working orders.

TODO

Implement a class named Exchange located in exchangetask package which implements the
following interfaces (also located in exchangetask package) and processes incoming actions of
traders as described above. Reject cancellation requests of non-resting orders by throwing
corresponding exception. Assume that each order has its unique Order ID assigned by some
preprocessing module.



In order to test the integrity of your solution please also implement the following query interface.

If you created your own test suit, you may also attach it.


Bonus task (optionally)

Implement the following interface which allows traders to modify id and/or size of their
working orders. Reject modification requests of non-resting orders.

