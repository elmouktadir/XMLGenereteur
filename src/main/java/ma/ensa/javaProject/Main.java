package ma.ensa.javaProject;

import ma.ensa.javaProject.Module.XMLTransaction;
import ma.ensa.javaProject.Module.XMLTransactionInter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        XMLTransactionInter xml = new XMLTransaction();
////        //xml.XMLSameBankCountryTran();
//        xml.XMLDeffBankSameCountryTran();
////        xml.XMLDeffBankCountryTran();
//        xml.XMLSameBankDeffCountryTran();
//        xml.XMLMultiTran();
        String Nom = "ID123443";
        String numeroCIN = Nom.substring(2,Nom.length());
        System.out.println(numeroCIN);
        String inverseNom = new StringBuilder(Nom).reverse().toString();
        System.out.println(inverseNom);
    }
}