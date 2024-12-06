package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Beneficiaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaireImpl implements BeneficiaireDAO{
    @Override
    public List<Beneficiaire> selectAll() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        List<Beneficiaire> beneficiaires = new ArrayList<>();
        String Query = "SELECT * FROM beneficiaire;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                Beneficiaire bene = Beneficiaire.build()
                        .NumCompte(resultSet.getString("numCompte"))
                        .Nom(resultSet.getString("nom"))
                        .Prenom(resultSet.getString("prenom"))
                        .build();

                beneficiaires.add(bene);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            DBConnection.close();
        }
        return beneficiaires;
    }

    @Override
    public Beneficiaire selectByRib(String rib) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }

        String Query = "SELECT * FROM beneficiaire WHERE rib=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,rib);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Beneficiaire.build()
                        .NumCompte(resultSet.getString("numCompte"))
                        .Nom(resultSet.getString("nom"))
                        .Prenom(resultSet.getString("prenom"))
                        .build();
            }

        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            DBConnection.close();
        }
        return null;
    }

    @Override
    public void save(Beneficiaire beneficiaire) {

        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "INSERT INTO beneficiaire (numCompte,nom,prenom) VALUES (?,?,?);";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,beneficiaire.getNumCompte());
            preparedStatement.setString(2,beneficiaire.getNom());
            preparedStatement.setString(3,beneficiaire.getPrenom());

            preparedStatement.executeUpdate();
        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            DBConnection.close();
        }
    }

    @Override
    public void update(Beneficiaire beneficiaire) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "UPDATE SET beneficiaire nom=?,prenom=? WHERE numCompte=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,beneficiaire.getNom());
            preparedStatement.setString(2,beneficiaire.getPrenom());
            preparedStatement.setString(3,beneficiaire.getNumCompte());

            preparedStatement.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            DBConnection.close();
        }
    }

    @Override
    public void delete(String rib) {

        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }

        String Query = "DELETE FROM beneficiaire WHERE numCompte=?;";

        try (PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,rib);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }

    }
}
