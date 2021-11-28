package ab1.impl.Nachnamen;

import ab1.DFA;
import ab1.exceptions.IllegalCharacterException;

import java.util.*;

public class NFA implements ab1.NFA {

    private Set<Character> alphabet ;
    private Set<Integer> acceptingStates; // endzustände
    private int initialState ; // startzustand
    private int numStates ; // anzahl von Zustände
    private final Character epsilon = null ; // leeres wort

    private Set<Character>[][] transitions ;



    public NFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {

        this.numStates = numStates;
        this.alphabet = new HashSet<>(characters);
        this.acceptingStates = new HashSet<>(acceptingStates);
        this.initialState = initialState;

        this.transitions = new Set[numStates][numStates];

        for (int i = 0 ; i < numStates; i++){
            for (int j = 0; j < numStates; j++){
                this.transitions[i][j] = new HashSet<>();
            }
        }

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
    public void setTransition(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException {

        if ( !(getInitialState() <= fromState) && !(fromState <= getNumStates()) || !(getInitialState() <= toState) && !(toState <= getNumStates())){
            throw new IllegalStateException();
        }
        if (!getAlphabet().contains(c) && c != epsilon ){
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

    public ab1.NFA union(ab1.NFA a) {

        Set<Character> newAlphabet = new TreeSet<>(this.getAlphabet());
        newAlphabet.addAll(a.getAlphabet());

        int newNumStates = this.getNumStates() + a.getNumStates() + 1 ;
        int newInitialState = newNumStates - 1 ;

        int shift = this.getNumStates();

        Set<Integer> newAcceptingStates = this.getAcceptingStates();
        for (Integer s: a.getAcceptingStates()) {
            newAcceptingStates.add(s + shift);
        }

        NFA newNFA = new NFA(newNumStates,newAlphabet,newAcceptingStates,newInitialState);

        newNFA.setTransition(newInitialState,null, this.initialState);
        newNFA.setTransition(newInitialState,null, a.getInitialState() + shift);

        for (int i = this.getInitialState(); i < this.getNumStates() ; i++){
            for (int j = this.getInitialState(); j < this.getNumStates() ; j++){

                Set<Character> chars = this.getTransitions()[i][j];

                for (Character c : chars){
                    newNFA.setTransition(i,c,j);
                }
            }
        }
        for (int i = a.getInitialState(); i < a.getNumStates() ; i++){
            for (int j = a.getInitialState(); j < a.getNumStates() ; j++){

                Set<Character> chars = a.getTransitions()[i][j];

                for (Character c : chars){
                    newNFA.setTransition(i+shift,c,j+shift);
                }
            }
        }

        return newNFA;
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

        HashMap<HashMap<Integer,Character>, Set<Integer> > newStates = new HashMap<>();

        for (Character c : this.alphabet){

            for (int i = this.getInitialState(); i <= this.getNumStates() ; i++) {
               if (this.getNextStates(i,c).contains(null) ){
                   // go further
               }else{
                   // create a new State for char c
                   newStates.put(new HashMap<>(i,c),this.getNextStates(i,c));
               }
            }


        }
        for (int i = this.getInitialState(); i <= this.getNumStates() ; i++) {
            for (int j = this.getInitialState(); j <= this.getNumStates() ; j++) {

                if (this.getTransitions()[i][j].contains(null)){
                    // REMOVE NULL
                }else{

                }



            }
        }


        //DFA newDFA = new ab1.impl.Nachnamen.DFA();

        return null;
    }

    @Override
    public Boolean accepts(String w) throws IllegalCharacterException {

        DFA thisDFA = toDFA();

        int currentState = this.initialState;

        for (int i = 0 ; i < w.length(); i++) {

            if (!this.getAlphabet().contains(w.charAt(i))){
               throw new IllegalCharacterException();
            }

            if (thisDFA.getNextState(currentState,w.charAt(i)) == null && thisDFA.getAcceptingStates().contains(currentState)){
                return true;
            }

            if (thisDFA.getTransitions()[currentState][thisDFA.getNextState(currentState,w.charAt(i))].contains(w.charAt(i))){
                currentState = thisDFA.getNextState(currentState,w.charAt(i)) ;
            }
        }

        return false;
    }





    @Override
    public Boolean acceptsNothing() {

     if (this.acceptingStates.size()==0){
         return true;
     }
     return false;
    }

    @Override
    public Boolean acceptsEpsilonOnly() {

        int c = 0 ;

        for (int i = 0 ; i < numStates; i++){
            for (int j = 0; j < numStates; j++){

                if (this.transitions[i][j].contains(epsilon)){
                    c++;
                }
            }
        }

        if (c > 0){
            return true;
        }

        return false;
    }

    @Override
    public Boolean acceptsEpsilon() {

        if (getAlphabet().contains(epsilon)){
            return true;
        }

        return false;
    }

    @Override
    public boolean subSetOf(ab1.NFA b) {



        return false;
    }

    @Override
    public boolean equals(Object b){
        if (this == b){
            return true;
        }

        if (b == null || getClass() != b.getClass()){
            return false;
        }

        return this.getNumStates() == ((NFA) b).getNumStates();

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
    public int getNumStates() {
        return this.numStates;
    }

    @Override
    public Set<Character>[][] getTransitions() {
        return this.transitions;
    }



}
