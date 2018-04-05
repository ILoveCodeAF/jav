package mypack;

import java.util.Scanner;

class list1<T>{
    public T character;
    public list1<T> next;
    public list1<T> prev;
}
public class queue<T>{
    public list1<T> element;
    public list1<T> out;
    public list1<T> pointer;
    public queue(){
        //nothing
    }
    public void push( T c ){
        list1<T> temp = new list1<>();
        temp.character = c;
        temp.next = out;
        if( out != null )
            out.prev = temp;
        out = temp;
        if( element == null && pointer == null )
            element = pointer = out;
    }
    public void pushback( T c ){
        list1<T> temp = new list1<>();
        temp.character = c;
        temp.prev = element;
        if( element != null )
            element.next = temp;
        element = temp;
        if( out == null && pointer == null )
            out = pointer = element;
    }
    public T pop(){
        T c = out.character;
        out = out.next;
        if( out!=null )
            out.prev = null;
        else
            element = pointer = null;
        return c;
    }
    public T popback(){
        T c = element.character;
        element = element.prev;
        if( element!=null )
            element.next = null;
        else
            out = pointer = null;
        //   if( c == null ){
        // System.out.println("lol");
        //   }
        return c;
    }
    public T get(){
        return out.character;
    }
    public boolean isEmpty(){
        if( out == null )
            return true;
        return false;
    }
   /* void display(){
        /*T c = pop();
        System.out.println(c);
        list1<T> temp = out;
        while( temp != null ){
          //  System.out.print(temp.character);
            temp.character.
            temp = temp.next;
        }
        System.out.println();
    }*/
}