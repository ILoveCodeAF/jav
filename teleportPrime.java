import mypack.PriorityQueue;
import mypack.Val;
import mypack.parent;
import java.util.Scanner;

class digitPrimeNumb{
    int n;
    char[] digit;
    void init(){
        int temp = n;
        int i = 0;
        while( temp!=0 ){
            i++;
            temp/=10;
        }
        digit = new char[i];
        temp = n;
        i = i-1;
        while( temp!=0 ) {
            digit[i] = (char)(temp % 10 + '0');
            temp /= 10;
            i--;
        }
    }
    void display(){
        int i = 0;
        while( i<digit.length )
        {
            System.out.print(digit[i]+" ");
            ++i;
        }
        System.out.println();
    }
    int thesame4digits( digitPrimeNumb temp ){
        int count = 0;
        if( digit[0]==temp.digit[0] )
            count++;
        if( digit[1]==temp.digit[1] )
            count++;
        if( digit[2]==temp.digit[2] )
            count++;
        if( digit[3]==temp.digit[3] )
            count++;
        return count;
    }
}
class teleportPrime{
    PriorityQueue<Integer> pQueue;
    //int beg, end;a
    boolean[] isNotPrimeNumb;
    digitPrimeNumb begNumb;
    digitPrimeNumb endNumb;
    digitPrimeNumb[] digitNumb;
    void init( Scanner inp ){
        begNumb = new digitPrimeNumb();
        endNumb = new digitPrimeNumb();
        begNumb.n = inp.nextInt();
        begNumb.init();
        begNumb.display();
        endNumb.n = inp.nextInt();
        endNumb.init();
        endNumb.display();

        pQueue = new PriorityQueue<Integer>();
        parent<Val<Integer>> temp = new parent<Val<Integer>>();
        temp.value = new Val<Integer>();
        temp.value.value = 5;
        temp.value.priorityVal = 5;
        pQueue.push( temp );
        pQueue.pop();
        if( pQueue.isEmpty() )
            System.out.println("empty!");

        int i = 1;
        isNotPrimeNumb = new boolean[10000];
        digitNumb = new digitPrimeNumb[10000];
        if( isNotPrimeNumb[0] == false )
            System.out.println("false!");
        isNotPrimeNumb[0] = true;
        while( i<10000 ){
            if( isNotPrimeNumb[i]==false ){
                if( isPrime(i) ){
                    isNotPrimeNumb[i] = false;
                    digitNumb[i] = new digitPrimeNumb();
                    digitNumb[i].n = i;
                    digitNumb[i].init();
                    notPrimeNumb(i);
                }
                else
                    isNotPrimeNumb[i] = true;
            }
            ++i;
        }
    }
    void notPrimeNumb( int n ){
        int i = 2*n;
        while( i<10000 ){
            isNotPrimeNumb[i] = true;
            i+=n;
        }
    }
    boolean isPrime(int n){
        if( n<2 )
            return false;
        int i = 2;
        while( i*i<=n ){
            if( n%i == 0 )
                return false;
            ++i;
        }
        return true;
    }
    int stepnumb(){
        if( begNumb.thesame4digits(endNumb)==4 )
            return 0;
      //  System.out.println("here");
        digitPrimeNumb t = new digitPrimeNumb();
        parent<Val<Integer>> temp = new parent<Val<Integer>>();
        temp.value = new Val<Integer>();
        parent<Val<Integer>> temp1 = new parent<Val<Integer>>();
        temp1.value = new Val<Integer>();
        temp.value.value = begNumb.n;
        temp.value.priorityVal = 4-begNumb.thesame4digits( endNumb );
        System.out.println("step = "+temp.value.priorityVal);
        temp.value.priorityVal = -temp.value.priorityVal;
        pQueue.push( temp );
        if(pQueue.isEmpty())
            System.out.println("wtf");
        int i = 0;
        while( !pQueue.isEmpty() ){
            temp1 = pQueue.pop();
            t.n = temp1.value.value;//System.out.println("here");
            t.init();
            i = 0;
            for( i = 1000; i<10000; ++i ){
                if( isNotPrimeNumb[i] == false && t.thesame4digits( digitNumb[i] ) == 3 ){
                    temp = new parent<Val<Integer>>();
                    temp.value = new Val<Integer>();
                    temp.value.value = i;
                    temp.value.priorityVal = -temp1.value.priorityVal -(4-t.thesame4digits( endNumb ))+1+
                            4-digitNumb[i].thesame4digits( endNumb );
                    System.out.println("step = "+temp.value.priorityVal);
                    temp.value.priorityVal = -temp.value.priorityVal;
                    if( digitNumb[i].thesame4digits(endNumb)==4 )
                        return -temp.value.priorityVal;
                    pQueue.push( temp );
                }
            }
        }
        return 0;
    }
    public static void main( String[] args ){
        Scanner inp = new Scanner( System.in );
        teleportPrime temp = new teleportPrime();
        temp.init( inp );
        System.out.println( temp.stepnumb() );
        return;
    }
}