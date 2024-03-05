#------------------------------------------------------------
# Table: Categorie
#------------------------------------------------------------

CREATE TABLE Categorie(
        idCategorie Int  Auto_increment  NOT NULL ,
        Nom         Varchar (100) NOT NULL
	,CONSTRAINT Categorie_PK PRIMARY KEY (idCategorie)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TypeRessource
#------------------------------------------------------------

CREATE TABLE TypeRessource(
        idType Int  Auto_increment  NOT NULL ,
        Nom    Varchar (100) NOT NULL
	,CONSTRAINT TypeRessource_PK PRIMARY KEY (idType)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Role
#------------------------------------------------------------

CREATE TABLE Role(
        idRole   Int  Auto_increment  NOT NULL ,
        typeRole Varchar (100) NOT NULL
	,CONSTRAINT Role_PK PRIMARY KEY (idRole)
)ENGINE=InnoDB;