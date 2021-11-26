package ab1.impl.Nachnamen;


import ab1.Ab1;
import ab1.DFA;
import ab1.NFA;
import ab1.exceptions.IllegalCharacterException;

import java.util.Set;

public class Ab1Impl implements Ab1 {


	@Override
	public NFA createNFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {
		// TODO Auto-generated method stub


		return new ab1.impl.Nachnamen.NFA(numStates,characters,acceptingStates,initialState);
	}

	@Override
	public DFA createDFA(int numStates, Set<Character> characters, Set<Integer> acceptingStates, int initialState) {
		// TODO Auto-generated method stub


		return new DFA(numStates,characters,acceptingStates,initialState);
	}


}