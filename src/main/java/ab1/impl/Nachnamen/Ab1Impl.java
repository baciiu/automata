package ab1.impl.Nachnamen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import ab1.Ab1;
import ab1.DFA;
import ab1.NFA;
import ab1.exceptions.IllegalCharacterException;

public class Ab1Impl implements Ab1 {

	private Set<Character> alphabet = new HashSet<>();
	private Set<Integer> acceptingStates = new HashSet<>();
	private int initialState = 0;
	private Set<Character>[][] transitions ;
	private int currentState = 0;
	private int numStates = 0;
	private final char epsilon = ' ';



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

	/*************************  NFA METHODS  ********************************/

	public Set<Character> getAlphabet(){

		return null;
	}

	public Set<Integer> getAcceptingStates(){

		return null;
	}

	public int getInitialState(){

		return 0;
	}

	public boolean isAcceptingState(int s) throws IllegalStateException{
		return false;
	}

	public Set<Character>[][] getTransitions(){

		return null;
	}

	public void setTransitionNFA(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException
	{

	}

	/*************************  DFA METHODS  ********************************/

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

	public void setTransitionDFA(int fromState, Character c, int toState) throws IllegalStateException, IllegalCharacterException{


	}

	public void clearTransitions(int fromState, Character c) throws IllegalStateException{

	}

	public Set<Integer> getNextStates(int state, Character c) throws IllegalCharacterException, IllegalStateException{

		return null;
	}

	public int getNumStates(){


		return 0;
	}

	public NFA union(NFA a){

		return null;
	}

	public NFA intersection(NFA a){

		return null;
	}

	public NFA minus(NFA a){

		return null;
	}

	public NFA concat(NFA a){

		return null;
	}

	public NFA complement(){

		return null;
	}

	public NFA kleeneStar(){

		return null;
	}

	public NFA plus(){

		return null;
	}

	public DFA toDFA(){

		return null;
	}

	public Boolean accepts(String w) throws IllegalCharacterException{

		return false;
	}

	public Boolean acceptsNothing(){

		return false;
	}

	public Boolean acceptsEpsilonOnly(){

		return false;
	}

	public Boolean acceptsEpsilon(){

		return false;
	}

	public boolean subSetOf(NFA b){

		return false;
	}

	@Override
	public boolean equals(Object b){

		return false;
	}



}
