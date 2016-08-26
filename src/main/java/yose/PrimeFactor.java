package yose;

import java.lang.Math;

public class PrimeFactor {
	private int number = 0;
	private String[] decomposition;
	
	public PrimeFactor(int number){
		this.number = number;
		calPrime();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void calPrime(){
		int exp = Math.getExponent(this.number);
		this.decomposition = new String[exp];
		for(int i = 0; i< exp; i++){
			decomposition[i] = "2";
		}
	}
}
