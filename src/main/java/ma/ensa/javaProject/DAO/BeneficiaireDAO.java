package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Beneficiaire;

import java.util.List;

public interface BeneficiaireDAO {
    public List<Beneficiaire> selectAll();
    public Beneficiaire selectByRib(String rib);
    public void save(Beneficiaire beneficiaire);
    public void update(Beneficiaire beneficiaire);
    public void delete(String rib);
}
