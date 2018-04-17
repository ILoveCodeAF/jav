import java.util.Scanner;

class lcs{
    String s1,s2;
    lcs(){}
    void init( Scanner inp ){
        s1 = inp.nextLine();
        s2 = inp.nextLine();
    }
    int max( int a, int b, int c ){
        int temp;
        if( a>b )
            temp = a;
        else
            temp = b;
        if( temp>c )
            return temp;
        return c;
    }
    int solve(){
        char[] c1 = new char[s1.length()];
        char[] c2 = new char[s2.length()];
        int[] matrix = new int[ (c1.length+1)*(c2.length+1) ];
        int i = 0;
        while( i<c1.length ){
            c1[i] = s1.charAt(i);
            ++i;
        }
        i = 0;
        while( i<c2.length ){
            c2[i] = s2.charAt(i);
            ++i;
        }
        i = 1;
        int j = 1;
        while( i<c1.length+1 ){
            j = 1;
            while( j<c2.length+1 ){
                if( c1[i-1] == c2[j-1] )
                    matrix[i*(c2.length+1)+j] = matrix[(i-1)*(c2.length+1)+j-1]+1;
                else
                    matrix[i*(c2.length+1)+j] = max( matrix[(i-1)*(c2.length+1)+j], matrix[i*(c2.length+1)+j-1],
                            matrix[(i-1)*(c2.length+1)+j-1]);
                ++j;
            }
            ++i;
        }
        return matrix[(c1.length+1)*(c2.length+1)-1];
    }
    public static void main(String[] args){
        lcs temp = new lcs();
        Scanner inp = new Scanner(System.in);
        temp.init(inp);
        System.out.println(temp.solve());
        return;
    }
}