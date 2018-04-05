import java.util.Scanner;
//import java.io.*;

class list<T>{
    public T charecter;
    public list<T> next;
}
class list1<T>{
    public T charecter;
    public list1<T> next;
    public list1<T> prev;
}

class stack<T>{
    public list<T> element;
    //public int position;
    stack(){
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
class queue<T>{
    public list1<T> element;
    public list1<T> out;
    queue(){
        //nothing
    }
    void push( T c ){
        list1<T> temp = new list1<>();
        temp.charecter = c;
        temp.prev = element;
        if( element != null )
            element.next = temp;
        element = temp;
        if( out == null )
            out = element;
    }
    T pop(){
        T c = out.charecter;
        out = out.next;
        if( out!=null )
            out.prev = null;
        return c;
    }
    T get(){
        return out.charecter;
    }
    boolean isEmpty(){
        if( out == null )
            return true;
        return false;
    }
    void display(){
        /*T c = pop();
        System.out.println(c);*/
        list1<T> temp = out;
        while( temp != null ){
            System.out.print(temp.charecter);
            temp = temp.next;
        }
        System.out.println();
    }
}
class bieuthuchauto{
    stack<Character> bt;
    String str;
    //char[] bthauto;
    queue<String> bthauto;
    bieuthuchauto(){
        bt = new stack<Character>();
        bthauto = new queue<String>();
    }
    void init( Scanner inp ){
        str = inp.nextLine();
       // bthauto = new char[ str.length() ];
    }
    int priorityOperator( char c ){
        if( c == '+' || c == '-' )
            return 1;
        if( c == '^' )
            return 3;
        return 2;
    }
    void adapter(){
        int i = 0;//, count = 0;
        char c = ' ';
        String c1 = "", s = "";
        boolean used = true, pushed = false;
        while( i<str.length() ){
            c = str.charAt(i);//display();System.out.println();bt.display();bthauto.display();
           // System.out.println("c = "+c);
            if( c>='0' && c<='9' ){
               // bthauto[count] = c;
                //count++;
               // bthauto.push( c );
                pushed = false;
                s += c;
             //   System.out.println("s = :"+s);
            }
            else {//System.out.println("s = "+s);
                if( !pushed ) {
                    bthauto.push(s);
                    pushed = true;
                    s = "";
                }
                if ( c != ')' ) {
                    if( !bt.isEmpty() && c != '(' ){
                       // s = "";
                        s += (char)bt.pop();
                       // System.out.println( "c1 = "+c1);
                        used = false;
                      //  System.out.println(" s =/"+s+'/'+"c = /"+c+'/'+priorityOperator( s.charAt(0) )+'/'+priorityOperator( c ));
                        while( s.charAt(0) != '(' && priorityOperator( s.charAt(0) ) >= priorityOperator( c ) ){
                          //  bthauto[count] = c1;
                            bthauto.push( s );
                            System.out.println("s = //"+s+'/');
                            s="";
                            used = true;
                           // count++;
                            if( !bt.isEmpty() ){
                                s += (char)bt.pop();
                                used = false;
                            }
                            else
                                break;
                        }
                        if( !used ){
                            bt.push( s.charAt(0) );
                            s = "";
                            used = true;
                        }
                    }
                    bt.push(c);
                } else {
                    while ( !bt.isEmpty() ) {
                        c = (char)bt.pop();
                        if( c != '(' ){
                          //  bthauto[count] = c;
                           // count++;
                            s = "";
                            s += c;
                            bthauto.push(s);
                        }
                        else
                            break;
                    }
                }
            }
            ++i;
        }
        if(!pushed)
            bthauto.push(s);
        while ( !bt.isEmpty() ) {
            c = (char)bt.pop();
            s = ""+c;
            bthauto.push(s);
           // bthauto[count] = c;
          //  count++;
        }
        return;
    }
    void display(){
        bthauto.display();
        /*int i = 0;
        while( i<bthauto.length ){
            System.out.print( bthauto[i] );
            ++i;
        }*/
    }
    long calc(){
        stack<Long> calculation = new stack<Long>();
        long num1, num2;
        String s;
        long temp;
        int i;
        while( !bthauto.isEmpty() ){
            s = bthauto.pop();
          //  System.out.println("s = "+s);
            if( s.charAt(0)!='+' && s.charAt(0)!='-' && s.charAt(0)!='*' && s.charAt(0)!='/' ){
                i = 0;
                temp = 0;
                while( i<s.length() ) {
                    temp = temp * 10 + s.charAt(i) - '0';
                    ++i;
                }
             //   System.out.println("temp = "+temp);
                calculation.push( temp );
             //  System.out.println( "s =/"+s+'/');
              //  if( s.charAt(0)=='+')
                 //   System.out.println("dude!");
            }
            else{
                num1 = (long)calculation.pop();
                num2 = (long)calculation.pop();
                if( s.charAt(0)=='+' ){
                    num1 += num2;
                    //System.out.println("dude!");
                    calculation.push(num1);
                }
                else{
                   // System.out.println("s = /"+s+'/');
                    if( s.charAt(0)=='-' ){
                        num2 -= num1;
                       // System.out.println("-? dude!");
                        calculation.push(num2);
                    }
                    else{
                        if( s.charAt(0)=='*' ){
                            num1 *= num2;
                            calculation.push(num1);
                        }
                        else{
                            num2/=num1;
                            calculation.push(num2);
                        }
                    }
                }
            }
        }
       // num1 = calculation.pop();
        return calculation.pop();
    }
    public static void main( String[] args ){
        Scanner inp = new Scanner( System.in );
        int n;//Integer b = new Integer(1);
        n = inp.nextInt();//Char c = new Char('c');
        inp.nextLine();//String s = "";s =s+'h'+'i'+'e'+'u';System.out.println( s );
       /* queue temp = new queue();
        temp.push( 'h' ); temp.push( 'i' ); temp.push( 'e' ); temp.push( 'u' );
        temp.display();*/
        int i = 0;
        bieuthuchauto temp = new bieuthuchauto();
        while( i<n ){
            temp.init( inp );
            temp.adapter();
            temp.display();
            System.out.println(temp.calc());
            ++i;
        }
        return;
    }
}