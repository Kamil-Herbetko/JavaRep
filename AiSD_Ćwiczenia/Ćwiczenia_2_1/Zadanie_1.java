package AiSD_Ćwiczenia.Ćwiczenia_2_1;

public class Zadanie_1 {
    public static void main(String[] args) {
        Student[] tabStudentów = new Student[15];
        String[] nazwiska = {"Kowalski", "Nowak", "Wiśniewski", "Morzymas", "Michalski", "Stankiewicz", "Lewandowski", "Wójcik", "Kowalczyk", "Szymański", "Kamiński", "Woźniak", "Rakoczy", "Wrona", "Rogal"};
        String[] imiona = {"Jan", "Szymon", "Michał", "Artur", "Jakub", "Mateusz", "Adam", "Witold", "Mikołaj", "Marcin", "Cyprian", "Piotr", "Kamil", "Henryk", "Ryszard"};
        Double[] oceny = {2.0, 3.0, 4.5, 3.5, 5.0, 5.5, 2.0, 2.0, 4.0, 3.0, 2.0, 2.0, 4.5, 5.0, 3.5};

        for (int i = 0; i < 15; i++) {
            tabStudentów[i] = new Student(100000 + i, nazwiska[i], imiona[i], oceny[i]);
        }

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        wyświetl_wszystkich(tabStudentów);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        wpisz_ocenę(tabStudentów, 100004, 3.5);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        wylicz_i_wypisz_z_oceną_pozytywną(tabStudentów);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        wypisz_studentów_oblanych(tabStudentów);

    }

    public static void wyświetl_wszystkich(Student[] tabStudentów){
        IteratorTablicy<Student> iteratorTablicy = new IteratorTablicy(tabStudentów);

        while (iteratorTablicy.hasNext()){
            System.out.println(iteratorTablicy.next().toString());
        }
    }

    public static void wpisz_ocenę(Student[] tabStudentów, int numer_indeksu, double ocena){
        IteratorFiltrujący<Student> iteratorFiltrujący = new IteratorFiltrujący<>(new IteratorTablicy<Student>(tabStudentów), new Predicate<Student>() {
            @Override
            public boolean accept(Student object) {
                return ((object.getNumer_indeksu()) == numer_indeksu);
            }
        });

        Student st = iteratorFiltrujący.next();

        if (st != null){
            st.setOcena(ocena);
        }
        else {
            System.out.println("Niestety, student o podanym numerze indeksu nie istnieje :(");
        }
    }

    public static void wylicz_i_wypisz_z_oceną_pozytywną(Student[] tabStudentów){
        IteratorFiltrujący<Student> iteratorFiltrujący = new IteratorFiltrujący<>(new IteratorTablicy<Student>(tabStudentów), (Student st) -> (st.getOcena() > 2.0));

        int n = 0;
        double suma = 0;
        while (iteratorFiltrujący.hasNext()){
            Student st = iteratorFiltrujący.next();
            if (st != null){
                suma += st.getOcena();
                n += 1;
            }
        }
        if (n > 0){
            System.out.println("Średnia ocen studentów którzy zaliczyli wynosi: " + suma/n);
        }
        else {
            System.out.println("Niestety nikt nie zaliczył :(");
        }
    }

    public static void wypisz_studentów_oblanych(Student[] tabStudentów){
        IteratorFiltrujący<Student> iteratorFiltrujący = new IteratorFiltrujący<>(new IteratorTablicy<Student>(tabStudentów),  (Student st) -> st.getOcena() == 2.0);
        while (iteratorFiltrujący.hasNext()){
            Student st = iteratorFiltrujący.next();
            if (st != null){
                System.out.println(st.toString());
            }
        }
    }

}
