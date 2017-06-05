package treefsm.fsm;

import treefsm.states.FSMState;
import treefsm.states.FSMStates;

import java.util.EnumMap;
import java.util.Map;

public class FSM {

    private FSMState state;
    private final Map<FSMStates, FSMState> states;

    public FSM() {
        states = new EnumMap<>(FSMStates.class);
    }

    public void addStates(final FSMState ... aStates) {
        for (FSMState state : aStates) {
            state.setFsm(this);
            states.put(state.getStateId(), state);
        }
    }

    public void setState(FSMStates key) {
        this.state = states.get(key);
    }

    public void processSunnyDay() {
        this.state.processSunnyDay();
    }

    public void processRainyDay() {
        this.state.processRainyDay();
    }

    public FSMState getState(FSMStates key) {
        FSMState state = null;
        if (states.containsKey(key)) {
            state = states.get(key);
        }

        return state;
    }

    public FSMState getCurrentState() {
        return this.state;
    }

}