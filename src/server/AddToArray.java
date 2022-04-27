package server;

import java.util.ArrayList;

public class AddToArray {
	ArrayList<String> holdAL = new ArrayList<String>();
	
	public AddToArray(String holdnavn){
		holdAL.add(holdnavn);
	}
	
	public ArrayList getHoldAL(){
		return holdAL;
	}
}
