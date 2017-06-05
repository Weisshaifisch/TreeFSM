package treefsm.tree;

import static treefsm.tree.TreeStates.*;
public class Tree {

    private TreeStates state;
    private static Tree tree;

    private Tree() {
        this.state = STASIS;
    }

    public TreeStates getState() {
        return state;
    }

    public void setState(final TreeStates state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Today... your tree " + state;
    }

    public static Tree getInstance() {
        return SingletonHelper._tree;
    }

    private static class SingletonHelper {
        private static final Tree _tree = new Tree();
    }
}
