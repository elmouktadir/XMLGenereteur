package ma.ensa.javaProject.Module;

public class CompteBuilder {
    private int id;
    private String  rib;
    private double balance;
    private Client client;
    private Banque banque;

    public CompteBuilder Id(int id){
        this.id = id;
        return this;
    }

    public CompteBuilder Rib(String rib) {
        this.rib = rib;
        return this;
    }

    public CompteBuilder Balance(double balance) {
        this.balance = balance;
        return this;
    }

    public CompteBuilder Client(Client client) {
        this.client = client;
        return this;
    }

    public CompteBuilder Banque(Banque banque) {
        this.banque = banque;
        return this;
    }

    public Compte build(){
        return new Compte(id,rib,balance);
    }


}
