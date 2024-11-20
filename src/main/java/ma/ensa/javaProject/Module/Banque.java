package ma.ensa.javaProject.Module;

import java.util.List;

public class Banque {
    private int id;
    private String nom;
    private String swiftCode;
    private String address;
    private List<Client> clients;

    public Banque(){}

    public Banque(int id, String nom, String swiftCode, String address, List<Client> clients) {
        this.id = id;
        this.nom = nom;
        this.swiftCode = swiftCode;
        this.address = address;
        this.clients = clients;
    }

    public Banque(int id, String nom, String swiftCode, String address) {
        this.id = id;
        this.nom = nom;
        this.swiftCode = swiftCode;
        this.address = address;

    }

    //Getter et Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    //Methode ajouter une client
    public void addClient(Client client){
        clients.add(client);
    }

    //la liste des comptes dans la banque
    public Client getClientById(String id){
        for (Client client : clients){
            if (client.getIdUtilisateur() == id) {
                return client;
            }
        }
        return null; // si le client n'existe pas
    }

    @Override
    public String toString(){
        return "Banque {id= "+ id +" ,nom= "+nom+" ,swiftCode= "+swiftCode+" ,addresse= "+address+" }";
    }

    // builder
    public static BanqueBuilder build(){
        return new BanqueBuilder();
    }
}
