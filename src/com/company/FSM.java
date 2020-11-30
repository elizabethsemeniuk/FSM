package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FSM {
    public int statesCount;

    public int curState;
    public int start;
    public List<Transition> transitions;
    public List<Integer> fins;

    FSM( int SCount, int S0, List<Transition> transactionList, List<Integer> finList) {
        statesCount = SCount;
        start = S0;
        curState = S0;
        transitions = transactionList;
        fins = finList;
    }

    public boolean check(String word){
        for (int i = 0; i < word.length(); i++){
            if(!move(word.charAt(i)))
                return false;
        }
        return fins.contains(curState);
    }

    public void reset_FSM(){
        curState = start;
    }

    private boolean move(char symbol){ // виконати 1 тр
        for (var i : transitions){
            if (i.from == curState && i.symbol == symbol){
                curState = i.to;
                return  true;
            }
        }
        return false;
    }

    public List<Integer> getReachableStates(int startingPoint) { //всі стани, в які можна потрапити з поточного
        List<Integer> result = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<Boolean>();
        for(int i = 0; i <= statesCount; i++)
            visited.add(false);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(startingPoint);

        while(!queue.isEmpty()){
            int current = queue.pop();
            result.add(current);
            visited.set(current, true);
            for (var t : transitions) {
                if(t.from == current && !visited.get(t.to)){
                    queue.add(t.to);
                }
            }
        }
        return result;
    }
}
