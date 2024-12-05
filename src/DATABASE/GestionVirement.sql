CREATE DATABASE IF NOT EXISTS GestionVirement;

USE GestionVirement;

-- Table Banque
CREATE TABLE banque (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    swiftCode VARCHAR(11) NOT NULL UNIQUE,
    address VARCHAR(100) NOT NULL
);


-- Table Client
CREATE TABLE client (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idUtilisateur VARCHAR(60) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    dateNaissance DATE,
    nationalite VARCHAR(20),
    CIN VARCHAR(100) NOT NULL UNIQUE,
    address VARCHAR(100),
    numMobile VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Table Compte
CREATE TABLE compte (
    rib VARCHAR(24) PRIMARY KEY,
    swiftCode VARCHAR(20) NOT NULL,
    balance DOUBLE(15, 2) NOT NULL DEFAULT 0,
    idClient INT NOT NULL,
    idBanque INT NOT NULL,
    FOREIGN KEY (idClient) REFERENCES client(id),
    FOREIGN KEY (idBanque) REFERENCES banque(id)
);

-- Table Bénéficiaire
CREATE TABLE beneficiaire (
    id INT AUTO_INCREMENT PRIMARY KEY,
    iban VARCHAR(28) NOt NULL,
    BIC VARCHAR(28) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    idCompte INT NOT NULL, -- RIB si le bénéficiaire a un compte
    FOREIGN KEY (id) REFERENCES compte(idCompte)
);

-- Table Virement
CREATE TABLE virement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(14) NOT NULL,
    ribEmetteur VARCHAR(24) NOT NULL,
    idBeneficiaire INT NOT NULL,
    dateVirement DATE NOT NULL,
    montant DOUBLE(15, 2) NOT NULL,
    motif VARCHAR(255),
    FOREIGN KEY (ribEmetteur) REFERENCES compte(rib),
    FOREIGN KEY (idBeneficiaire) REFERENCES beneficiaire(id)
);
