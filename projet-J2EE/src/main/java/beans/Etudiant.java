package beans;

import java.io.Serializable;


public class Etudiant extends Personne implements Serializable {
	private String Faculte;
    
  
    public Etudiant(int id, String n, String p, int t, String fac)
    {
        super(id, n, p, t);
        this.Faculte = fac;
    }
    public Etudiant(String n, String p, int t, String fac)
    {
        super( n, p, t);
        this.Faculte = fac;
    }
    public Etudiant()
    {
      
    }
    public Etudiant(String n, String p, int t) {
        super(n, p, t);
    }

    public String getFaculte() {
        return Faculte;
    }

    public void setFaculte(String faculté) {
        Faculte = faculté;
    }

 


    public void set_personne(int id, String n, String p, int t) {
    	super.setId(id) ;
    	super.setNom(n);
        super.setPrenom(p);
       super.setTel(t);
    }

   
    public String toString() {
        return (this.getId()+ this.getNom()  + this.getPrenom()  + this.getTel() + this.Faculte  );
    }

	

	
}
