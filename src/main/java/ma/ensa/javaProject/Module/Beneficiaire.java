package ma.ensa.javaProject.Module;

public class Beneficiaire {

    //RIB
    private int id;
    private String iban;
    private String BIC;
    private String nom;
    private String prenom;
    private int idVirement;

    public Beneficiaire(){}

    public Beneficiaire(String iban, String BIC, String nom, String prenom, int idVir) {
        this.iban = iban;
        this.BIC = BIC;
        this.nom = nom;
        this.prenom = prenom;
        this.idVirement = idVir;
    }

    public Beneficiaire(String iban, String BIC, String nom, String prenom) {
        this.iban = iban;
        this.BIC = BIC;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Beneficiaire(String iban, String BIC, String nom, String prenom,int idVir, int id) {
        this.id = id;
        this.iban = iban;
        this.BIC = BIC;
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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
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

    public int getIdVirement() {
        return idVirement;
    }

    public void setIdVirement(int idVirement) {
        this.idVirement = idVirement;
    }

    @Override
    public String toString() {
        return "Beneficiaire{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", BIC='" + BIC + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", idVirement=" + idVirement +
                '}';
    }

    public static BeneficiaireBuilder build(){
        return new BeneficiaireBuilder();
    }
}
