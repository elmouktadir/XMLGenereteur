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
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    dateNaissance DATE,
    email VARCHAR(100) NOT NULL UNIQUE,
    CIN VARCHAR(100) NOT NULL UNIQUE,
    address VARCHAR(100),
    numMobile VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Table Compte
CREATE TABLE compte (
    rib VARCHAR(24) PRIMARY KEY,
    balance DOUBLE(15, 2) NOT NULL DEFAULT 0,
    idClient INT NOT NULL,
    idBanque INT NOT NULL,
    FOREIGN KEY (idClient) REFERENCES client(id),
    FOREIGN KEY (idBanque) REFERENCES banque(id)
);

-- Table Bénéficiaire
CREATE TABLE beneficiaire (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    rib VARCHAR(24), -- RIB si le bénéficiaire a un compte
    FOREIGN KEY (rib) REFERENCES compte(rib)
);

-- Table Virement
CREATE TABLE virement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ribEmetteur VARCHAR(24) NOT NULL,
    idBeneficiaire INT NOT NULL,
    dateVirement DATE NOT NULL,
    montant DOUBLE(15, 2) NOT NULL,
    motif VARCHAR(255),
    FOREIGN KEY (ribEmetteur) REFERENCES compte(rib),
    FOREIGN KEY (idBeneficiaire) REFERENCES beneficiaire(id)
);
