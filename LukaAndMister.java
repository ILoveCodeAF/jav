import java.util.Scanner;
import mypack.PriorityQueue;
import mypack.parent;
import mypack.Val;
//import mypack.arrlist;

class T{
    public int src,des;
}
class ancientList{
    int des;
    int periodoftime;
    ancientList next;
}
class currentPosition{
    int src, des, time;
}
class LukaAndMister{
    int begL, endL, nNodes, nRoads;
    int tL, tM;
    int nNodesofMister;
    ancientList[] roadsofMister;
    ancientList[] roads;
    int[] matrix;
    LukaAndMister(){}
    void init(Scanner inp){
        nNodes = inp.nextInt();
        nRoads = inp.nextInt();
        begL = inp.nextInt();
        endL = inp.nextInt();
        tL = inp.nextInt();
        tM = 0;
        nNodesofMister = inp.nextInt();
        roadsofMister = new ancientList[nNodesofMister];
        while( tM<nNodesofMister ){
            roadsofMister[tM] = new ancientList();
            roadsofMister[tM].des = inp.nextInt()-1;
            //System.out.println("tm:"+tM +" "+roadsofMister[tM].des);
            ++tM;
        }
        tM = tL;
        tL = 0;
        int src, des, periodoftime;
        matrix = new int[nNodes*nNodes];
        while( tL<nRoads ){
            src = inp.nextInt()-1;
            des = inp.nextInt()-1;
            periodoftime = inp.nextInt();
            matrix[ src*nNodes+des ] = matrix[ des*nNodes+src ] = periodoftime;
            tL++;
        }
        tL = 0;
        roads = new ancientList[nNodes];
        ancientList t, t1;
        t = new ancientList();
        int i = 0, j = 0;
        while( i<nNodes ){
            j = 0;
            //roads[i] = new ancientList();
            while( j<nNodes ){
                if( matrix[i*nNodes+j]!=0) {
                    if (roads[i]==null ) {
                        roads[i] = new ancientList();
                        roads[i].periodoftime = matrix[i * nNodes + j];
                        roads[i].des = j;
                        t = roads[i];
                    } else {
                        t1 = new ancientList();
                        t1.des = j;
                        t1.periodoftime = matrix[i * nNodes + j];
                        t.next = t1;
                        t = t.next;
                    }
                }
                ++j;
            }
            ++i;
        }
        i = 1;
        while( i<nNodesofMister ){
            roadsofMister[i].periodoftime = roadsofMister[i-1].periodoftime +
                    matrix[roadsofMister[i].des*nNodes+roadsofMister[i-1].des];
            //System.out.println(i +": "+roadsofMister[i].periodoftime);
            ++i;
        }
    }
    currentPosition search( int time, int l, int r ){
        if( time>roadsofMister[nNodesofMister-1].periodoftime ) {
            currentPosition temp = new currentPosition();
            temp.src = -1;
            temp.des = -1;
            temp.time = 0;
            return temp;
        }
        int m = (l+r)/2;
        while( l<r ){
            m = (l+r)/2;
            if( roadsofMister[m].periodoftime>time ){
                r = m;
            }
            else {
                l = m;
            }
            if( l+1==r)
                break;
        }
        currentPosition temp = new currentPosition();
        temp.src = roadsofMister[l].des;
        temp.des = roadsofMister[r].des;
        temp.time = roadsofMister[r].periodoftime - time;
        return temp;
    }
    int solve(){
        int min = Integer.MIN_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        parent<Val<Integer>> anotherTemp,temp = new parent<Val<Integer>>();
        temp.value = new Val<Integer>();
        temp.value.value = begL-1;
        temp.value.priorityVal = 0;
        queue.push( temp );
        ancientList t = new ancientList();
        currentPosition positionTemp = new currentPosition();
        while( !queue.isEmpty() ){
            temp = queue.pop();
            if( temp.value.value == endL-1 ) {
                if (temp.value.priorityVal > min)
                    min = temp.value.priorityVal;
                else
                    break;
            }
            else{
                t = roads[temp.value.value];
                positionTemp = search( -temp.value.priorityVal+tM, 0, nNodesofMister-1 );
               // System.out.println("position of mister="+ positionTemp.src+ " "+ positionTemp.des+
                //" "+ positionTemp.time);
                while( t!=null ){
                    anotherTemp = new parent<Val<Integer>>();
                    anotherTemp.value = new Val<Integer>();
                    anotherTemp.value.value = t.des;
                    anotherTemp.value.priorityVal = temp.value.priorityVal-t.periodoftime;
                    if( t.des == positionTemp.src )
                        anotherTemp.value.priorityVal -= positionTemp.time;
                    queue.push( anotherTemp );
                    t = t.next;
                }
            }

        }
        return -min;
    }
    public static void main(String[] args){
        System.out.println("hello");
        Scanner inp = new Scanner( System.in );
        LukaAndMister temp = new LukaAndMister();
        temp.init(inp);
        System.out.println(temp.solve());
        return;
    }
}