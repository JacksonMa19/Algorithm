package Question;

public class Part10 {
    //动态规划，求解金矿问题
    public static int getBestGoldMining(int w, int n, int[] p, int[] g) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (w < p[n-1]) {
            return getBestGoldMining(w, n-1, p, g);
        }
        return Math.max(getBestGoldMining(w,n-1,p,g),getBestGoldMining(w-p[n-1],n-1,p,g) + g[n-1]);
    }

    public static int getBestGoldMiningV2(int w, int n, int[] p, int[] g) {
        int[][] resultTable = new int[g.length + 1][w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i-1]) {
                    resultTable[i][j] = resultTable[i-1][j];
                } else {
                    resultTable[i][j] = Math.max(resultTable[i -1][j], resultTable[i-1][j-p[i-1]] + g[i-1]);
                }
            }
        }
        return resultTable[g.length][w];
    }

    public static void main(String[] args) {
        int w = 10;
        int [] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};
        System.out.println(getBestGoldMiningV2(w,g.length,p,g));

    }


}
