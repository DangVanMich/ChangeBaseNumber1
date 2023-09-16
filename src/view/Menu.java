package view;

import java.util.ArrayList;
import java.util.Scanner;


public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> list;
//----------------------------------------------
    public Menu() {
        list = new ArrayList<>();
    }
    
    public Menu(String td, String[] mc){
        this.title = td;
        list = new ArrayList<>();
        for(String s : mc){
            list.add((T) s);
        }
    }
//-----------------------------------------------    
    public void display(){
        System.out.println(title);
        for(int i = 0; i < list.size(); i++){
            System.out.println((i+1)+". "+ list.get(i));
        }
        System.out.println("--------------------------------");
    }
//-----------------------------------------------
     public int getChoice(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter your choice: ");
         int choice = sc.nextInt();
         return choice;
     }
//------------------------------------------------
     public abstract void execute(int choice);
     
     public void run(){
        int choice;
        do{
            display();//hien menu
            choice = getChoice();
            execute(choice);//xu ly
        }while(choice > 0 && choice <= list.size());
     }
    
}
