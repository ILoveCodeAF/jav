package mypack;

import java.util.Scanner;

class list<T>{
    public T charecter;
    public list<T> next;
}

public class stack<T>{
    public list<T> element;
    //public int position;
    public stack(){
        //position = -1;
    }
    void push( T c ){
        list<T> temp = new list<>();
        temp.charecter = c;
        temp.next = element;
        element = temp;
    }
    T pop(){
        T c = element.charecter;
        element = element.next;
        return c;
    }
    T get(){
        return element.charecter;
    }
    boolean isEmpty(){
        if( element == null )
            return true;
        return false;
    }
    void display(){
        list<T> temp = element;
        while( temp != null ){
            System.out.print(temp.charecter);
            temp = temp.next;
        }
        System.out.println();
    }
}