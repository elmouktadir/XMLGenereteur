package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Beneficiaire;

import java.util.List;

public interface BeneficiaireDAO {
    public List<Beneficiaire> selectAll();
    public void save(Beneficiaire beneficiaire);
}
