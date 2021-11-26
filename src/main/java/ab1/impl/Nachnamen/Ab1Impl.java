package ab1.impl.Nachnamen;

import java.util.Set;

import ab1.Ab1;
import ab1.DFA;
import ab1.NFA;
import ab1.exceptions.IllegalCharacterException;

public class Ab1Impl implements Ab1 {

	@Override
	public NFA createNFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DFA createDFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {
		// TODO Auto-generated method stub
		return null;
	}


	public void reset(){

	}

	public int getCurrentState(){

		return 0;
	}

	public Integer getNextState(int s, char c) throws IllegalCharacterException, IllegalStateException {

		return 0;
	}

	public boolean isInAcceptingState(){

		return false;
	}

	public void setTransition(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException{


	}






}
