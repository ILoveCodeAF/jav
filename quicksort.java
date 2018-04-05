package mypack;

import java.util.Scanner;
//import mypack.queue;

class vector{
    public int beg;
    public int end;
}

public class quicksort{
    queue<vector> q;
    int[] a;
    public quicksort(){
        q = new queue<vector>();
    }
    public quicksort( int[] arr ){
        q = new queue<vector>();
        a = arr;
        sort();
    }
    void init( Scanner inp ){
        int i = 0;
        int n = inp.nextInt();
        a = new int[n];
        while( i<n ){
            a[i] = inp.nextInt();
            ++i;
        }
    }
    void sort(){
        vector v = new vector();
        v.beg = 0;
        v.end = a.length-1;
        q.pushback(v);
        int i, count;
        /*if( q.isEmpty() )
            System.out.println("wtf");*/
        while( !q.isEmpty() ){
            v = q.pop();
           // System.out.println("beg= "+v.beg +"   end="+v.end);
            i = count = v.beg;
            while( i<v.end ){
                if( a[i]<a[v.end] ){
                    if( i != count ) {
                        a[count] += a[i];
                        a[i] = a[count] - a[i];
                        a[count] = a[count] - a[i];
                        count++;
                    }
                    else
                        count++;
                }
                ++i;
            }
           // System.out.println("count="+count);
            if( count!=v.end ){
                a[count] += a[v.end];
                a[v.end] = a[count]-a[v.end];
                a[count] = a[count]-a[v.end];
            }
            if( count-v.beg >= 2 ){
                vector v1 = new vector();
                v1.beg = v.beg;
                v1.end = count-1;
                q.pushback(v1);
            }
            if( v.end-count >= 2 ){
                vector v1 = new vector();
                v1.beg = count+1;
                v1.end = v.end;
                q.pushback(v1);
            }
        }
    }
    public void display(){
        int i = 0;
        while( i<a.length ){
            System.out.print(a[i]+" ");
            ++i;
        }
        System.out.println();
    }
    public static void main( String[] args ){
        return;
    }
}