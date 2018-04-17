import java.util.Scanner;

class coins{
    int givenValue;
    int[] coin;
    coins(){}
    void init(Scanner inp){
        givenValue = inp.nextInt();
        int n = inp.nextInt();
        coin = new int[n];
        int i = 0;
        while( i<n ){
            coin[i] = inp.nextInt();
            ++i;
        }
    }
    int solve(){
        int[] memoryArray = new int[givenValue+1];
        memoryArray[0] = 0;
        int i = 1;
        while( i<givenValue+1 ){
            memoryArray[i] = Integer.MAX_VALUE;
            ++i;
        }
       // System.out.println(Integer.MAX_VALUE);
        int j = 0, temp = 0;
        i = 1;
        while( i<=givenValue ){
            j = 0;
            while( j<coin.length ){
                if( coin[j]<=i ) {
                    temp = memoryArray[i - coin[j]];
                    if ( (temp != Integer.MAX_VALUE) && (temp + 1 < memoryArray[i]) ) {
                        memoryArray[i] = temp + 1;
                    }
                }
                ++j;
            }
            ++i;//fffgzgfd
        }
        return memoryArray[givenValue];
    }
    public static void main(String[] args){
        Scanner inp = new Scanner(System.in);
        coins temp = new coins();
        temp.init(inp);
        System.out.println(temp.solve());
        return;
    }
}