package mypack;

import java.util.Scanner;

public class parent<T>{
    public T value;
    //  public int priorityVal;
    parent<T> rightChild;
    parent<T> leftChild;
    parent<T> prev;
    public parent(){
        // value = new T();
    }
    public void setValue( T val ){
        value = val;
    }
   /* void display(){
        value.display();
    }*/
}