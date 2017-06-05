package treefsm.states;

import static treefsm.tree.TreeStates.*;
import static treefsm.states.FSMStates.*;

public class FirstRainyState extends FSMState {

    public FirstRainyState(final FSMStates stateId) {
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
        getTree().setState(STASIS);
        getFsm().setState(RAINY_STASIS);
        getFsm().getCurrentState().entry();
    }
}
