public class FF{
    static double futureValue(double current,double rate,int years) {
        if(years==0) return current;
        return futureValue(current*(1+rate),rate,years-1);
    }
    static double futureValueDP(double current,double rate,int years) {
        double[] dp=new double[years+1];
        dp[0]=current;
        for(int i=1;i<=years;i++)
            dp[i]=dp[i-1]*(1+rate);
        return dp[years];
    }
    public static void main(String[] args) {
        double current=1000;
        double rate=0.1;
        int years=3;
        double fv1=futureValue(current,rate,years);
        System.out.println("Recursive: ₹"+fv1);
        double fv2=futureValueDP(current,rate,years);
        System.out.println("Optimized (DP): ₹"+fv2);
    }
}
