package four6Weeks;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author Abhik Kumar
 * @version 1/14/19
 */

public class towersOfHanoi {
    //counter variable of the moves, making it so that each individual move is counted and stores
    static int count = 1;

    public static void main(String args[]){
        //each position in the array is a stack, which represents a tower
        Stack<Integer>[] towers = new Stack[3];
        towers[0] = new Stack<Integer>();
        towers[1] = new Stack<Integer>();
        towers[2] = new Stack<Integer>();

        //Takes in the number of disks to use
        Scanner scan = new Scanner(System.in);
        System.out.println("How many disks?");
        int askedDiskSize = scan.nextInt();
        System.out.println("Minimum number of moves: " + ((int)(Math.pow(2,askedDiskSize))-1));
        for(int i = askedDiskSize; i > 0; i--){
            towers[0].add(i);
            //towers[1].add(0);
            //towers[2].add(0);
        }
        //System.out.println(towers[0].toString());
        count = count -1;

        //Wins Tower Of Hanoi
        winGame(askedDiskSize, 0,1,2,towers);
        //System.out.println("number of moves: " + count);
    }
    /*// FAKE winGame() before I realised that numbers to their position in an array would work instead of each of their references
    public static void winGame(int diskSize, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c){
        if(diskSize == 1){
                printBoard(a,b,c);
                //System.out.println(a.toString());

            int num = 0;
            if(!a.empty()) {
                 num = a.pop();
                 if(c.empty()) {
                     c.push(num);
                 }
                 else{
                     b.push(num);
                 }
            }
            else if(!b.empty()){
                num = b.pop();
                if(c.empty()){
                    c.push(num);
                }
                else{
                    a.push(num);
                }
            }else if(!c.empty()) {
                num = c.pop();
                if (a.empty()) {
                    a.push(num);
                } else if (b.empty()){
                    b.push(num);
                }
            }
                //c.push(num);
                //a.push(0);
                printBoard(a, b, c);
                //System.out.println(a.toString());
                //System.out.println(c.toString());
        }
        else{
            winGame(diskSize-1, a,c,b);
            printBoard(a,b,c);
            winGame(diskSize-1, b,a,c);
        }
    }
    */

    /**
     *
     * @param diskSize the maximum disk size, given by the user when
     * @param a, the integer that controls tower[0],0
     * @param b, the integer that controls tower[1],1
     * @param c the integer that controls tower[2],2
     * @param towers the array of towers
     */
    public static void winGame(int diskSize, int a, int b, int c, Stack<Integer>[] towers){
        if(diskSize > 0){
            //printBoard(towers[0], towers[1], towers[2]);
            winGame(diskSize - 1, a,c,b, towers); //In each case, the second value is the intermediate, and you're trying to go from a to c
            int dest = towers[a].pop();
            towers[c].push(dest);
            printBoard(towers[0], towers[1], towers[2]);
            winGame(diskSize-1, b,a,c, towers);
        }
    }

    /**
     *
     * @param a the left most tower
     * @param b the middle tower
     * @param c the right most tower
     */
    public static void printBoard(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c){
        //for(int i = 2; i >  -1; i--){
            //System.out.println(a.get(i) + " " + b.get(i) + " " + c.get(i));
        //}
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());

        count++;
        System.out.println("Moves: " + count);
    }




}
