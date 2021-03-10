package PSiO;

public class Zad_4 {
    public static void Image(int ramie){
        if (ramie>0) {
            System.out.println("Gwiazda o długości ramienia: " + ramie);
        }
        if (ramie == 1){
            System.out.print('*');
        }
        if (ramie > 1){
            // Definiujemy zmienne

            int spacje_przed = (ramie-1)*4 + 1;
            int spacje_pomiędzy = 1;

            // Główna pętla rysująca gwiazdę
            for (int i = 1; i < ((ramie)*4 - 1); i++){
                // Czubek gwiazdy
                if (i == 1) {

                    Drukuj_spacje(spacje_przed);
                    System.out.println('*');

                    spacje_przed -= 1;
                }
                // Górne ramiona
                if (i < ramie) {

                    Drukuj_spacje(spacje_przed);
                    System.out.print('*');
                    Drukuj_spacje(spacje_pomiędzy);
                    System.out.println('*');

                    spacje_przed -= 1;
                    spacje_pomiędzy += 2;

                }
                // Pierwsze boczne ramiona (idąc od góry)
                if (i == ramie) {

                    System.out.print('*');
                    Drukuj_poziome_gwiazdy(ramie, "  *");
                    Drukuj_spacje(spacje_pomiędzy);
                    Drukuj_poziome_gwiazdy(ramie, "*  ");
                    System.out.println('*');

                    spacje_przed = 1;
                    spacje_pomiędzy += ramie*6 - 8;

                }
                // Drugie boczne ramiona
                if ((i > ramie) && (i < (ramie*2 -1))){

                    Drukuj_spacje(spacje_przed);
                    System.out.print('*');
                    Drukuj_spacje(spacje_pomiędzy);
                    System.out.println('*');

                    spacje_przed += 1;
                    spacje_pomiędzy -= 2;

                }
                // Trzecie boczne ramiona
                if ((i >= (ramie*2 -1)) && (i < (ramie*3 - 2))){

                    Drukuj_spacje(spacje_przed);
                    System.out.print('*');
                    Drukuj_spacje(spacje_pomiędzy);
                    System.out.println('*');

                    spacje_przed -= 1;
                    spacje_pomiędzy += 2;

                }
                // Czwarte dolne ramiona
                if (i == (ramie*3 - 2)){

                    spacje_pomiędzy -= ramie*6 - 6;

                    System.out.print('*');
                    Drukuj_poziome_gwiazdy(ramie, "  *");
                    Drukuj_spacje(spacje_pomiędzy);
                    Drukuj_poziome_gwiazdy(ramie, "*  ");
                    System.out.println('*');

                    spacje_przed = ramie*3 -2;
                    spacje_pomiędzy -= 2;

                }
                // Dolne ramiona
                if ((i > (ramie*3 - 2)) && (i <= ((ramie)*4 - 3))){

                    Drukuj_spacje(spacje_przed);
                    System.out.print('*');
                    Drukuj_spacje(spacje_pomiędzy);
                    System.out.println('*');

                    spacje_przed += 1;
                    spacje_pomiędzy -= 2;

                }
                // Dolny czubek
                if (i == ((ramie)*4 - 2)){
                    Drukuj_spacje(spacje_przed);
                    System.out.println('*');

                }
            }
        }
    }
    private static void Drukuj_spacje(int x){
        for (int i = 1; i <= x; i++) {
            System.out.print(' ');
        }
    }
    private static void Drukuj_poziome_gwiazdy(int a, String b){
        for (int i = 1; i < a; i++){
            System.out.print(b);
        }
    }
}
