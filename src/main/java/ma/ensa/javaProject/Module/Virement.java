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
    private Compte destinataire;

    public Virement(){}

    public Virement(Type type,Date date, double amount, String motif, Compte emetteur, Compte destinataire) {
        this.type         = type;
        this.date         = date;
        this.amount       = amount;
        this.motif        = motif;
        this.emetteur     = emetteur;
        this.destinataire = destinataire;
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

    public Compte getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Compte destinataire) {
        this.destinataire = destinataire;
    }

    public static VirementBuilder build(){
        return new VirementBuilder();
    }
}
