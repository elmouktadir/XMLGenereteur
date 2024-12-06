package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Client;
import ma.ensa.javaProject.Module.Compte;
import ma.ensa.javaProject.Utils.Utils;

import java.sql.*;
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
                Client client = Client.build()
                        .Id(resultSet.getInt("id"))
                        .Nom(resultSet.getString("nom"))
                        .Prenom(resultSet.getString("prenom"))
                        .dateNaissance(resultSet.getDate("dateNaissance"))
                        .Nationalite(resultSet.getString("nationalite"))
                        .CIN(resultSet.getString("CIN"))
                        .Addresse(resultSet.getString("address"))
                        .NumMobile(resultSet.getString("numMobile"))
                        .email(resultSet.getString("email"))
                        .Password(resultSet.getString("password"))
                        .IdUtilisateur(resultSet.getString("idUtilisateur"))
                        .Iban("iban")
                        .CodeSwift("codeSwift")
                        .build();

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
    public Client findById(String idUser){
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        Client client;
        String Query = "SELECT * FROM client WHERE idUtilisateur=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,idUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                client = Client.build()
                        .Id(resultSet.getInt("id"))
                        .Nom(resultSet.getString("nom"))
                        .Prenom(resultSet.getString("prenom"))
                        .dateNaissance(resultSet.getDate("dateNaissance"))
                        .Nationalite(resultSet.getString("nationalite"))
                        .CIN(resultSet.getString("CIN"))
                        .Addresse(resultSet.getString("address"))
                        .NumMobile(resultSet.getString("numMobile"))
                        .email(resultSet.getString("email"))
                        .Password(resultSet.getString("password"))
                        .IdUtilisateur(resultSet.getString("idUtilisateur"))
                        .Iban("iban")
                        .CodeSwift("codeSwift")
                        .build();
                return client;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return null;
    }

    @Override
    public Client findById(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        Client client;
        String Query = "SELECT * FROM client WHERE id=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                client = Client.build()
                        .Nom(resultSet.getString("nom"))
                        .Prenom(resultSet.getString("prenom"))
                        .dateNaissance(resultSet.getDate("dateNaissance"))
                        .Nationalite(resultSet.getString("nationalite"))
                        .CIN(resultSet.getString("CIN"))
                        .Addresse(resultSet.getString("address"))
                        .NumMobile(resultSet.getString("numMobile"))
                        .email(resultSet.getString("email"))
                        .Password(resultSet.getString("password"))
                        .IdUtilisateur(resultSet.getString("idUtilisateur"))
                        .Iban("iban")
                        .CodeSwift("codeSwift")
                        .build();
                client.setId(id);
                return client;
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
//    public void save(Client client) {
//        Connection conn = DBConnection.getConnection();
//        if (conn == null) {
//            return;
//        }
//        String Query = "INSERT INTO client (nom,prenom,dateNaissance,nationalite,CIN,address,numMobile,email,password,idUtilisateur)" +
//                " VALUES (?,?,?,?,?,?,?,?,?,?);";
//        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
//
//            preparedStatement.setString(1,client.getNom());
//            preparedStatement.setString(2,client.getPrenom());
//            preparedStatement.setDate(3, Utils.getSqlDate(client.getDateNaissance()));
//            preparedStatement.setString(4,client.getNationalite());
//            preparedStatement.setString(5,client.getCIN());
//            preparedStatement.setString(6,client.getAddresse());
//            preparedStatement.setString(7,client.getNumMobile());
//            preparedStatement.setString(8,client.getEmail());
//            preparedStatement.setString(9,client.getPassword());
//            preparedStatement.setString(10,client.getIdUtilisateur());
//
//            // Execute update
//            int affectedRows = preparedStatement.executeUpdate();
//
//            // Check if a row was inserted and retrieve the generated key
//            if (affectedRows > 0) {
//                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        client.setId(generatedKeys.getInt(1)); // Assuming the ID is an integer
//                        System.out.println("Client ajouté avec succès. ID généré : " + client.getId());
//                    }
//                }
//            } else {
//                System.out.println("Échec de l'insertion du client.");
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DBConnection.close();
//        }
//    }
    public void save(Client client) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }

        String Query = "INSERT INTO client (nom,prenom,dateNaissance,nationalite,CIN,address,numMobile,email,password,idUtilisateur,iban,codeSift)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

        try (PreparedStatement preparedStatement = conn.prepareStatement(Query, Statement.RETURN_GENERATED_KEYS)) {

            // Set parameters
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setDate(3, Utils.getSqlDate(client.getDateNaissance()));
            preparedStatement.setString(4, client.getNationalite());
            preparedStatement.setString(5, client.getCIN());
            preparedStatement.setString(6, client.getAddresse());
            preparedStatement.setString(7, client.getNumMobile());
            preparedStatement.setString(8, client.getEmail());
            preparedStatement.setString(9, client.getPassword());
            preparedStatement.setString(10, client.getIban());
            preparedStatement.setString(11, client.getCodeSwift());
            preparedStatement.setString(12, client.getIdUtilisateur());

            // Execute update
            int affectedRows = preparedStatement.executeUpdate();

            // Check if a row was inserted and retrieve the generated key
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        client.setId(generatedKeys.getInt(1)); // Assuming the ID is an integer
                        System.out.println("Client ajouté avec succès. ID généré : " + client.getId());
                    }
                }
            } else {
                System.out.println("Échec de l'insertion du client.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close();
        }
    }


    @Override
    public void update(Client client) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "UPDATE client SET nom=?,prenom=?,dateNaissance=?,nationalite=?,CIN=?,addresse=?,numMobile=?,email=?,password=?,iban=?,codeSwift=? WHERE idUtilisateur=?";

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
            preparedStatement.setString(10,client.getIban());
            preparedStatement.setString(11,client.getCodeSwift());
            preparedStatement.setString(12,client.getIdUtilisateur());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public void afficherCompteByClient(int id) {

        CompteImpl compteImpl = new CompteImpl();
        Client client = findById(id);
        List<Compte> comptes = compteImpl.findById(id);

        client.setComptes(comptes);
        //afficher le client
        System.out.println(client);
        //afficher nos comptes
        for (int i = 0; i < comptes.size(); i++) {

            System.out.println(comptes.get(i));

        }
    }
}
