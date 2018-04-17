import java.util.Scanner;

class hethongmecung{
    int n;
    int[] array;
    hethongmecung(){}
    void init( Scanner inp ){
        n = inp.nextInt();
        array = new int[n];
        int i = 0;
        while( i<n ){
            array[i] = inp.nextInt();
            ++i;
        }
    }
    int ucln( int n1, int n2 ){
        int r;
        while( n2 != 0){
            r = n1%n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }
    int solve(){
        int[] arrUC = new int[n*n];
        int min = Integer.MAX_VALUE;
        int temp = 0, uc = 0;
        int i = 0, j = 0;
        while( i<n ){
            j = 0;
            temp = 0;
            while( j<n ){
                if( i != j && arrUC[i*n+j] == 0 ){
                    arrUC[i*n+j] = arrUC[j*n+i] = ucln(array[i], array[j]);
                }
                if ( arrUC[i*n+j] != 1 )
                    temp += arrUC[i*n+j];
                ++j;
            }
            if( temp<min )
                min = temp;
            ++i;
        }
        /*i = 0;
        j = 0;
        while( i<n ){
            j = 0;
            while( j<n ){
                System.out.print(arrUC[i*n+j]+" ");
                ++j;
            }
            System.out.println();
            ++i;
        }*/
        return min;
    }
    public static void main( String[] args ){
        Scanner inp = new Scanner(System.in);
        hethongmecung temp = new hethongmecung();
        temp.init(inp);
        System.out.println(temp.solve());
        return;
    }
}