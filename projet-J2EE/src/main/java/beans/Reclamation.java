package beans;

import java.io.Serializable;
import java.sql.Date;

public class Reclamation implements Serializable {
	private String desc;
	private String date;
	private int idetudiant ;
	private int id ;



	public int getidetudiant() {
		return idetudiant;
	}

	public void setidetudiant(int idet) {
		this.idetudiant = idet;
	}

	public Reclamation() {}

	public Reclamation(String desc,String date ,int idet) {

		this.date=date ;
		this.desc=desc;
		this.idetudiant=idet;
	}
	public Reclamation(int id,String date ,String desc,int idet) {
		this.id=id ;

		this.date=date ;
		this.desc=desc;
		this.idetudiant=idet;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReclamation() {
		return this.getId() + "-" + this.getDate().toString() + "-" + this.getDesc();
	}

}
