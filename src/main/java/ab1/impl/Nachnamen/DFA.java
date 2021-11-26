package ab1.impl.Nachnamen;


import ab1.NFA;
import ab1.exceptions.IllegalCharacterException;

import java.util.Set;

public class DFA  implements ab1.DFA {

    @Override
    public void reset() {

    }

    @Override
    public int getCurrentState() {
        return 0;
    }

    @Override
    public int doStep(char c) throws IllegalCharacterException, IllegalStateException {
        return 0;
    }

    @Override
    public Integer getNextState(int s, char c) throws IllegalCharacterException, IllegalStateException {
        return null;
    }

    @Override
    public boolean isInAcceptingState() {
        return false;
    }

    @Override
    public Set<Character> getAlphabet() {
        return null;
    }

    @Override
    public Set<Integer> getAcceptingStates() {
        return null;
    }

    @Override
    public int getInitialState() {
        return 0;
    }

    @Override
    public boolean isAcceptingState(int s) throws IllegalStateException {
        return false;
    }

    @Override
    public Set<Character[][]> getTransitions() {
        return null;
    }

    @Override
    public void setTransition(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException {

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
    public NFA union(NFA a) {
        return null;
    }

    @Override
    public NFA intersection(NFA a) {
        return null;
    }

    @Override
    public NFA minus(NFA a) {
        return null;
    }

    @Override
    public NFA concat(NFA a) {
        return null;
    }

    @Override
    public NFA complement() {
        return null;
    }

    @Override
    public NFA kleeneStar() {
        return null;
    }

    @Override
    public NFA plus() {
        return null;
    }

    @Override
    public ab1.DFA toDFA() {
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
    public boolean subSetOf(NFA b) {
        return false;
    }
}
