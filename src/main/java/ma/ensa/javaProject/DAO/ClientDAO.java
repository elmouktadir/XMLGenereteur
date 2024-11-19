package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Client;

import java.util.List;

public interface ClientDAO {
    public List<Client> findAll();
    public Client findById(String id);
    public void delete(String id);
    public void save(Client client);
    public void update(Client client);
}
