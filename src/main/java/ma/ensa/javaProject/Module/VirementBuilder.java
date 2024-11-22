package ma.ensa.javaProject.Module;

import java.util.Date;

public class VirementBuilder {

    private int id;
    private Virement.Type type;
    private Date date;
    private double amount;
    private String motif;
    private Compte emetteur;
    private Compte destinataire;

    public VirementBuilder Id(int id){
        this.id = id;
        return this;
    }

    public VirementBuilder VirementType(Virement.Type type){
        this.type = type;
        return this;
    }

    public VirementBuilder Date(Date date){
        this.date = date;
        return this;
    }

    public VirementBuilder Amount(double amount){
        this.amount = amount;
        return this;
    }

    public VirementBuilder Motif(String motif){
        this.motif = motif;
        return this;
    }

    public  Virement build(){
        return new Virement(id,type,date,amount,motif);
    }
}
