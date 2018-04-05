package mypack;

import java.util.Scanner;

public class mergesort{
    queue<vector> q;
    int[] a;
    public mergesort(){
        q = new queue<vector>();
    }
    public mergesort( int[] arr ){
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
        //vector test;
        vector v = new vector();
        v.beg = 0;
        v.end = a.length-1;
        q.pushback(v);
        boolean stop = false;
        vector v1;
        int i;
        while( true ){
            v = q.pop();
            if( v.end-v.beg>=2 ){
                v1 = new vector();
                v1.beg = (v.beg+v.end)/2+1;
                v1.end = v.end;
                q.push(v1);
                v1 = new vector();
                v1.beg = v.beg;
                v1.end = (v.end + v.beg )/2;
                q.push(v1);
            }
            else{
                if( v.end != v.beg && a[v.beg]>a[v.end] ){
                    i = a[v.end];
                    a[v.end] = a[v.beg];
                    a[v.beg] = i;
                }
                q.pushback(v);
                if( v.end == a.length-1 )
                    break;
            }
        }//display();
        int j;
        queue<Integer> tempQ = new queue<Integer>();
        while( true ){
            v = q.pop();
            if( q.isEmpty() )
                break;
            if( v.end == a.length-1)
                q.pushback(v);
            else{
                v1 = q.pop();
                i = v.beg;
                j = v1.beg;
                while( i<=v.end && j<=v1.end ){
                    if( a[i]<a[j] ){
                        tempQ.pushback(a[i]);
                        i++;
                    }
                    else{
                        tempQ.pushback(a[j]);
                        j++;
                    }
                }
                while( i<=v.end ){
                    tempQ.pushback(a[i]);
                    ++i;
                }
                while( j<=v1.end ){
                    tempQ.pushback(a[j]);
                    j++;
                }
                i = v.beg;
                while( !tempQ.isEmpty() ){
                    a[i] = tempQ.pop();
                    ++i;
                }
                v.end = v1.end;
                q.pushback(v);
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