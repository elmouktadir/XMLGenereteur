package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Client;
import ma.ensa.javaProject.Module.Virement;
import ma.ensa.javaProject.Module.VirementBuilder;

import java.util.List;

public interface VirementDAO {
    public List<Virement> findAll();
    public Virement findById(int id);
    public void delete(int id);
    public void save(Virement virement);
    public void update(Virement virement);
}
