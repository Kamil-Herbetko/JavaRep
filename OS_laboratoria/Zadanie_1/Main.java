package OS_laboratoria.Zadanie_1;

import OS_laboratoria.Zadanie_1.Algorythms.FCFS;
import OS_laboratoria.Zadanie_1.Algorythms.RR;
import OS_laboratoria.Zadanie_1.Algorythms.SJF_bez_wyw;
import OS_laboratoria.Zadanie_1.Algorythms.SJF_wyw;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int quant = 5;
        int cycles = 20;
        int procesQuantity = 50;

        ArrayList<String> list = new ArrayList<>();
        ArrayList<Proces> proceses = new ArrayList<Proces>();

        double sumFCFS = 0;
        double sumSJF_z_wyw = 0;
        double sumRR = 0;
        double sumSJF_bez_wyw = 0;

        System.out.println("\nCałkowityCzasOczekiwania/IloscProcesow/IloscCykli\n");
        for (int j = 0; j < cycles; j++) {

            for (int i = 0; i < procesQuantity; i++) {
                Random r = new Random();
                int d = r.nextInt(100);
                int m = 1 + r.nextInt(100);
                proceses.add(new Proces(i, d, m, m, 0));
            }

            double fcfs = FCFS.FCFS(proceses);
            double sjf_wyw = SJF_wyw.SJF(proceses);
            double rr = RR.RR(quant, proceses);
            double sjf_bez_wyw = SJF_bez_wyw.SJF(proceses);

            System.out.println("FCFS: " + fcfs +" SJF_wyw: "  + sjf_wyw +" RR: "   + rr + " SJF_bez_wyw: " + sjf_bez_wyw);

            sumFCFS += fcfs;
            sumSJF_z_wyw += sjf_wyw;
            sumRR += rr;
            sumSJF_bez_wyw += sjf_bez_wyw;

            proceses.clear();
        }

        list.add("FCFS "+sumFCFS /(cycles));
        list.add("SJF z wyw "+sumSJF_z_wyw / (cycles));
        list.add("RR "+ sumRR / (cycles));
        list.add("SJF bez wyw "+sumSJF_bez_wyw / (cycles));
        System.out.println("\nAverage of all results:");
        System.out.println(list.toString());


        System.out.println("\nAnother stats:");
        System.out.println("AVG OF MAX WAITING TIME FCFS: " + FCFS.maxWaitingTime.stream().mapToDouble(a -> a).average().getAsDouble());

    }
}