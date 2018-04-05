package mypack;

import java.util.Scanner;
//import mypack.Val;
//import mypack.parent;
//import mypack.queue;
//import mypack.PriorityQueue;

public class heapsort{
    public int[] a;
    public PriorityQueue<Integer> pQueue;
    public heapsort(){
        //System.out.println("heapsort");
        pQueue = new PriorityQueue<Integer>();
    }
    public heapsort( int[] arr ){
        pQueue = new PriorityQueue<Integer>();
        a = arr;
        int i = 0;
        parent<Val<Integer>> temp;
        while( i<arr.length ){
            temp = new parent<Val<Integer>>();
            temp.value = new Val<Integer>();
            temp.value.priorityVal = -a[i];
            temp.value.value = a[i];
            pQueue.push(temp);
            ++i;
        }
        sort();
    }
    void init( Scanner inp ) {
        int n = inp.nextInt(), i = 0;
        a = new int[n];
        parent<Val<Integer>> temp;
        while (i < n) {
            a[i] = inp.nextInt();
            temp = new parent<Val<Integer>>();
            temp.value = new Val<Integer>();
            temp.value.priorityVal = -a[i];
            temp.value.value = a[i];
            //System.out.println("here");
            pQueue.push(temp);
            ++i;
        }
    }
    void sort(){
        int i = 0;
        parent<Val<Integer>> temp;
      //  temp = new parent<Val<Integer>>();
        while( !pQueue.isEmpty() ){
           // temp = new parent<Val<Integer>>();
            temp = pQueue.pop();
           // System.out.println(temp.value.value);
            a[i] = temp.value.value;
            ++i;
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