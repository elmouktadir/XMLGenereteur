package ma.ensa.javaProject.Module;

import java.util.Date;

public class Virement {

    public enum Type{
        VIRINT,
        VIREST,
        VIRCHAC,
        VIRMULTA,
        VIRMASS;
    }

    private int id;
    private Type type;
    private Date date;
    private double amount;
    private String motif;
    private Compte emetteur;
    private Beneficiaire destinataire;
    private int Idclient;
    private int Idbeneficiaire;


    public Virement(){}

    public Virement(Type type,Date date, double amount, String motif, Compte emetteur, Beneficiaire destinataire) {

        this.type         = type;
        this.date         = date;
        this.amount       = amount;
        this.motif        = motif;
        this.Idclient     = emetteur.getId();
        this.Idbeneficiaire = destinataire.getId();

    }

    public Virement(int id,Type type,Date date, double amount, String motif) {
        this.id           = id;
        this.type         = type;
        this.date         = date;
        this.amount       = amount;
        this.motif        = motif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Compte emetteur) {
        this.emetteur = emetteur;
    }

    public Beneficiaire getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Beneficiaire destinataire) {
        this.destinataire = destinataire;
    }

    public static VirementBuilder build(){
        return new VirementBuilder();
    }
}
