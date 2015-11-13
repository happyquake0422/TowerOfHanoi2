package towerofhanoi2;
import java.util.ArrayList;
import java.util.Scanner;
public class TowerOfHanoi2 {
    public static ArrayList TowerA = new ArrayList();
    public static ArrayList TowerB = new ArrayList();
    public static ArrayList TowerC = new ArrayList();
    
    public static void main(String[] args) {
        TowerOfHanoi2 towersOfHanoi = new TowerOfHanoi2();
        System.out.print("This is the game know as the Tower of Hanoi.\n" 
                + "You are given 3 poles, and a certain amount of rings\n" 
                + "(stacked in a cone of decreasing size)\n" 
                + "to move from one pole to another.\n\n" 
                + "The catch is this: You can only move one ring at a time,\n" 
                + "and you cannot put a ring onto another ring\n" 
                + "smaller than the one being placed.\n" 
                + "This program will spit out what moves you should make\n" 
                + "in order to beat the game with a given amount of rings.\n\n" 
                + "So, how many rings do you want to start with?\n"
                + "Enter a number: ");
        Scanner In = new Scanner(System.in);
        int discs = In.nextInt();
        TowerA.add("Tower1");
        TowerB.add("Tower2");
        TowerC.add("Tower3");
        for(int i = discs; i >0; i--)
        {
            TowerA.add(i);
        }
        System.out.println(TowerA);
        towersOfHanoi.solve(discs,TowerA,TowerB,TowerC);
    }
    public void solve(int n, ArrayList start, ArrayList extra, ArrayList end)
    {
        
        if (n==1){ System.out.println("Move the ring of size " + start.get(start.size()-1) + " on " + start.get(0) + " to " + end.get(0));
        end.add(start.get(start.size()-1));
        start.remove(start.size()-1);
            System.out.println("_________________________________\n"
            + start + "\n \n"
            + extra + "\n \n"
            + end + "\n \n"
            + "_________________________________\n");
        } else {
            solve(n-1, start, end, extra);
            System.out.println("Move the ring of size " + start.get(start.size()-1) + " on " + start.get(0) + " to " + end.get(0));
            end.add(start.get(start.size()-1));
            start.remove(start.size()-1);
            System.out.println("_________________________________\n"
            + start + "\n \n"
            + extra + "\n \n"
            + end + "\n \n"
            + "_________________________________\n");
            solve(n-1, extra, start, end);
        }
    }
}
