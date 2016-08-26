package yose;

public class Status {
	private boolean alive;
	String astport = "Astro";
	
	public Status(boolean alive){
		this.alive = alive;
		//this.astport = astport;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
//	public String getAstroport() {
//		return astport;
//	}
//
//	public void setAstroport(String astport) {
//		this.astport = astport;
//	}
}
