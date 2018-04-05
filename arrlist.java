package mypack;

import java.util.Scanner;

public class arrlist<T>{
    public T element;
    arrlist<T> next;
    public arrlist(){}
    public arrlist(int n){
        if( n>1 )
            next = new arrlist<T>();
        n--;
        arrlist<T> t1, t2 = next;
        while( n>1 ){
            t1 = new arrlist<T>();
            t2.next = t1;
            t2 = t2.next;
            n--;
        }
    }
    public arrlist<T> pos( int n ){
        arrlist<T> temp = this;
        while( n>0 ){
            temp = temp.next;
            n--;
        }
        return temp;
    }
}