package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Virement;
import ma.ensa.javaProject.Utils.Utils;

import java.net.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class VirementImpl implements VirementDAO{
    @Override
    public List<Virement> findAll() {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        List<Virement> virements = new ArrayList<>();
        String Query = "SELECT * FROM virement;";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Virement virement = Virement.build()
                        .Id(resultSet.getInt("id"))
                        .VirementType(Virement.Type.valueOf(resultSet.getString("type").toUpperCase()))
                        .Date(resultSet.getDate("date"))
                        .Amount(resultSet.getDouble("amount"))
                        .Motif(resultSet.getString("motif"))
                        .build();
                virements.add(virement);
            }

        }catch (SQLException se){

            se.printStackTrace();

        }finally {

            DBConnection.close();

        }
        return virements;
    }

    @Override
    public Virement findById(int id) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }

        String Query = "SELECT * FROM virement WERE id=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return Virement.build()
                        .Id(resultSet.getInt("id"))
                        .VirementType(Virement.Type.valueOf(resultSet.getString("type").toUpperCase()))
                        .Date(resultSet.getDate("date"))
                        .Amount(resultSet.getDouble("amount"))
                        .Motif(resultSet.getString("motif"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void delete(int id) {

        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return;
        }

        String Query = "DELETE FROM virement WHERE id=?;";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query) ){

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBConnection.close();
        }

    }

    @Override
    public void save(Virement virement) {

        Connection conn = DBConnection.getConnection();
        if (conn == null){
            return;
        }

        String Query = "INSERT INTO virement (id,type,amount,date,motif) VALUES (?,?,?,?,?);";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setInt(1,virement.getId());
            preparedStatement.setString(2,virement.getType().toString());
            preparedStatement.setDouble(3,virement.getAmount());
            preparedStatement.setDate(4,Utils.getSqlDate(virement.getDate()));
            preparedStatement.setString(5,virement.getMotif());
        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            DBConnection.close();
        }
    }

    @Override
    public void update(Virement virement) {
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return;
        }
        String Query = "UPDATE virement SET type=?,date=?,amount=?,motif=? where id=?;";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,virement.getType().toString());
            preparedStatement.setDouble(2,virement.getAmount());
            preparedStatement.setDate(3,Utils.getSqlDate(virement.getDate()));
            preparedStatement.setString(4,virement.getMotif());
            preparedStatement.setInt(5,virement.getId());
        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            DBConnection.close();
        }
    }
}
