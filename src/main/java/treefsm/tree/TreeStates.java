package treefsm.tree;

/**
 * Created by Алексей on 22.05.2017.
 */
public enum TreeStates {
    STASIS("is in stasis"),
    GROW("grows"),
    WITHER("withers");

    private final String state;

    private TreeStates(String aState) {
        this.state = aState;
    }

    @Override
    public String toString() {
        return this.state;
    }
}
