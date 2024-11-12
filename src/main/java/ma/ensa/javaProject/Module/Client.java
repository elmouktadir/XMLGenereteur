package ma.ensa.javaProject.Module;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Date;

public class Client {
    private String Nom ;
    private String Prenom ;
    private Date dateNaissance;
    private String Nationalite ;
    private  String CIN; // final ?
    private String Addresse;
    private String NumMobile;
    private String email;
    private  String IdUtilisateur; // final ?

    public Client() {}

    public Client(String nom, String prenom, Date dateNaissance, String nationalite, String CIN, String addresse, String numMobile, String email) {
        Nom = nom;
        Prenom = prenom;
        this.dateNaissance = dateNaissance;
        Nationalite = nationalite;
        this.CIN = CIN;
        Addresse = addresse;
        NumMobile = numMobile;
        this.email = email;
        IdUtilisateur = IdUser();

    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNationalite() {
        return Nationalite;
    }

    public void setNationalite(String nationalite) {
        Nationalite = nationalite;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getAddresse() {
        return Addresse;
    }

    public void setAddresse(String addresse) {
        Addresse = addresse;
    }

    public String getNumMobile() {
        return NumMobile;
    }

    public void setNumMobile(String numMobile) {
        NumMobile = numMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }

    private String IdUser(){

        String codeCIN = this.CIN.substring(0,2);
        String numeroCIN = this.CIN.substring(2,this.CIN.length());
        String CINNumInverse = new StringBuilder(numeroCIN).reverse().toString();

        return this.Nom.substring(0,2) + CINNumInverse + codeCIN;
    }

}
