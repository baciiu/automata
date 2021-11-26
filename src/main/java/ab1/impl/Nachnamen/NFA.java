package ab1.impl.Nachnamen;

import ab1.DFA;
import ab1.exceptions.IllegalCharacterException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NFA implements ab1.NFA {

    private Set<Character> alphabet = new HashSet<>();
    private Set<Integer> acceptingStates = new HashSet<>(); // endzustände
    private int initialState = 0; // startzustand
    private Set<Character[][]> transitions = new HashSet<>();
    private int currentState = 0;
    private int numStates = 0; // anzahl von Zustände
    private final Character epsilon = null ; // leeres wort


    public NFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {

        this.numStates = numStates;
        this.alphabet = characters;
        this.acceptingStates = acceptingStates;
        this.initialState = initialState;
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

    @Override
    public boolean isAcceptingState(int s) throws IllegalStateException {

       if ( !(getInitialState() <= s) && !(s <= getNumStates())){
            throw new IllegalStateException();
       }


       if (getAcceptingStates().contains(s)){
           return true;
       }

       return false;
    }

    @Override
    public Set<Character[][]> getTransitions() {
        return this.transitions;
    }

    @Override
    public void setTransition(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException {

        if ( !(getInitialState() <= fromState) && !(fromState <= getNumStates()) || !(getInitialState() <= toState) && !(toState <= getNumStates())){
            throw new IllegalStateException();
        }
        if (!getAlphabet().contains(c)){
            throw new IllegalCharacterException();
        }

        /**    NOT SURE */
         Character[][] transition = new Character[numStates][numStates];
        transition[fromState][toState] = c ;

        getTransitions().add(transition);

    }

    @Override
    public void clearTransitions(int fromState, Character c) throws IllegalStateException {

    }

    @Override
    public Set<Integer> getNextStates(int state, Character c) throws IllegalCharacterException, IllegalStateException {
        return null;
    }

    @Override
    public int getNumStates() {
        return 0;
    }

    @Override
    public ab1.NFA union(ab1.NFA a) {
        return null;
    }

    @Override
    public ab1.NFA intersection(ab1.NFA a) {
        return null;
    }

    @Override
    public ab1.NFA minus(ab1.NFA a) {
        return null;
    }

    @Override
    public ab1.NFA concat(ab1.NFA a) {
        return null;
    }

    @Override
    public ab1.NFA complement() {
        return null;
    }

    @Override
    public ab1.NFA kleeneStar() {
        return null;
    }

    @Override
    public ab1.NFA plus() {
        return null;
    }

    @Override
    public DFA toDFA() {
        return null;
    }

    @Override
    public Boolean accepts(String w) throws IllegalCharacterException {
        return null;
    }

    @Override
    public Boolean acceptsNothing() {
        return null;
    }

    @Override
    public Boolean acceptsEpsilonOnly() {
        return null;
    }

    @Override
    public Boolean acceptsEpsilon() {
        return null;
    }

    @Override
    public boolean subSetOf(ab1.NFA b) {
        return false;
    }
}
