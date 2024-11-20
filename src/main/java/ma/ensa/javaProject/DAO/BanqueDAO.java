package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Banque;

import java.util.List;

public interface BanqueDAO {
    public List<Banque> findAll();
    public Banque findById(int id);
    public void save(Banque banque);
    public void update(Banque banque);
    public void delete(int id);
}
