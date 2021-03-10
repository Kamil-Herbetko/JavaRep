package PSiO_Ćwiczenia.Kolokwium;

import java.io.Serial;

public class WłasnyWyjątek extends Exception{
    @Serial
    private static final long serialVersionUID = -7343275862788299597L;

    //TODO Własny wyjątek
    public WłasnyWyjątek(String s){
        super(s);
    }

    public WłasnyWyjątek(){
        super();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();

        System.out.println("Cośtam");
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "Coś tam coś tam";
    }
}
