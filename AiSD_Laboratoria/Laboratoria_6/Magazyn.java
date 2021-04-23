package AiSD_Laboratoria.Laboratoria_6;

import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.EmptyQueueException;
import AiSD_Ćwiczenia.Ćwiczenia_2_2.Exceptions.FullQueueException;

public class Magazyn {
    private ListQueue<Klient> lista_klientów;

    public Magazyn(String[] nazwyKlientów, String[][] nazwy, int[][] ilości, double[][] ceny) throws FullQueueException {
        this.lista_klientów = new ListQueue<>();
        for (int i = 0; i < nazwyKlientów.length; i++) {
            lista_klientów.enqueue(new Klient(nazwyKlientów[i], nazwy[i], ilości[i], ceny[i]));
        }
    }

    public ListQueue<Klient> getLista_klientów() {
        return lista_klientów;
    }

    public void setLista_klientów(ListQueue<Klient> lista_klientów) {
        this.lista_klientów = lista_klientów;
    }

    public double zrealizuj() throws EmptyQueueException {
        double przychód_z_magazynu = 0;

        while (!lista_klientów.isEmpty()){
            Klient klient = lista_klientów.dequeue();
            double do_zapłaty = klient.do_zapłaty();
            przychód_z_magazynu += do_zapłaty;
            System.out.println("Zlecenie zrealizowane: " + klient.getNazwa_klient() + String.format(", kwota do zapłaty = %.2f", do_zapłaty));
        }

        return przychód_z_magazynu;
    }
}
