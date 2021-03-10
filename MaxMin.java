public class MaxMin implements Strategy{
    @Override
    public int[][] calculate(int[][] a, int[][] b){
        int[][] tab = new int[a.length][b[0].length];

        for(int i = 0; i < a.length; ++i){
            for(int j = 0; j < b[0].length; ++j){
                for(int k = 0; k<a[0].length; ++k){
                    tab[i][j] = Math.max(tab[i][j], Math.min(a[i][k], b[k][j]));
                }
            }
        }

        return tab;
    }
}
