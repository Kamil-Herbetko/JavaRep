package Obserwator;

import Obserwator.Observable.StockGrabber;
import Obserwator.Observer.StockObserver1;
import Obserwator.Observer.StockObserver2;
import Obserwator.Threads.GetTheStock;



public class Main {
    public static void main(String[] args) {


        StockGrabber stockGrabber = new StockGrabber();
        StockObserver1 stockObserver1 = new StockObserver1(stockGrabber);
        StockObserver2 stockObserver2 = new StockObserver2(stockGrabber);

        Runnable getIBM = new GetTheStock(stockGrabber, 7, "IBM", 195.00);
        Runnable getAAPL = new GetTheStock(stockGrabber, 18, "AAPL", 650.00);
        Runnable getGOOG = new GetTheStock(stockGrabber, 30, "GOOG", 600.00);

        new Thread(getIBM).start();
        new Thread(getAAPL).start();
        new Thread(getGOOG).start();
    }
}
