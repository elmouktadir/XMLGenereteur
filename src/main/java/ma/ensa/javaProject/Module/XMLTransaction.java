package ma.ensa.javaProject.Module;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class XMLTransaction implements XMLTransactionInter{
    @Override
    public void XMLSameBankCountryTran() {
        try{

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //Creer l'element racine
            Element root = document.createElementNS("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02","Document");
            document.appendChild(root);

            // Ajouter FIToFICstmrCdtTrf
            Element FIToFICstmrCdtTrf = document.createElement("FIToFICstmrCdtTrf");
            root.appendChild(FIToFICstmrCdtTrf);

            // Ajouter GrpHdr
            Element GrpHdr = document.createElement("GrpHdr");
            FIToFICstmrCdtTrf.appendChild(GrpHdr);

            // ajouter MsgId dans GrpHdr
            Element MsgId = document.createElement("MsgId");
            MsgId.appendChild(document.createTextNode("INT001"));
            GrpHdr.appendChild(MsgId);

            // ajouter MsgId dans GrpHdr
            Element CreDtTm = document.createElement("CreDtTm");
            //la date et le temps de creation
            CreDtTm.appendChild(document.createTextNode("2024-11-07T10:15:00"));
            GrpHdr.appendChild(CreDtTm);

            // ajouter MsgId dans GrpHdr
            Element NbOfTxs = document.createElement("NbOfTxs");
            // le nombre des benefits
            NbOfTxs.appendChild(document.createTextNode("1"));
            GrpHdr.appendChild(NbOfTxs);

            // creer l'element CdtTrfTxInf dans FIToFICstmrCdtTrf
            Element CdtTrfTxInf = document.createElement("CdtTrfTxInf");
            FIToFICstmrCdtTrf.appendChild(CdtTrfTxInf);

            // creer l'element PmtId
            Element PmtId = document.createElement(("PmtId"));
            CdtTrfTxInf.appendChild(PmtId);

            // creer element InstrId
            Element InstrId = document.createElement("InstrId");
            InstrId.appendChild(document.createTextNode("INT20241107001"));
            PmtId.appendChild(InstrId);

            // creer element EndToEndId
            Element EndToEndId = document.createElement("EndToEndId");
            EndToEndId.appendChild(document.createTextNode("E2EINT001"));
            PmtId.appendChild(EndToEndId);

            //creer element Amt dans la  balise CdtTrfTxInf
            Element Amt = document.createElement("Amt");
            CdtTrfTxInf.appendChild(Amt);

            //creer element InstdAmt avec les attributs Ccy et MAD dans la  balise Amt
            Element InstdAmt = document.createElement("InstdAmt");
            InstdAmt.setAttribute("Ccy","MAD");
            InstdAmt.appendChild(document.createTextNode("1000"));
            Amt.appendChild(InstdAmt);

            // creer element CdtrAcct dans la balise CdtTrfTxInf
            Element CdtrAcct = document.createElement("CdtrAcct");
            CdtTrfTxInf.appendChild(CdtrAcct);

            // creer element Id dans la balise CdtrAcct
            Element CdtrAcctId  = document.createElement("Id");
            CdtrAcct.appendChild(CdtrAcctId);

            // creer element IBAN dans la balise Id
            Element CdtrIBAN  = document.createElement("IBAN");
            CdtrIBAN .appendChild(document.createTextNode("MA6400000000000000000000000"));
            CdtrAcctId.appendChild(CdtrIBAN);

            // creer element DbtrAcct dans la balise CdtTrfTxInf
            Element DbtrAcct = document.createElement("DbtrAcct");
            CdtTrfTxInf.appendChild(DbtrAcct);

            // creer element Id dans la balise DbtrAcct
            Element DbtrAcctId  = document.createElement("Id");
            DbtrAcct.appendChild(DbtrAcctId);

            // creer element IBAN dans la balise Id
            Element DbtrIBAN  = document.createElement("IBAN");
            DbtrIBAN .appendChild(document.createTextNode("MA6400000000000000000000000"));
            DbtrAcctId.appendChild(DbtrIBAN );

            // Transformer le document DOM en un fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("transaction_SBC.xml"));

            transformer.transform(domSource,streamResult);

            System.out.println("le fichier XML générer par succes.");


        } catch (ParserConfigurationException | TransformerException e){
            e.printStackTrace();
        }

    }

    @Override
    public void XMLDeffBankSameCountryTran() {
        try{

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //Creer l'element racine
            Element root = document.createElementNS("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02","Document");
            document.appendChild(root);

            // Ajouter FIToFICstmrCdtTrf
            Element FIToFICstmrCdtTrf = document.createElement("FIToFICstmrCdtTrf");
            root.appendChild(FIToFICstmrCdtTrf);

            // Ajouter GrpHdr
            Element GrpHdr = document.createElement("GrpHdr");
            FIToFICstmrCdtTrf.appendChild(GrpHdr);

            // ajouter MsgId dans GrpHdr
            Element MsgId = document.createElement("MsgId");
            MsgId.appendChild(document.createTextNode("INT001"));
            GrpHdr.appendChild(MsgId);

            // ajouter MsgId dans GrpHdr
            Element CreDtTm = document.createElement("CreDtTm");
            //la date et le temps de creation
            CreDtTm.appendChild(document.createTextNode("2024-11-07T11:00:00"));
            GrpHdr.appendChild(CreDtTm);

            // ajouter MsgId dans GrpHdr
            Element NbOfTxs = document.createElement("NbOfTxs");
            // le nombre des benefits
            NbOfTxs.appendChild(document.createTextNode("1"));
            GrpHdr.appendChild(NbOfTxs);

            // creer l'element CdtTrfTxInf dans FIToFICstmrCdtTrf
            Element CdtTrfTxInf = document.createElement("CdtTrfTxInf");
            FIToFICstmrCdtTrf.appendChild(CdtTrfTxInf);

            // creer l'element PmtId
            Element PmtId = document.createElement(("PmtId"));
            CdtTrfTxInf.appendChild(PmtId);

            // creer element InstrId
            Element InstrId = document.createElement("InstrId");
            InstrId.appendChild(document.createTextNode("DOM20241107001"));
            PmtId.appendChild(InstrId);

            // creer element EndToEndId
            Element EndToEndId = document.createElement("EndToEndId");
            EndToEndId.appendChild(document.createTextNode("E2EDOM001"));
            PmtId.appendChild(EndToEndId);

            //creer element Amt dans la  balise CdtTrfTxInf
            Element Amt = document.createElement("Amt");
            CdtTrfTxInf.appendChild(Amt);

            //creer element InstdAmt avec les attributs Ccy et MAD dans la  balise Amt
            Element InstdAmt = document.createElement("InstdAmt");
            InstdAmt.setAttribute("Ccy","MAD");
            InstdAmt.appendChild(document.createTextNode("5000"));
            Amt.appendChild(InstdAmt);


            // creer element DbtrAgt dans CdtTrfTxInf
            Element CdtrAgt = document.createElement("CdtrAgt");
            CdtTrfTxInf.appendChild(CdtrAgt);

            // creer element FinInstnId  dans DbtrAgt
            Element CdtrFinInstnId = document.createElement("FinInstnId");
            CdtrAgt.appendChild(CdtrFinInstnId);

            // creer element BIC dans FinInstnId
            Element CdtrBIC = document.createElement("BIC");
            CdtrBIC.appendChild(document.createTextNode("BNKINMAMXXX"));
            CdtrFinInstnId.appendChild(CdtrBIC);

            // creer element CdtrAcct dans la balise CdtTrfTxInf
            Element CdtrAcct = document.createElement("CdtrAcct");
            CdtTrfTxInf.appendChild(CdtrAcct);

            // creer element Id dans la balise CdtrAcct
            Element CdtrAcctId  = document.createElement("Id");
            CdtrAcct.appendChild(CdtrAcctId);

            // creer element IBAN dans la balise Id
            Element CdtrIBAN  = document.createElement("IBAN");
            CdtrIBAN .appendChild(document.createTextNode("MA6500000000000000000000000"));
            CdtrAcctId.appendChild(CdtrIBAN);

            // creer element DbtrAgt dans CdtTrfTxInf
            Element DbtrAgt = document.createElement("DbtrAgt");
            CdtTrfTxInf.appendChild(DbtrAgt);

            // creer element FinInstnId  dans DbtrAgt
            Element FinInstnId = document.createElement("FinInstnId");
            DbtrAgt.appendChild(FinInstnId);

            // creer element BIC dans FinInstnId
            Element BIC = document.createElement("BIC");
            BIC.appendChild(document.createTextNode("BNKINMCMXXX"));
            FinInstnId.appendChild(BIC);

            // creer element DbtrAcct dans la balise CdtTrfTxInf
            Element DbtrAcct = document.createElement("DbtrAcct");
            CdtTrfTxInf.appendChild(DbtrAcct);

            // creer element Id dans la balise DbtrAcct
            Element DbtrAcctId  = document.createElement("Id");
            DbtrAcct.appendChild(DbtrAcctId);

            // creer element IBAN dans la balise Id
            Element DbtrIBAN  = document.createElement("IBAN");
            DbtrIBAN .appendChild(document.createTextNode("MA6600000000000000000000001"));
            DbtrAcctId.appendChild(DbtrIBAN );

            // Transformer le document DOM en un fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("transaction_DBSC.xml"));

            transformer.transform(domSource,streamResult);

            System.out.println("le fichier XML générer par succes.");


        } catch (ParserConfigurationException | TransformerException e){
            e.printStackTrace();
        }
    }

    @Override
    public void XMLDeffBankCountryTran() {

        try{

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //Creer l'element racine
            Element root = document.createElementNS("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02","Document");
            document.appendChild(root);

            // Ajouter FIToFICstmrCdtTrf
            Element FIToFICstmrCdtTrf = document.createElement("FIToFICstmrCdtTrf");
            root.appendChild(FIToFICstmrCdtTrf);

            // Ajouter GrpHdr
            Element GrpHdr = document.createElement("GrpHdr");
            FIToFICstmrCdtTrf.appendChild(GrpHdr);

            // ajouter MsgId dans GrpHdr
            Element MsgId = document.createElement("MsgId");
            MsgId.appendChild(document.createTextNode("INTL001"));
            GrpHdr.appendChild(MsgId);

            // ajouter MsgId dans GrpHdr
            Element CreDtTm = document.createElement("CreDtTm");
            //la date et le temps de creation
            CreDtTm.appendChild(document.createTextNode("2024-11-07T12:00:00"));
            GrpHdr.appendChild(CreDtTm);

            // ajouter MsgId dans GrpHdr
            Element NbOfTxs = document.createElement("NbOfTxs");
            // le nombre des benefits
            NbOfTxs.appendChild(document.createTextNode("1"));
            GrpHdr.appendChild(NbOfTxs);

            // creer l'element CdtTrfTxInf dans FIToFICstmrCdtTrf
            Element CdtTrfTxInf = document.createElement("CdtTrfTxInf");
            FIToFICstmrCdtTrf.appendChild(CdtTrfTxInf);

            // creer l'element PmtId
            Element PmtId = document.createElement(("PmtId"));
            CdtTrfTxInf.appendChild(PmtId);

            // creer element InstrId
            Element InstrId = document.createElement("InstrId");
            InstrId.appendChild(document.createTextNode("INTL20241107001"));
            PmtId.appendChild(InstrId);

            // creer element EndToEndId
            Element EndToEndId = document.createElement("EndToEndId");
            EndToEndId.appendChild(document.createTextNode("E2EINTL001"));
            PmtId.appendChild(EndToEndId);

            //creer element Amt dans la  balise CdtTrfTxInf
            Element Amt = document.createElement("Amt");
            CdtTrfTxInf.appendChild(Amt);

            //creer element InstdAmt avec les attributs Ccy et MAD dans la  balise Amt
            Element InstdAmt = document.createElement("InstdAmt");
            InstdAmt.setAttribute("Ccy","USD");
            InstdAmt.appendChild(document.createTextNode("1500"));
            Amt.appendChild(InstdAmt);


            // creer element DbtrAgt dans CdtTrfTxInf
            Element CdtrAgt = document.createElement("CdtrAgt");
            CdtTrfTxInf.appendChild(CdtrAgt);

            // creer element FinInstnId  dans DbtrAgt
            Element CdtrFinInstnId = document.createElement("FinInstnId");
            CdtrAgt.appendChild(CdtrFinInstnId);

            // creer element BIC dans FinInstnId
            Element CdtrBIC = document.createElement("BIC");
            CdtrBIC.appendChild(document.createTextNode("BNKINUSXXXXX"));
            CdtrFinInstnId.appendChild(CdtrBIC);

            // creer element CdtrAcct dans la balise CdtTrfTxInf
            Element CdtrAcct = document.createElement("CdtrAcct");
            CdtTrfTxInf.appendChild(CdtrAcct);

            // creer element Id dans la balise CdtrAcct
            Element CdtrAcctId  = document.createElement("Id");
            CdtrAcct.appendChild(CdtrAcctId);

            // creer element IBAN dans la balise Id
            Element CdtrIBAN  = document.createElement("IBAN");
            CdtrIBAN .appendChild(document.createTextNode("US000000000000000000000"));
            CdtrAcctId.appendChild(CdtrIBAN);

            // creer element DbtrAgt dans CdtTrfTxInf
            Element DbtrAgt = document.createElement("DbtrAgt");
            CdtTrfTxInf.appendChild(DbtrAgt);

            // creer element FinInstnId  dans DbtrAgt
            Element FinInstnId = document.createElement("FinInstnId");
            DbtrAgt.appendChild(FinInstnId);

            // creer element BIC dans FinInstnId
            Element BIC = document.createElement("BIC");
            BIC.appendChild(document.createTextNode("BNKINFRXXXX"));
            FinInstnId.appendChild(BIC);

            // creer element DbtrAcct dans la balise CdtTrfTxInf
            Element DbtrAcct = document.createElement("DbtrAcct");
            CdtTrfTxInf.appendChild(DbtrAcct);

            // creer element Id dans la balise DbtrAcct
            Element DbtrAcctId  = document.createElement("Id");
            DbtrAcct.appendChild(DbtrAcctId);

            // creer element IBAN dans la balise Id
            Element DbtrIBAN  = document.createElement("IBAN");
            DbtrIBAN .appendChild(document.createTextNode("FR000000000000000000000"));
            DbtrAcctId.appendChild(DbtrIBAN );

            // creer element XchgRate dans CdtTrfTxInf
            //Taux de change si applicable
            Element XchgRate = document.createElement("XchgRate");
            XchgRate.appendChild(document.createTextNode("1.12"));
            CdtTrfTxInf.appendChild(XchgRate);

            // Transformer le document DOM en un fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("transaction_DBDC.xml"));

            transformer.transform(domSource,streamResult);

            System.out.println("le fichier XML générer par succes.");


        } catch (ParserConfigurationException | TransformerException e){
            e.printStackTrace();
        }

    }

    @Override
    public void XMLSameBankDeffCountryTran() {

        try{

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            //Creer l'element racine
            Element root = document.createElementNS("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.02","Document");
            document.appendChild(root);

            // Ajouter FIToFICstmrCdtTrf
            Element FIToFICstmrCdtTrf = document.createElement("FIToFICstmrCdtTrf");
            root.appendChild(FIToFICstmrCdtTrf);

            // Ajouter GrpHdr
            Element GrpHdr = document.createElement("GrpHdr");
            FIToFICstmrCdtTrf.appendChild(GrpHdr);

            // ajouter MsgId dans GrpHdr
            Element MsgId = document.createElement("MsgId");
            MsgId.appendChild(document.createTextNode("INTBANK001"));
            GrpHdr.appendChild(MsgId);

            // ajouter MsgId dans GrpHdr
            Element CreDtTm = document.createElement("CreDtTm");
            //la date et le temps de creation
            CreDtTm.appendChild(document.createTextNode("2024-11-07T14:00:00"));
            GrpHdr.appendChild(CreDtTm);

            // ajouter MsgId dans GrpHdr
            Element NbOfTxs = document.createElement("NbOfTxs");
            // le nombre des benefits
            NbOfTxs.appendChild(document.createTextNode("1"));
            GrpHdr.appendChild(NbOfTxs);

            // creer l'element CdtTrfTxInf dans FIToFICstmrCdtTrf
            Element CdtTrfTxInf = document.createElement("CdtTrfTxInf");
            FIToFICstmrCdtTrf.appendChild(CdtTrfTxInf);

            // creer l'element PmtId
            Element PmtId = document.createElement(("PmtId"));
            CdtTrfTxInf.appendChild(PmtId);

            // creer element InstrId
            Element InstrId = document.createElement("InstrId");
            InstrId.appendChild(document.createTextNode("INTBANK20241107"));
            PmtId.appendChild(InstrId);

            // creer element EndToEndId
            Element EndToEndId = document.createElement("EndToEndId");
            EndToEndId.appendChild(document.createTextNode("E2EINTBANK001"));
            PmtId.appendChild(EndToEndId);

            //creer element Amt dans la  balise CdtTrfTxInf
            Element Amt = document.createElement("Amt");
            CdtTrfTxInf.appendChild(Amt);

            //creer element InstdAmt avec les attributs Ccy et MAD dans la  balise Amt
            Element InstdAmt = document.createElement("InstdAmt");
            InstdAmt.setAttribute("Ccy","USD");
            InstdAmt.appendChild(document.createTextNode("2000"));
            Amt.appendChild(InstdAmt);



            // creer element CdtrAcct dans la balise CdtTrfTxInf
            Element CdtrAcct = document.createElement("CdtrAcct");
            CdtTrfTxInf.appendChild(CdtrAcct);

            // creer element Id dans la balise CdtrAcct
            Element CdtrAcctId  = document.createElement("Id");
            CdtrAcct.appendChild(CdtrAcctId);

            // creer element IBAN dans la balise Id
            Element CdtrIBAN  = document.createElement("IBAN");
            CdtrIBAN .appendChild(document.createTextNode("US000000000000000000001"));
            CdtrAcctId.appendChild(CdtrIBAN);



            // creer element DbtrAcct dans la balise CdtTrfTxInf
            Element DbtrAcct = document.createElement("DbtrAcct");
            CdtTrfTxInf.appendChild(DbtrAcct);

            // creer element Id dans la balise DbtrAcct
            Element DbtrAcctId  = document.createElement("Id");
            DbtrAcct.appendChild(DbtrAcctId);

            // creer element IBAN dans la balise Id
            Element DbtrIBAN  = document.createElement("IBAN");
            DbtrIBAN .appendChild(document.createTextNode("FR000000000000000000001"));
            DbtrAcctId.appendChild(DbtrIBAN );

            // creer element XchgRate dans CdtTrfTxInf
            //Taux de change si applicable
            Element XchgRate = document.createElement("XchgRate");
            XchgRate.appendChild(document.createTextNode("1.10"));
            CdtTrfTxInf.appendChild(XchgRate);

            // Transformer le document DOM en un fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("transaction_DBSC.xml"));

            transformer.transform(domSource,streamResult);

            System.out.println("le fichier XML générer par succes.");


        } catch (ParserConfigurationException | TransformerException e){
            e.printStackTrace();
        }

    }

    @Override
    public void XMLMultiTran() {

    }
}
