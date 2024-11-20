package ma.ensa.javaProject.Module;

import java.util.Date;

public class Compte {
    private int id;
    private String  iban;
    private double balance;
    private Client client;
    private Banque banque;

    public Compte(){}

    //Constructeur
    public Compte(int id, String iban, double balance, Client client, Banque banque) {
        this.id = id;
        this.iban = iban;
        this.balance = balance;
        this.client = client;
        this.banque = banque;
    }

    //Constructeur ne contient pas le client et la banque
    public Compte(int id, String iban, double balance) {
        this.id = id;
        this.iban = iban;
        this.balance = balance;

    }

    //Getter Setter

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", balance='" + balance + '\'' +
                ", client=" + client +
                ", banque=" + banque +
                '}';
    }

    //Despose des montants
    public void deposit(double amount){
        if (amount > 0) {
            this.setBalance(this.getBalance()+amount);
            System.out.println("Depot reussi. Nouveau Solde : "+this.getBalance());
        }else {
            System.out.println("le montant doit etre positif.");
        }
    }
    // Retrait des montants
    public void withDraw(double amount){
        if (amount>0 && amount<=this.getBalance()){
            balance -= amount;
            System.out.println("Retrait reussi.Nouveau Solde : " +this.getBalance());
        }else{
            System.out.println("Fonds insuffisants ou montant invalide");
        }
    }

    public void transfer(Compte compteRecu, double amount){
        if (amount>0 && amount<=this.getBalance()) {
            this.withDraw(amount);
            compteRecu.deposit(amount);
            System.out.println("Virement effectue de "+amount+" à "+compteRecu.getIban());
        }else {
            System.out.println("Virement echoue. Fonds insuffisants ou montant invalide");
        }
    }

    public static CompteBuilder build(){
        return new CompteBuilder();
    }
}
