package ma.ensa.javaProject.Module;

public interface XMLTransactionInter {

    public void XMLSameBankCountryTran();
    public void XMLDeffBankSameCountryTran();
    public void XMLDeffBankCountryTran();
    public void XMLSameBankDeffCountryTran();
    public void XMLMultiTran();

}


/*
* Same Bank and Country ==> SBC
* Deffirent Bank Same Country ==> DBSC
* Deffirent Bank Deffirent Country ==> DBDC
* Same Bank Deffirent Country ==> SBDC
* Virement multiple ==> Multi
* */