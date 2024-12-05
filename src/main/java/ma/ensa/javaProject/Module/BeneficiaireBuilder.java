package ma.ensa.javaProject.Module;

public class BeneficiaireBuilder {

    private int id;
    private String iban;
    private String BIC;
    private String nom;
    private String prenom;
    private int idVirement;

    public BeneficiaireBuilder Iban(String iban){
      this.iban = iban;
        return this;
    }

    public BeneficiaireBuilder Bic(String BIC){
      this.BIC = BIC;
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
        return new Beneficiaire(iban,BIC,nom,prenom);
    }
}
