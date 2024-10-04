package beans;

import java.io.Serializable;

public class Employee  extends Personne implements Serializable {

private String Poste;

    public Employee(int id, String n, String p, int t, String fonc) {
        super(id, n, p, t);
        this.Poste = fonc;
    }
    public Employee( String n, String p, int t, String fonc) {
        super( n, p, t);
        this.Poste = fonc;
    }
    public Employee() {
        
    }
   
	public void set_personne(int id, String n, String p, int t) {
    	super.setId(id) ;
    	super.setNom(n);;
        super.setPrenom(p);
       super.setTel(t);
      
    }
    public String getPoste() {
        return Poste;
    }

    public void setPoste(String fonction) {
        this.Poste = fonction;
    }

    @Override
    public String toString() {
        return( this.getId() + this.getNom()  + this.getPrenom()  + this.getTel() +  this.Poste);
    }

}
