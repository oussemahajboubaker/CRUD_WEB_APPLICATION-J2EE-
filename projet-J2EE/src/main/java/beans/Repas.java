package beans;

import java.io.Serializable;
import java.sql.Date;

public class Repas implements Serializable {
	private int id_repas;
    private double cout;
    private int NBR;
    private String date;
    private String nom_repas;
    private double depense;
    public Repas() { }

    public Repas(int id,   double c , int nb , String d ,String n,double dep ) {
        this.id_repas = id;
        this.cout = c;
        this.NBR = nb;
        this.date = d;
        this.nom_repas = n;
        this.depense = dep;
    }
    public Repas(   double c , int nb , String d ,String n,double dep ) {
        this.cout = c;
        this.NBR = nb;
        this.date = d;
        this.nom_repas = n;
        this.depense = dep;
    }

    public int getId_repas() {
        return id_repas;
    }

    public void setId_repas(int id_repas) {
        this.id_repas = id_repas;
    }

   

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public int getNBR() {
        return NBR;
    }

    public void setNBR(int NBR) {
        this.NBR = NBR;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom_repas() {
        return nom_repas;
    }

    public void setNom_repas(String nom_repas) {
        this.nom_repas = nom_repas;
    }

    public double getDepense() {
        return  this.depense ;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

  

    @Override
    public String toString() {
        return (this.id_repas + "|" + this.nom_repas + "|" + this.cout + "|" + this.NBR + "|" + this.date);
    }

    public void set_repas(int id, String n, double cout, String d) {
        this.id_repas = id;
        this.nom_repas = n;
        this.cout = cout;
        this.date = d;
    }
}
