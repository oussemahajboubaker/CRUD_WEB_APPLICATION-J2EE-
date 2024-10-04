package beans;
import java.io.Serializable;

public abstract class Personne implements Serializable {

	    private int id;
	    private String nom;
	    private String prenom;
	    private int Tel;

	    public Personne () {}
	    
		public Personne(int id, String n, String p,int t) {
			this.id = id;
			this.nom = n;
			this.prenom = p;
			this.Tel = t;
		}
		
		public Personne( String n, String p,int t) {
			this.nom = n;
			this.prenom = p;
			this.Tel = t;
		}
	    public int getId()
	    {
	        return id;
	    }

	    public void setId(int id)
	    {
	        this.id = id;
	    }

	    public String getNom()
	    {
	        return nom;
	    }

	    public void setNom(String nom)
	    {
	        this.nom = nom;
	    }

	    public String getPrenom() 
	    {
	        return prenom;
	    }

	    public void setPrenom(String prenom) 
	    {
	        this.prenom = prenom;
	    }

	    public int getTel() 
	    {
	        return Tel;
	    }

	    public void setTel(int tel) 
	    {
	        Tel = tel;
	    }
	    public abstract void set_personne(int id, String n, String p, int t);
	
}
