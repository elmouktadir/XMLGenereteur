package ma.ensa.javaProject.Module;

import java.util.ArrayList;
import java.util.List;

public class Banque {
    private int id;
    private String nom;
    private String swiftCode;
    private String address;
    private List<Compte> comptes;

    public Banque(){}

    public Banque(int id, String nom, String swiftCode, String address) {
        this.id = id;
        this.nom = nom;
        this.swiftCode = swiftCode;
        this.address = address;
        this.comptes = new ArrayList<>();
    }

    public Banque(String nom, String swiftCode, String address) {
        this.nom = nom;
        this.swiftCode = swiftCode;
        this.address = address;
    }

    //Getter et Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    //Methode ajouter une client
    public void addCompte(Compte compte){
        comptes.add(compte);
    }

    //la liste des comptes dans la banque
    public Compte getClientById(int id){
        for (Compte compte : comptes){
            if (compte.getId() == id) {
                return compte;
            }
        }
        return null; // si le client n'existe pas
    }

    @Override
    public String toString(){
        return "Banque {id= "+ id +" ,nom= "+nom+" ,swiftCode= "+swiftCode+" ,addresse= "+address+" }";
    }

    // builder
    public static BanqueBuilder build(){
        return new BanqueBuilder();
    }
}
