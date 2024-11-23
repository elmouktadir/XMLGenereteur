package ma.ensa.javaProject.Module;

public class Beneficiaire {
    //RIB
    private String numCompte;
    private String nom;
    private String prenom;

    public Beneficiaire(){}

    public Beneficiaire(String numCompte, String nom, String prenom) {
        this.numCompte = numCompte;
        this.nom = nom;
        this.prenom = prenom;
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
