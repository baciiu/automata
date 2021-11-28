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

        if ( getNextState(getCurrentState(),c) == null  || getNextStates(getCurrentState(),c).size() > 1){
            throw new IllegalStateException();
        }

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

    @Override // DONE
    public Set<Integer> getNextStates(int state, Character c) throws IllegalCharacterException, IllegalStateException {

        if ( !(getInitialState() <= state) && !(state <= getNumStates()) ){
            throw new IllegalStateException();
        }

        if (!getAlphabet().contains(c)){
            throw new IllegalCharacterException();
        }
        Set<Integer> nextstates = new HashSet<>();

        for (int j = 0 ; j <= getTransitions()[state].length; j++) {

            if (getTransitions()[state][j].contains(c)) {
                nextstates.add(j);
            }
        }

        return nextstates;
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

        if ( !(getInitialState() <= fromState) && !(fromState <= getNumStates()) || !(getInitialState() <= toState) && !(toState <= getNumStates())){
            throw new IllegalStateException();
        }
        if (!getAlphabet().contains(c) || c == epsilon ){
            throw new IllegalCharacterException();
        }

        this.transitions[fromState][toState].add(c);
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

       if (b instanceof NFA){
           ((NFA) b).toDFA();
       }

       if (this.acceptingStates != ((DFA) b).getAcceptingStates() || this.alphabet != ((DFA) b).getAlphabet() ||
                   this.numStates != ((DFA) b).getNumStates()|| this.initialState != ((DFA) b).getInitialState() ||
                   this.transitions != ((DFA) b).getTransitions()){

               return false;
           }
        return true;
    }
    @Override
    public Boolean accepts(String w) throws IllegalCharacterException {

        int currentState = this.initialState;

        for (int i = 0 ; i < w.length(); i++) {

            if (!this.getAlphabet().contains(w.charAt(i))){
                throw new IllegalCharacterException();
            }

            if (getNextState(currentState,w.charAt(i)) == null && getAcceptingStates().contains(currentState)){
                return true;
            }

            if (getTransitions()[currentState][getNextState(currentState,w.charAt(i))].contains(w.charAt(i))){
                currentState = getNextState(currentState,w.charAt(i)) ;
            }
        }

        return false;
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
