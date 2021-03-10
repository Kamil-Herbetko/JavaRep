package Obserwator.Observer;

import Obserwator.Observable.Subject;

public class StockObserver2 implements Observer {
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;
    private Subject stockGrabber;

    public StockObserver2(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
        System.out.println("New Observer2 was created");
        stockGrabber.register(this);
    }

    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        this.sayWhichStocksToBuyOrSell();
    }

    private void sayWhichStocksToBuyOrSell() {
        if (ibmPrice < 180) {
            System.out.println("Sugeruję kupić akcje IBM");
        } else if (ibmPrice > 220) {
            System.out.println("Sugeruję sprzedać akcje IBM");
        }
        if (aaplPrice < 620) {
            System.out.println("Sugeruję kupić akcje Apple");
        } else if (aaplPrice > 700) {
            System.out.println("Sugeruję sprzedać akcje Apple");
        }
        if (googPrice < 600) {
            System.out.println("Sugeruję kupić akcje Google");
        } else if (googPrice > 690) {
            System.out.println("Sugeruję sprzedać akcje Google");
        }

        System.out.println();
    }
}
