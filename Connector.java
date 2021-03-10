import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Connector {
    private static Strategy strategy;

    public static int[][] mnożenie(){
        int[][] a = readMatrix("mac1.txt");
        int[][] b = readMatrix("mac2.txt");
        strategy = new Multiply();
        return strategy.calculate(a, b);
    }

    public static int[][] maxMin(){
        int[][] a = readMatrix("mac1.txt");
        int[][] b = readMatrix("mac2.txt");
        strategy = new MaxMin();
        return strategy.calculate(a, b);
    }

    private static int[][] readMatrix(String fileName){
        ArrayList<ArrayList<String> > array = new ArrayList<>();
        String wiersz;

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while((wiersz = reader.readLine() ) != null )
            {
                array.add(new ArrayList<String>(Arrays.asList(wiersz.split(" "))));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        int x = 0;
        int[][] result = new int[array.size()][array.get(0).size()];

        for(ArrayList<String> i : array){
            int y = 0;

            for(String j : i){
                result[x][y] = Integer.parseInt(j);
                y++;
            }

            x++;
        }

        return result;
    }

    public static String drukujMacierz(int[][] macierz){
        String s = "";
        for (int i = 0; i < macierz.length; i++) {

            for (int j = 0; j < macierz[0].length; j++) {
                s += macierz[i][j] + "  ";
            }

            s += "\n";
        }

        return s;
    }
}
