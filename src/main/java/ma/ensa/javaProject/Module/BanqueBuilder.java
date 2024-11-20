package ma.ensa.javaProject.Module;

import java.util.ArrayList;
import java.util.List;

public class BanqueBuilder {
    private int id;
    private String nom;
    private String swiftCode;
    private String address;
    private List<Client> clients;

    public BanqueBuilder Id(int id){
        this.id = id;
        return this;
    }
    public BanqueBuilder Nom(String nom){
        this.nom = nom;
        return this;
    }
    public BanqueBuilder SwiftCode(String swiftCode){
        this.swiftCode = swiftCode;
        return this;
    }
    public BanqueBuilder Address(String address){
        this.address = address;
        return this;
    }
    public BanqueBuilder Clients(List<Client> clients){
        this.clients = clients;
        return this;
    }

    public Banque build(){
        return new Banque(id,nom,address,swiftCode);
    }
}
