package mypack;

import java.util.Scanner;
//import mypack.queue;

public class PriorityQueue< T >{
    public queue<parent<Val<T>>> leaf;
    //   public parent<Val<T>> tree;
    public PriorityQueue(){
       // System.out.println("priority queue has been created!");
        leaf = new queue<parent<Val<T>>>();
        //  tree = new parent<Val<T>>();
    }
    public void push( parent<Val<T>> temp ){
        leaf.pushback(temp);
        if (leaf.pointer.character.leftChild == null) {
            leaf.pointer.character.leftChild = temp;
            temp.prev = leaf.pointer.character;
        }
        else {
            leaf.pointer.character.rightChild = temp;
            temp.prev = leaf.pointer.character;
            leaf.pointer = leaf.pointer.next;
        }
        Val<T> c;
        while( temp.prev != null && temp.value.priorityVal > temp.prev.value.priorityVal ){
            c = temp.value;
            temp.value = temp.prev.value;
            temp.prev.value = c;
            temp = temp.prev;
        }
    }
    public parent<Val<T>> pop(){
        Val<T> c;
        c = leaf.out.character.value;
        leaf.out.character.value = leaf.element.character.value;
        leaf.element.character.value = c;
        if( leaf.pointer.character.leftChild != null ){
            leaf.pointer.character.leftChild = null;
        }
        else{
            leaf.pointer = leaf.pointer.prev;
            leaf.pointer.character.rightChild = null;
        }//System.out.println();display();
        parent<Val<T>> temp = leaf.popback();//System.out.println( temp.value.value );//display();
        if( isEmpty() )
            return temp;
        parent<Val<T>> template = leaf.out.character;
        boolean left = true, right = true;
        while( left || right ){
            left = right = false;
            if( template.rightChild != null &&  template.value.priorityVal < template.rightChild.value.priorityVal
                    && template.rightChild.value.priorityVal > template.leftChild.value.priorityVal ){
                c = template.value;
                template.value = template.rightChild.value;
                template.rightChild.value = c;
                template = template.rightChild;
                right = true;
            }
            else{
                if( template.leftChild != null &&  template.value.priorityVal < template.leftChild.value.priorityVal ) {
                    c = template.value;
                    template.value = template.leftChild.value;
                    template.leftChild.value = c;
                    template = template.leftChild;
                    left = true;
                }
            }
        }
        return temp;
    }
    public boolean isEmpty(){
        return leaf.isEmpty();
    }
   /* void display(){
        list1<parent<Val<T>>> temp = leaf.out;
        while( temp != null ){
            System.out.print( temp.character.value.value + "/");
            temp = temp.next;
        }
    }*/
}