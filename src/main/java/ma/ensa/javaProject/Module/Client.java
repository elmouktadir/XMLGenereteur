package ma.ensa.javaProject.Module;

import com.sun.istack.NotNull;
import ma.ensa.javaProject.DAO.ClientImpl;
import ma.ensa.javaProject.DAO.VirementImpl;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//jloi qwff pobv lkuc
public class Client {

    private int id;
    private String Nom ;
    private String Prenom ;
    private Date dateNaissance ;
    private String Nationalite ;
    private String CIN ; // final ?
    private String Addresse ;
    private String NumMobile ;
    private String email ;
    private String password ;
    private String IdUtilisateur ; // final ?
    private String iban ;
    private String codeSwift ;
    private List<Virement> virements ;


    public Client() {}

    public Client(String nom, String prenom, Date dateNaissance, String nationalite,
                  String CIN, String addresse, String numMobile, String email,String password, String iban, String codeSwift) {
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
        this.iban = iban;
        this.codeSwift = codeSwift;
        this.virements = new ArrayList<>();
    }

    public Client(int id ,String nom, String prenom, Date dateNaissance, String nationalite,
                  String CIN, String addresse, String numMobile, String email,String password,String idUtilisateur, String iban, String codeSwift) {
        this.id = id;
        this.Nom = nom;
        this.Prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.Nationalite = nationalite;
        this.CIN = CIN;
        this.Addresse = addresse;
        this.NumMobile = numMobile;
        this.email = email;
        this.password = password;
        this.IdUtilisateur = idUtilisateur;
        this.iban = iban;
        this.codeSwift = codeSwift;
        this.virements = new ArrayList<>();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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

    public List<Virement> getVirements() {
        return virements;
    }

    public void setComptes(List<Virement> virements) {
        this.virements = virements;
    }

    public void addVirement(Virement virement){
        this.virements.add(virement);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCodeSwift() {
        return codeSwift;
    }

    public void setCodeSwift(String codeSwift) {
        this.codeSwift = codeSwift;
    }

    public static ClientBuilder build(){
        return new ClientBuilder();
    }

    @Override
    public String toString() {
        return "Client{" +
                "Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", Nationalite='" + Nationalite + '\'' +
                ", CIN='" + CIN + '\'' +
                ", Addresse='" + Addresse + '\'' +
                ", NumMobile='" + NumMobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", IdUtilisateur='" + IdUtilisateur + '\'' +
                '}';
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

    public static boolean isValideIban(String iban){
        String ibanRegex = "^[A-Z]{2}\\d{2}[A-Z0-9]{1,30}$";
        return iban != null && iban.matches(ibanRegex);
    }

    public static boolean isValideCodeSwift(String codeSwift){
        String bicRegex = "^[A-Z]{4}[A-Z]{2}[A-Z0-9]{2}([A-Z0-9]{3})?$";
        return codeSwift != null && codeSwift.matches(bicRegex);
    }

    public static boolean authentification(String idUser, String password){
        ClientImpl clientImp = new ClientImpl();
        Client currentClient = clientImp.findById(idUser);
        if ( idUser.equals(currentClient.getId()) && password.equals(currentClient.getPassword()) ){
            return true;
        }
        return false;
    }


}
