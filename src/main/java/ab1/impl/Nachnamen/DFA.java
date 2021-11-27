package ab1.impl.Nachnamen;

import ab1.exceptions.IllegalCharacterException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DFA extends NFA implements ab1.DFA {


    private Set<Character> alphabet ;
    private Set<Integer> acceptingStates; // endzustände
    private int initialState ; // startzustand
    private int numStates ; // anzahl von Zustände
    private final Character epsilon = null ; // leeres wort

    private Set<Character>[][] transitions ;
    private int currentState = 0 ;


    public DFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {
        super(numStates, characters, acceptingStates, initialState);

        this.alphabet = new HashSet<>(characters);
        this.acceptingStates = new HashSet<>(acceptingStates);

        this.transitions = new Set[numStates][numStates];

        for (int i = 0 ; i < numStates; i++){
            for (int j = 0; j < numStates; j++){
                this.transitions[i][j] = new HashSet<>();
            }
        }

    }

    @Override
    public void reset() {

        setInitialState(0);
        setCurrentState(0);
        setAlphabet(new HashSet<>());
        setAcceptingStates(new HashSet<>());
        setTransitions(new Set[0][0]);
        setNumStates(0);

    }

    @Override
    public int getCurrentState() {
        return this.currentState ;
    }

    @Override
    public int doStep(char c) throws IllegalCharacterException, IllegalStateException {

        if (!getAlphabet().contains(c)){
            throw new IllegalCharacterException();
        }

        if ( getNextState(getCurrentState(),c) == null ){
            throw new IllegalStateException();
        }

        setTransition(getCurrentState(),c,getNextState(getCurrentState(),c));

        setCurrentState(getNextState(getCurrentState(),c));


        return getCurrentState();
    }

    @Override
    public Integer getNextState(int s, char c) throws IllegalCharacterException, IllegalStateException {

        if ( !(getInitialState() <= s) && !(s <= getNumStates()) ){
            throw new IllegalStateException();
        }

        if (!getAlphabet().contains(c)){
            throw new IllegalCharacterException();
        }

        for (int j = 0 ; j < getTransitions()[s].length; j++) {

            if (getTransitions()[s][j].contains(c)) {
                return j;
            }
        }

        return null;
    }

    @Override
    public boolean isInAcceptingState() {

        if (getAcceptingStates().contains(getCurrentState())){
            return true;
        }

        return false;
    }

    @Override
    public void setTransition(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException {

    }

    @Override
    public boolean equals(Object b){

        // self check
        if (this == b)
            return true;
        // null check
        if (b == null)
            return false;
        // type check and cast
        if (getClass() != b.getClass()){
            return false;
        }

        DFA dfa = (DFA) b;


        boolean isDFA = Objects.equals(this.acceptingStates, dfa.acceptingStates)
                && Objects.equals(this.alphabet, dfa.alphabet)
                && Objects.equals(this.numStates, dfa.numStates)
                && Objects.equals(this.initialState, dfa.initialState)
                && Objects.equals(this.transitions, dfa.transitions);


        return isDFA;


    }

    @Override
    public Set<Character> getAlphabet() {
        return this.alphabet;
    }


    @Override
    public Set<Integer> getAcceptingStates() {
        return this.acceptingStates;
    }

    @Override
    public int getInitialState() {
        return this.initialState;
    }

    public void setAlphabet(Set<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public void setAcceptingStates(Set<Integer> acceptingStates) {
        this.acceptingStates = acceptingStates;
    }

    public void setInitialState(int initialState) {
        this.initialState = initialState;
    }

    public void setNumStates(int numStates) {
        this.numStates = numStates;
    }

    public void setTransitions(Set<Character>[][] transitions) {
        this.transitions = transitions;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }
}
