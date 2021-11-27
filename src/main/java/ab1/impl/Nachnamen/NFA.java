package ab1.impl.Nachnamen;

import ab1.DFA;
import ab1.exceptions.IllegalCharacterException;

import java.util.HashSet;
import java.util.Set;

public class NFA implements ab1.NFA {

    private Set<Character> alphabet ;
    private Set<Integer> acceptingStates; // endzustände
    private int initialState ; // startzustand
    private int numStates ; // anzahl von Zustände
    private final Character epsilon = null ; // leeres wort

    private Set<Character>[][] transitions ;



    public NFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {

        this.numStates = numStates;
        this.alphabet = characters;
        this.acceptingStates = acceptingStates;
        this.initialState = initialState;

        this.transitions = new Set[numStates][numStates];

        for (int i = 0 ; i < numStates; i++){
            for (int j = 0; j < numStates; j++){
                this.transitions[i][j] = new HashSet<>();
            }
        }

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

    @Override // DONE
    public boolean isAcceptingState(int s) throws IllegalStateException {

       if ( !(getInitialState() <= s) && !(s <= getNumStates())){
            throw new IllegalStateException();
       }

       if (getAcceptingStates().contains(s)){
           return true;
       }

       return false;
    }

    @Override // DONE
    public Set<Character>[][] getTransitions() {
        return this.transitions;
    }

    @Override // DONE
    public void setTransition(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException {

        if ( !(getInitialState() <= fromState) && !(fromState <= getNumStates()) || !(getInitialState() <= toState) && !(toState <= getNumStates())){
            throw new IllegalStateException();
        }
        if (!getAlphabet().contains(c)){
            throw new IllegalCharacterException();
        }

        this.transitions[fromState][toState].add(c);

    }


    @Override // DONE
    public void clearTransitions(int fromState, Character c) throws IllegalStateException {

        if ( !(getInitialState() <= fromState) && !(fromState <= getNumStates()) ){
            throw new IllegalStateException();
        }

        for (int j = 0 ; j <= getTransitions()[fromState].length; j++){

            if (getTransitions()[fromState][j].contains(c)){
                getTransitions()[fromState][j].remove(c);
            }

            getTransitions()[fromState][j].clear();
        }
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
    public int getNumStates() {
        return this.numStates;
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

    @Override // just the error
    public Boolean accepts(String w) throws IllegalCharacterException {

        for (int i = 0 ; i < w.length(); i++) {
            if (this.getAlphabet().contains(w.charAt(i))){
                throw new IllegalCharacterException();
            }
        }



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
