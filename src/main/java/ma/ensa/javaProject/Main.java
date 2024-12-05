package ma.ensa.javaProject;

import ma.ensa.javaProject.DAO.*;
import ma.ensa.javaProject.Module.*;
import ma.ensa.javaProject.Utils.EmailSender;

import java.sql.Time;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        XMLTransactionInter xml = new XMLTransaction();
//////        //xml.XMLSameBankCountryTran();
////        xml.XMLDeffBankSameCountryTran();
//////        xml.XMLDeffBankCountryTran();
////        xml.XMLSameBankDeffCountryTran();
////        xml.XMLMultiTran();
////        String Nom = "ID123443";
////        String numeroCIN = Nom.substring(2,Nom.length());
////        System.out.println(numeroCIN);
////        String inverseNom = new StringBuilder(Nom).reverse().toString();
////        System.out.println(inverseNom);
//        xml.XMLMassetran();

//        String phone = "+212666070810";
//        boolean valide = Client.isPhoneNumber(phone);
//        System.out.println(valide);

//        String mail = "elmelssez@gmail.com";
//        EmailSender.emailSender(mail);

        ClientImpl clientimpl = new ClientImpl();
        CompteImpl compteimpl = new CompteImpl();
        BanqueImp banqueimpl = new BanqueImp();
        VirementImpl virImpl = new VirementImpl();
        BeneficiaireImpl beneImpl = new BeneficiaireImpl();

        //Client client = new Client("nom","prenom",new Time(123455),"Maroccain","IE12345"
        //       ,"sidi abbad","+212709882304","email@exemple.com","123456@");
        //clientimpl.save(client);

        //Banque banque = new Banque("banque","BMMACA12","MOROCCO");
        //banqueimpl.save(banque);

        Client client1 = clientimpl.findById("no54321IE");
        //Banque banque1 = banqueimpl.findById(4);

        //Compte compte = new Compte("1234567899876543",1900,client1,banque1);
        //compteimpl.save(compte);

        List<Compte> comptes = compteimpl.findById(client1.getId());
//        clientimpl.afficherCompteByClient(client1.getId());
//        System.out.println("----------------------------------------------------------------------------");
//        compteimpl.compteParBanque(client1.getId());



//        Beneficiaire beneficiaire = new Beneficiaire("234566786544567788","haj","ISHAQ");
//
//        Virement virement = new Virement(Virement.Type.VIRCHAC,new Time(200044854),1000,"3a bghit",comptes.get(0),beneficiaire);
//        virImpl.save(virement);

    }
}