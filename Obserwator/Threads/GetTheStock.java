package Obserwator.Threads;

import Obserwator.Observable.StockGrabber;
import Obserwator.Observable.Subject;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class GetTheStock implements Runnable{
    private int startTime;
    private String stock;
    private double price;
    private Subject stockGrabber;



    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock, double newPrice){
        this.stockGrabber = stockGrabber;
        this.startTime = newStartTime;
        stock = newStock;
        price = newPrice;

    }

    public void run(){

        while (true){

            try{

                Thread.sleep(startTime * 1000);

            }
            catch(InterruptedException e)
            {}

            double randNum = (Math.random() * (.06)) - .03;

            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            nf.setMaximumFractionDigits(2);
            DecimalFormat df = (DecimalFormat)nf;

            price = Double.parseDouble(df.format((price + randNum)));

            if(stock.equals("IBM")) ((StockGrabber) stockGrabber).setIBMPrice(price);
            if(stock.equals("AAPL")) ((StockGrabber) stockGrabber).setAAPLPrice(price);
            if(stock.equals("GOOG")) ((StockGrabber) stockGrabber).setGOOGPrice(price);

            System.out.println(stock + ": " + df.format((price)) +
                    " " + df.format(randNum));

            System.out.println();

        }
    }

}
