package ab1.impl.Nachnamen;

import ab1.exceptions.IllegalCharacterException;

import java.util.Set;

public class DFA extends NFA implements ab1.DFA {


    public DFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {
        super(numStates, characters, acceptingStates, initialState);
    }

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
}
