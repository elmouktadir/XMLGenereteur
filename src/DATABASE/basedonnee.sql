CREATE DATABASE  IF NOT EXISTS AppBancaire;
USE AppBancaire;

CREATE TABLE beneficiaire(
    numCompte VARCHAR(24) NOT NULL,
    nom VARCHAR(20) NOT NULL,
    prenom VARCHAR(20) NOT NULL
);

CREATE TABLE banque(
    id INT NOT NULL,
    nom VARCHAR(30) NOT NULL,
    swiftCode VARCHAR(8) NOT NULL,
    address VARCHAR(100) NOT NULL
);

CREATE TABLE compte(
    id INT AUTO_INCREMENT,
    rib VARCHAR(24) NOT NULL,
    balance DECIMAL(10,2) NOT NULL
);

CREATE TABLE virement(
    id INT AUTO_INCREMENT,
    type VARCHAR(20) NOT NULL,
    date Date NOT NULL,
    amount DECIMAL(5,2) NOT NULL,
    motif VARCHAR(50) NOT NULL
);

   private String Nom ;
    private String Prenom ;
    private DATE dateNaissance;
    private String Nationalite ;
    private  String CIN; // final ?
    private String Addresse;
    private String NumMobile;
    private String email;
    private String password;
    private  String IdUtilisateur;

CREATE TABLE client(
    numCompte VARCHAR(24) NOT NULL,
    nom VARCHAR(20) NOT NULL,
    prenom VARCHAR(20) NOT NULL,
    dateNaissance DATE,
    nationalite VARCHAR(10) NOT NULL,
    CIN VARCHAR(10) NOT NULL,
    address VARCHAR(10) NOT NULL,
    numMobile VARCHAR(10) NOT NULL,
    email VARCHAR(10) NOT NULL,
    password VARCHAR(10) NOT NULL,
    idUtilisateur VARCHAR(10) NOT NULL,
);