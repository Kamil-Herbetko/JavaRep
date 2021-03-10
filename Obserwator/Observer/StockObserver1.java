package Obserwator.Observer;

import Obserwator.Observable.Subject;

public class StockObserver1 implements Observer{
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;
    private Subject stockGrabber;

    public StockObserver1(Subject stockGrabber){
        this.stockGrabber = stockGrabber;
        System.out.println("New Observer1 was created");
        stockGrabber.register(this);
    }

    public void update(double ibmPrice, double aaplPrice, double googPrice) {

        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printThePrices();

    }

    private void printThePrices(){

        System.out.println("\nIBM: " + ibmPrice + "\nAAPL: " +
                aaplPrice + "\nGOOG: " + googPrice + "\n");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
