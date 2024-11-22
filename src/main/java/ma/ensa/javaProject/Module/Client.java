package ma.ensa.javaProject.Module;

import com.sun.istack.NotNull;
import ma.ensa.javaProject.DAO.ClientImpl;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Date;
//jloi qwff pobv lkuc
public class Client {
    private String Nom ;
    private String Prenom ;
    private Date dateNaissance;
    private String Nationalite ;
    private  String CIN; // final ?
    private String Addresse;
    private String NumMobile;
    private String email;
    private String password;
    private  String IdUtilisateur; // final ?


    public Client() {}

    public Client(String nom, String prenom, Date dateNaissance, String nationalite,
                  String CIN, String addresse, String numMobile, String email,String password) {
        this.Nom = nom;
        this.Prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.Nationalite = nationalite;
        this.CIN = CIN;
        this.Addresse = addresse;
        this.NumMobile = numMobile;
        this.email = email;
        this.password = password;
        this.IdUtilisateur = IdUser();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        IdUtilisateur = idUtilisateur;
    }

    public static ClientBuilder build(){
        return new ClientBuilder();
    }


    private String IdUser(){

        String codeCIN = this.CIN.substring(0,2);
        String numeroCIN = this.CIN.substring(2,this.CIN.length());
        String CINNumInverse = new StringBuilder(numeroCIN).reverse().toString();

        return this.Nom.substring(0,2) + CINNumInverse + codeCIN;
    }

    public static boolean isPhoneNumber(String PhoneNumber){
        String regex = "^\\+[0-9]{10,15}$";
        return PhoneNumber.matches(regex);
    }

    public static boolean isValideEmail(String email){
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }

    public static boolean authentification(String id, String password){
        ClientImpl clientImp = new ClientImpl();
        Client currentClient = clientImp.findById(id);
        if ( id.equals(currentClient.getIdUtilisateur()) && password.equals(currentClient.getPassword()) ){
            return true;
        }
        return false;
    }


}
