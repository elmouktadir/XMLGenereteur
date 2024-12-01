package ma.ensa.javaProject.Module;

public class Beneficiaire {
    //RIB
    private int id;
    private String numCompte;
    private String nom;
    private String prenom;
    private int idVirement;

    public Beneficiaire(){}

    public Beneficiaire(String numCompte, String nom, String prenom, int idVir) {
        this.numCompte = numCompte;
        this.nom = nom;
        this.prenom = prenom;
        this.idVirement = idVir;
    }

    public Beneficiaire(int id,String numCompte, String nom, String prenom,int idVir) {
        this.id = id;
        this.numCompte = numCompte;
        this.nom = nom;
        this.prenom = prenom;
        this.idVirement = idVir;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCompte() {
        return this.numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Beneficiaire{" +
                "NumCompte='" + this.numCompte + '\'' +
                ", Nom='" + this.nom + '\'' +
                ", Prenom='" + this.prenom + '\'' +
                '}';
    }

    public static BeneficiaireBuilder build(){
        return new BeneficiaireBuilder();
    }
}
