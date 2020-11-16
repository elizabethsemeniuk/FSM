package com.company;

import java.util.List;
import java.util.Optional;

public class FSM {
        public int statesCount;

        public String curState;
        public String start;
        public List<Transition> transitions;
        public List<String> fins;

        FSM( int SCount, String S0, List<Transition> transactionList, List<String> finList) {
            statesCount = SCount;
            curState = S0;
            start = S0;
            transitions = transactionList;
            fins = finList;
        }
}
