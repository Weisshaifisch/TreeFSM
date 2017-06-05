package treefsm.states;

import static treefsm.states.FSMStates.*;


public class InitState extends FSMState {

    public InitState(final FSMStates stateId) {
        super(stateId);
    }

    @Override
    public void processSunnyDay() {
        getFsm().setState(FIRST_SUNNY);
    }

    @Override
    public void processRainyDay() {
        getFsm().setState(FIRST_RAINY);
    }
}
