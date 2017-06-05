package treefsm.states;

import static treefsm.states.FSMStates.*;
import static treefsm.tree.TreeStates.*;

public class SunnyWitherState extends FSMState {

    public SunnyWitherState(final FSMStates stateId) {
        super(stateId);
    }

    @Override
    public void processSunnyDay() {
        getTree().setState(WITHER);
        getFsm().setState(SUNNY_WITHER);
        getFsm().getCurrentState().entry();
    }

    @Override
    public void processRainyDay() {
        getTree().setState(GROW);
        getFsm().setState(RAINY_GROW);
        getFsm().getCurrentState().entry();
    }
}
