package treefsm.states;

import treefsm.fsm.FSM;
import treefsm.tree.Tree;

/**
 * A base class for all FSM states.
 */
public abstract class FSMState implements State {

    private FSMStates stateId;
    private Tree tree;
    private FSM fsm;

    public FSMStates getStateId() {
        return stateId;
    }

    public void setStateId(final FSMStates stateId) {
        this.stateId = stateId;
    }

    public FSM getFsm() {
        return fsm;
    }

    public void setFsm(final FSM fsm) {
        this.fsm = fsm;
    }

    public FSMState(final FSMStates stateId) {
        this.tree = Tree.getInstance();
        this.stateId = stateId;
    }

    public Tree getTree() {
        return tree;
    }

    public void entry() { tree.toString(); }
    private void exit() {}
}