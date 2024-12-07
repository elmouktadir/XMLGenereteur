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
    private Virement.Type type;
    private Date date;
    private double amount;
    private String devise ;
    private String motif;
    private Client client;
    private Beneficiaire destinataire;
    private int idclient;
    private int idbeneficiaire;


    public Virement() {}

    public Virement(Type type,Date date, double amount, String devise ,String motif, Client client, Beneficiaire destinataire) {

        this.type         = type;
        this.date         = date;
        this.amount       = amount;
        this.devise       = devise;
        this.motif        = motif;
        this.idclient     = client.getId();
        this.idbeneficiaire = destinataire.getId();

    }

    public Virement(int id,Type type,Date date, double amount, String devise,String motif,int idclient, int idbeneficiaire) {
        this.id             = id;
        this.type           = type;
        this.date           = date;
        this.devise         = devise;
        this.amount         = amount;
        this.motif          = motif;
        this.idclient       = idclient;
        this.idbeneficiaire = idbeneficiaire;
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


    public Beneficiaire getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Beneficiaire destinataire) {
        this.destinataire = destinataire;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public int getIdbeneficiaire() {
        return idbeneficiaire;
    }

    public void setIdbeneficiaire(int idbeneficiaire) {
        this.idbeneficiaire = idbeneficiaire;
    }

    public static VirementBuilder build(){
        return new VirementBuilder();
    }

    public boolean sameCountry(){
        return this.client.getIban().substring(0,1).equals(this.destinataire.getIban().substring(0,1));
    }

    public boolean sameBanque(){
        return this.destinataire.getBIC().substring(0,3).equals(this.destinataire.getBIC().substring(0,3));
    }

    @Override
    public String toString() {
        return "Virement{" +
                "id=" + id +
                ", type=" + type +
                ", date=" + date +
                ", amount=" + amount +
                ", motif='" + motif + '\'' +
                ", idclient=" + idclient +
                ", idbeneficiaire=" + idbeneficiaire +
                '}';
    }
}
