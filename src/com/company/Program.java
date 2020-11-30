package com.company;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Program {

    public static FSM demo() {
        String fileName = "data.txt";
        Path path = Paths.get(fileName);
        Scanner input;
        try{
            input = new Scanner(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        int SCount = input.nextInt();
        int S0 = input.nextInt();
        int transactions_quantity = input.nextInt();
        List<Transition> transactionList = new ArrayList<>();
        for (int i = 1; i <= transactions_quantity; i++){
            int from = input.nextInt();
            char symbol = input.next().charAt(0);
            int to = input.nextInt();
            transactionList.add(new Transition(from, symbol, to));
        }
        int fin_quantity = input.nextInt();
        List<Integer> finList = new ArrayList<>();
        for (int i = 1; i <= fin_quantity; i++){
            int fin_state = input.nextInt();
            finList.add(fin_state);
        }
        FSM fsm = new FSM(SCount, S0, transactionList, finList);
        return fsm;
    }

    public static FSM interactive(){
        Scanner input = new Scanner(System.in);
        System.out.println("States quantity:");
        int SCount = input.nextInt();
        System.out.println("Enter start state:");
        int S0 = input.nextInt();
        System.out.println("How many transactions do you need?");
        int transactions_quantity = input.nextInt();
        List<Transition> transactionList = new ArrayList<>();
        for (int i = 1; i <= transactions_quantity; i++){
            System.out.println("Enter transaction");
            int from = input.nextInt();
            char symbol = input.next().charAt(0);
            int to = input.nextInt();
            transactionList.add(new Transition(from, symbol, to));
        }
        System.out.println("Enter quantity of final states");
        int fin_quantity = input.nextInt();
        System.out.println("Enter all final states");
        List<Integer> finList = new ArrayList<>();
        for (int i = 1; i <= fin_quantity; i++){
            int fin_state = input.nextInt();
            finList.add(fin_state);
        }
        return new FSM(SCount, S0, transactionList, finList);
    }

    public static boolean check_W(FSM fsm, String w0){
        List<Integer> reachable_states= fsm.getReachableStates(fsm.start);
        for(int st : reachable_states){
            fsm.curState = st;
            if(fsm.check(w0))
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println("Hello! Choose demo (1) or interaction (2) mode.");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        FSM fsm;
        if(choice == 1){
            fsm = demo();
        } else if (choice == 2){
            fsm = interactive();
        } else {
            return;
        }
        if(fsm == null)
            return;


        System.out.print("cacacacadd ");
        if(fsm.check("cacacacadd")){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        fsm.reset_FSM();


        System.out.print("ababacac ");
        if(fsm.check("ababacac")){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        fsm.reset_FSM();


        System.out.print("aba ");
        if(fsm.check("aba")){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        fsm.reset_FSM();


        System.out.print("abac ");
        if(fsm.check("abac")){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        fsm.reset_FSM();


        System.out.print("acab ");
        if(fsm.check("acab")){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        fsm.reset_FSM();

        System.out.println("Enter string of alphabet {a,b,c} to check (enter q to quit)");
        String check = input.nextLine();
        while(!check.equals("q")){
            check = input.nextLine();
            if(check_W(fsm, check)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            fsm.reset_FSM();
        }

    }
}
