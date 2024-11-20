package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Banque;
import ma.ensa.javaProject.Module.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompteImpl implements CompteDAO{
    @Override
    public List<Compte> findAll() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        List<Compte> comptes = new ArrayList<>();
        String Query = "SELECT * FROM compte;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Compte compte = Compte.build().Id(resultSet.getInt("id"))
                        .Iban(resultSet.getString("iban"))
                        .Balance(resultSet.getDouble("balance"))
                        .build();
                comptes.add(compte);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return comptes;
    }

    @Override
    public Compte findById(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }

        String Query = "SELECT * FROM compte WHERE id=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Compte.build().Id(resultSet.getInt("id"))
                        .Iban(resultSet.getString("iban"))
                        .Balance(resultSet.getDouble("balance"))
                        .build();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return null;
    }

    @Override
    public void save(Compte compte) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "INSERT INTO banque (id,iban,balance) VALUES (?,?,?);";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setInt(1,compte.getId());
            preparedStatement.setString(2,compte.getIban());
            preparedStatement.setDouble(3,compte.getBalance());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public void update(Compte compte) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "UPDATE banque SET iban=?,balance=? WHERE id=?";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,compte.getIban());
            preparedStatement.setDouble(2,compte.getBalance());
            preparedStatement.setInt(3,compte.getId());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public void delete(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "DELETE FROM compte WHERE id=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }
}
