package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Banque;
import ma.ensa.javaProject.Module.Client;
import ma.ensa.javaProject.Module.Compte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompteImpl implements CompteDAO{
    @Override
    public  List<Compte> findAll() {
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
                        .Rib(resultSet.getString("rib"))
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
    public List<Compte> findById(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        List<Compte> comptes = new ArrayList<>();
        String Query = "SELECT * FROM compte WHERE idClient=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Compte compte = Compte.build()
                        .Rib(resultSet.getString("iban"))
                        .Balance(resultSet.getDouble("balance"))
                        .build();
                compte.getClient().setId(id);
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
    public Compte selectById(int idBanque){
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        String Query = "SELECT * FROM compte WHERE idBanque=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,idBanque);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Compte compte = Compte.build()
                        .Rib(resultSet.getString("iban"))
                        .Balance(resultSet.getDouble("balance"))
                        .build();
                compte.getBanque().setId(idBanque);
                return compte;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return null;
    }


    @Override
    public  void save(Compte compte) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "INSERT INTO compte (rib,iban,balance,idClient,idBanque) VALUES (?,?,?,?,?);";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,compte.getRib());
            preparedStatement.setString(2,compte.getRib());
            preparedStatement.setDouble(3,compte.getBalance());
            preparedStatement.setInt(4,compte.getClient().getId());
            preparedStatement.setInt(5,compte.getBanque().getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public  void update(Compte compte) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "UPDATE compte SET iban=?,balance=? WHERE id=?";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,compte.getRib());
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

    @Override
    public void compteParBanque(int id){

        List<Compte> comptes = findById(id);
        System.out.println(comptes.get(0));

        BanqueImp banqueImp = new BanqueImp();
        Banque banque = banqueImp.findById(comptes.get(0).getBanque().getId());
        System.out.println(banque);
    }


}
