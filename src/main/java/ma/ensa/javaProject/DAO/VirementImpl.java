package ma.ensa.javaProject.DAO;

import ma.ensa.javaProject.Module.Compte;
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
    public List<Virement> findByRib(String rib){
        Connection conn = DBConnection.getConnection();
        if (conn == null) {
            return null;
        }
        List<Virement> virements = new ArrayList<>();
        String Query = "SELECT * FROM virement WERE ribCompte=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,rib);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Virement virement =  Virement.build()
                        .Id(resultSet.getInt("id"))
                        .VirementType(Virement.Type.valueOf(resultSet.getString("type").toUpperCase()))
                        .Date(resultSet.getDate("date"))
                        .Amount(resultSet.getDouble("amount"))
                        .Motif(resultSet.getString("motif"))
                        .build();
                virements.add(virement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return virements;
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

        String Query = "INSERT INTO virement (type,ribEmetteur,idBeneficiaire,dateVirement,montant,motif) VALUES (?,?,?,?,?,?);";
        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,virement.getType().toString());
            preparedStatement.setString(2,virement.getEmetteur().getRib());
            preparedStatement.setInt(3,virement.getDestinataire().getId());
            preparedStatement.setDouble(4,virement.getAmount());
            preparedStatement.setDate(5,Utils.getSqlDate(virement.getDate()));
            preparedStatement.setString(6,virement.getMotif());
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
        String Query = "UPDATE virement SET type=?,ribEmetteur=?,idBeneficiaire=?,dateVirement=?,montant=?,motif=? where id=?;";

        try(PreparedStatement preparedStatement = conn.prepareStatement(Query)){
            preparedStatement.setString(1,virement.getType().toString());
            preparedStatement.setString(2,virement.getEmetteur().getRib());
            preparedStatement.setInt(3,virement.getDestinataire().getId());
            preparedStatement.setDouble(4,virement.getAmount());
            preparedStatement.setDate(5,Utils.getSqlDate(virement.getDate()));
            preparedStatement.setString(6,virement.getMotif());
        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            DBConnection.close();
        }
    }

    @Override
    public void virementCompte(){

        CompteImpl compteImpl = new CompteImpl();
        List<Compte> comptes = compteImpl.findById(6);

        System.out.println(comptes.get(0));
        List<Virement> virements = findByRib(comptes.get(0).getRib());
        for (int i = 0; i < virements.size(); i++) {

            System.out.println(virements.get(i));
            System.out.println(virements.get(i).getDestinataire());

        }

    }
}
