import java.util.Scanner;

class SubsetSum{
    int givenSum;
    int[] array;
    SubsetSum(){}
    void init( Scanner inp ){
        givenSum = inp.nextInt();
        int n = inp.nextInt();
        int i = 0;
        array = new int[n];
        while( i<n ) {
            array[i] = inp.nextInt();
            ++i;
        }
    }
    boolean isSubsetSum(){
        boolean[] dp = new boolean[ (array.length+1)*( givenSum+1 ) ];
        int i = 0;
        while( i<array.length+1 ){
            dp[i*(givenSum+1)] = true;
            ++i;
        }
        i = 1;
        while( i<givenSum+1 ){
            dp[i] = false;
            ++i;
        }
        i = 1;
        int j = 1;
        while( i<array.length+1 ){
            j = 1;
            while (j<givenSum+1){
                if( j<array[i-1] ){
                    dp[i*(givenSum+1)+j] = dp[(i-1)*(givenSum+1)+j];
                }
                else{
                    dp[i*(givenSum+1)+j] = dp[(i-1)*(givenSum+1)+j] || dp[(i-1)*(givenSum+1)+j-array[i-1]];
                }
                ++j;
            }
            ++i;
        }
        i = j = 0;
        while( i<array.length+1 ){
            j = 0;
            while (j<givenSum+1){
                System.out.print(dp[i*(givenSum+1)+j]+"   ");
                ++j;
            }
            System.out.println();
            ++i;
        }
        return dp[(givenSum+1)*(array.length+1)-1];
    }
    public static void main( String[] args ){
        Scanner inp = new Scanner(System.in);
        SubsetSum temp = new SubsetSum();
        temp.init(inp);
        if( temp.isSubsetSum() ){
            System.out.println("YES");
        }
        else
            System.out.println("NOPE");
        return;
    }
}