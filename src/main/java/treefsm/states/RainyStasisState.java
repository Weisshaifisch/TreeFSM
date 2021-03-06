package treefsm.states;

import static treefsm.states.FSMStates.*;
import static treefsm.tree.TreeStates.*;

public class RainyStasisState extends FSMState {

    public RainyStasisState(final FSMStates stateId) {
        super(stateId);
    }

    @Override
    public void processSunnyDay() {
        getTree().setState(GROW);
        getFsm().setState(SUNNY_GROW);
        getFsm().getCurrentState().entry();
    }

    @Override
    public void processRainyDay() {
        getTree().setState(WITHER);
        getFsm().setState(RAINY_WITHER);
        getFsm().getCurrentState().entry();
    }
}
