package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Client;
import ma.ensa.javaProject.Utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements ClientDAO{
    @Override
    public List<Client> findAll() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        List<Client> clients = new ArrayList<>();
        String Query = "SELECT * FROM client;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Client client = Client.build().Nom(resultSet.getString("nom"))
                        .Prenom(resultSet.getString("prenom"))
                        .dateNaissance(resultSet.getDate("dateNaissance"))
                        .Nationalite(resultSet.getString("nationalite"))
                        .CIN(resultSet.getString("CIN"))
                        .Addresse(resultSet.getString("addresse"))
                        .NumMobile(resultSet.getString("numMobile"))
                        .email(resultSet.getString("email"))
                        .Password(resultSet.getString("password"))
                        .IdUtilisateur(resultSet.getString("idUtilisateur")).build();
                clients.add(client);
            }
            return clients;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return clients;
    }

    @Override
    public Client findById(String id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        Client client;
        String Query = "SELECT * FROM client WHERE idUtilisateur=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return client = Client.build().Nom(resultSet.getString("nom"))
                        .Prenom(resultSet.getString("prenom"))
                        .dateNaissance(resultSet.getDate("dateNaissance"))
                        .Nationalite(resultSet.getString("nationalite"))
                        .CIN(resultSet.getString("CIN"))
                        .Addresse(resultSet.getString("addresse"))
                        .NumMobile(resultSet.getString("numMobile"))
                        .email(resultSet.getString("email"))
                        .Password(resultSet.getString("password"))
                        .IdUtilisateur(resultSet.getString("idUtilisateur")).build();
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return null;
    }

    @Override
    public void delete(String id) {

        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "DELETE FROM client WHERE idUtilisateur=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public void save(Client client) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "INSERT INTO client (nom,prenom,dateNaissance,nationalite,CIN,addresse,numMobile,email,password,idUtilisateur)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?);";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,client.getNom());
            preparedStatement.setString(2,client.getPrenom());
            preparedStatement.setDate(3, Utils.getSqlDate(client.getDateNaissance()));
            preparedStatement.setString(4,client.getNationalite());
            preparedStatement.setString(5,client.getCIN());
            preparedStatement.setString(6,client.getAddresse());
            preparedStatement.setString(7,client.getNumMobile());
            preparedStatement.setString(8,client.getEmail());
            preparedStatement.setString(9,client.getPassword());
            preparedStatement.setString(10,client.getIdUtilisateur());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public void update(Client client) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "UPDATE client SET nom=?,prenom=?,dateNaissance=?,nationalite=?,CIN=?,addresse=?,numMobile=?,email=?,password=? WHERE idUtilisateur=?";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,client.getNom());
            preparedStatement.setString(2,client.getPrenom());
            preparedStatement.setDate(3, Utils.getSqlDate(client.getDateNaissance()));
            preparedStatement.setString(4,client.getNationalite());
            preparedStatement.setString(5,client.getCIN());
            preparedStatement.setString(6,client.getAddresse());
            preparedStatement.setString(7,client.getNumMobile());
            preparedStatement.setString(8,client.getEmail());
            preparedStatement.setString(9,client.getPassword());
            preparedStatement.setString(10,client.getIdUtilisateur());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }

    }

}
