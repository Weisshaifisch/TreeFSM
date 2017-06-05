package treefsm.states;

import static treefsm.states.FSMStates.*;
import static treefsm.tree.TreeStates.*;

public class SunnyGrowState extends FSMState {

    public SunnyGrowState(final FSMStates stateId) {
        super(stateId);
    }

    @Override
    public void processSunnyDay() {
        getTree().setState(STASIS);
        getFsm().setState(SUNNY_STASIS);
        getFsm().getCurrentState().entry();
    }

    @Override
    public void processRainyDay() {
        getTree().setState(GROW);
        getFsm().setState(RAINY_GROW);
        getFsm().getCurrentState().entry();
    }
}
