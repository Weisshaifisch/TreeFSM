package treefsm.states;

public enum FSMStates {
    INIT,                   // initial state
    FIRST_RAINY,            // the very first rainy day
    FIRST_SUNNY,            // the very first sunny day
    RAINY_GROW,             // the rainy day after the sunny day, tree grows
    SUNNY_GROW,             // the sunny day after the rainy day, tree grows
    RAINY_STASIS,           // the rainy day after the rainy day, the tree is in stasis
    SUNNY_STASIS,           // the sunny day after the sunny day, the tree is in stasis
    RAINY_WITHER,           // the rainy day after two or more consecutive rainy days, the tree withers
    SUNNY_WITHER,           // the sunny day after two or more consecutive sunny days, the tree withers
}
