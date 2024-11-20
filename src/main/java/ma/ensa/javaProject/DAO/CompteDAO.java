package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Compte;

import java.util.List;

public interface CompteDAO {
    public List<Compte> findAll();
    public Compte findById(int id);
    public void save(Compte compte);
    public void update(Compte compte);
    public void delete(int id);
}
