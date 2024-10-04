package beans;

public class LigPresence {
	 private int id;
	  private int idetudiant;
	  private String dateLP;

	  public LigPresence() {}

	  public LigPresence(int id, String D) {
	    this.idetudiant = id;
	    this.dateLP = D;
	  }
	  public LigPresence(int id, String D,int ide) {
		     this.id=id;
		    this.idetudiant = id;
		    this.dateLP = D;
		  }

	  public int getid() {
	    return id;
	  }

	public void setid(int iD_LigPresence) {
		id = iD_LigPresence;
	}

	public String getDateLP() {
		return dateLP;
	}

	public void setDateLP(String dateLP) {
		this.dateLP = dateLP;
	}



	  public int getIdetudiant() {
	    return idetudiant;
	  }

	  public void setIdetudiant(int idetudiant) {
	    this.idetudiant = idetudiant;
	  }



	  public String getLigPresence() {
	    return this.getIdetudiant() + " " + this.getDateLP().toString();
	  }
}
