package ma.ensa.javaProject.Module;

import java.util.Date;

public class ClientBuilder {
    private int id;
    private String Nom ;
    private String Prenom ;
    private Date dateNaissance;
    private String Nationalite ;
    private  String CIN; // final ?
    private String Addresse;
    private String NumMobile;
    private String email;
    private String password;
    private  String IdUtilisateur;

    public ClientBuilder(){}

    public ClientBuilder Id(int id){
        this.id = id;
        return this;
    }

    public ClientBuilder Nom(String Nom){
        this.Nom = Nom;
        return this;
    }

    public ClientBuilder Prenom(String Prenom){
        this.Prenom = Prenom;
        return this;
    }

    public ClientBuilder dateNaissance(Date dateNaissance){
        this.dateNaissance = dateNaissance;
        return this;
    }

    public ClientBuilder Nationalite(String Nationalite){
        this.Nationalite = Nationalite;
        return this;
    }

    public ClientBuilder CIN(String CIN){
        this.CIN = CIN;
        return this;
    }

    public ClientBuilder Addresse(String Addresse){
        this.Addresse = Addresse;
        return this;
    }

    public ClientBuilder NumMobile(String NumMobile){
        this.NumMobile = NumMobile;
        return this;
    }

    public ClientBuilder email(String email){
        this.email = email;
        return this;
    }
    public ClientBuilder Password(String password){
        this.password = password;
        return this;
    }

    public ClientBuilder IdUtilisateur(String IdUtilisateur){
        this.IdUtilisateur = IdUtilisateur;
        return this;
    }

    public Client build(){
        return new Client(id,Nom,Prenom,dateNaissance,Nationalite,CIN,Addresse,NumMobile,email,password,IdUtilisateur);
    }


}
