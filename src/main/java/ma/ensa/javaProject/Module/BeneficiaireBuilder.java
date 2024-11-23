package ma.ensa.javaProject.Module;

public class BeneficiaireBuilder {
    private String numCompte;
    private String nom;
    private String prenom;

    public BeneficiaireBuilder NumCompte(String numCompte){
      this.numCompte = numCompte;
        return this;
    }

    public BeneficiaireBuilder Nom(String nom){
      this.nom = nom;
        return this;
    }

    public BeneficiaireBuilder Prenom(String prenom){
      this.prenom = prenom;
        return this;
    }

    public Beneficiaire build(){
        return new Beneficiaire(numCompte,nom,prenom);
    }
}
