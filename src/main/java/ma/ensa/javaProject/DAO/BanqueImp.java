package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Banque;
import ma.ensa.javaProject.Module.Client;
import ma.ensa.javaProject.Utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BanqueImp implements BanqueDAO{

    @Override
    public List<Banque> findAll() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        List<Banque> banques = new ArrayList<>();
        String Query = "SELECT * FROM banque;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Banque banque = Banque.build().Id(resultSet.getInt("id"))
                        .Nom(resultSet.getString("nom"))
                        .Address(resultSet.getString("address"))
                        .SwiftCode(resultSet.getString("swiftCode"))
                        .build();
                banques.add(banque);
            }
            //return banques;


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return banques;
    }

    @Override
    public Banque findById(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }

        String Query = "SELECT * FROM banque WHERE id=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                 return Banque.build().Id(resultSet.getInt("id"))
                        .Nom(resultSet.getString("nom"))
                        .Address(resultSet.getString("address"))
                        .SwiftCode(resultSet.getString("swiftCode"))
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
    public void save(Banque banque) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "INSERT INTO banque (id,nom,swiftcode,address) VALUES (?,?,?,?);";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setInt(1,banque.getId());
            preparedStatement.setString(2,banque.getNom());
            preparedStatement.setString(3,banque.getAddress());
            preparedStatement.setString(4, banque.getSwiftCode());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close();
        }
    }

    @Override
    public void update(Banque banque) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "UPDATE banque SET nom=?,addresse=?,swiftcode=? WHERE id=?";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            preparedStatement.setString(1,banque.getNom());
            preparedStatement.setString(2,banque.getAddress());
            preparedStatement.setString(3, banque.getSwiftCode());
            preparedStatement.setInt(4,banque.getId());


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
        String Query = "DELETE FROM client WHERE id=?;";
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
