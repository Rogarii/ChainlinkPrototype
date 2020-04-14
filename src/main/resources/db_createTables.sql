DROP TABLE UserInbox;
DROP TABLE ContractProperties;
DROP TABLE ContractAccounts;
DROP TABLE IntelProperties;
DROP TABLE Accounts;
DROP TABLE Contracts;
DROP TABLE UserGroups;
DROP TABLE EnterpriseAffiliates;
DROP TABLE UserAuthority;
DROP TABLE Users;

CREATE TABLE Users (
	ID int IDENTITY(1,1) PRIMARY KEY,
	FirstName varchar(20) NOT NULL,
	LastName varchar(20) NOT NULL,
	EmailAddress varchar(300) NOT NULL UNIQUE,
	PasswordHash varchar(300) NOT NULL,
	WalletKey varchar(300) NOT NULL
);

INSERT INTO Users(FirstName, LastName, EmailAddress, PasswordHash, WalletKey)
VALUES('Raymond','Metz','KarlMetz926@gmail.com','$2a$10$rXh/DKB.W7jFp0PddtHpMeCw9kWwdhMJVjRyykKHdIu/q9UXSGIP6','0x00c79bd49a2a10d390a85493dc6e85270e14b3ce73ad2959a764b03e11b3e55211');

CREATE TABLE UserAuthority (
	ID int IDENTITY(1,1) PRIMARY KEY,
	UserID int FOREIGN KEY REFERENCES Users(ID),
	RoleAuth varchar(10) NOT NULL
);

INSERT INTO UserAuthority(UserID, RoleAuth)
VALUES(1, 'ROLE_USER');

CREATE TABLE EnterpriseAffiliates (
	ID int IDENTITY(1,1) PRIMARY KEY,
	BusinessTitle varchar(50),
	DateCreated datetime,
	BusinessInfoPH1 varchar(100),
	BusinessInfoPH2 varchar(100),
	BusinessInfoPH3 varchar(100),
	BusinessInfoPH4 varchar(100)
);

INSERT INTO EnterpriseAffiliates(BusinessTitle, DateCreated)
VALUES(null, null);

CREATE TABLE UserGroups (
	ID int IDENTITY(1,1) PRIMARY KEY,
	GroupTitle varchar(50),
	DateCreated datetime
);

INSERT INTO UserGroups(GroupTitle, DateCreated)
VALUES(null, null);

CREATE TABLE Contracts (
	ID int IDENTITY(1,1) PRIMARY KEY,
	ContractType varchar(5) NOT NULL,
	DateCreated datetime NOT NULL,
	DateModified datetime NOT NULL,
	BCKey varchar(100),
	Deployed bit
);

CREATE TABLE Accounts(
	ID int IDENTITY(1,1) PRIMARY KEY,
	UserID int FOREIGN KEY REFERENCES Users(ID),
	GroupID int FOREIGN KEY REFERENCES UserGroups(ID),
	EnterpriseID int FOREIGN KEY REFERENCES EnterpriseAffiliates(ID),
	AccountTitle varchar(20),
	AccountType varchar(5) NOT NULL,
	SubType varchar(5),
	SubStatus bit,
	Citizenship varchar(30) NOT NULL,
	Country varchar(30) NOT NULL,
	Address1 varchar(100) NOT NULL,
	Address2 varchar(100),
	City varchar(50) NOT NULL,
	StateAd varchar(2) NOT NULL,
	Zip int NOT NULL,
	PrimaryPhone decimal(10,0) NOT NULL,
	CellPhone decimal(10,0),
	Fax decimal(10,0)
);

CREATE TABLE IntelProperties(
	ID int IDENTITY(1,1) PRIMARY KEY,
	AccountID int FOREIGN KEY REFERENCES Accounts(ID),
	PropName varchar(50) NOT NULL,
	DateAdded datetime NOT NULL,
	DateModified datetime NOT NULL,
	LyricsData varbinary(max),
	CompData varbinary(max),
	Meta_Song varchar(100),
	Meta_Artist varchar(100),
	Meta_Album varchar(100),
	Meta_AlbumArtist varchar(100),
	Meta_Composer varchar(100),
	Meta_Grouping varchar(100),
	Meta_Genre varchar(100),
	Meta_Year int,
	Meta_Bpm int,
	Meta_AlbumArt varbinary(max)
);

CREATE TABLE ContractAccounts(
	ID int IDENTITY(1,1) PRIMARY KEY,
	ContractID int FOREIGN KEY REFERENCES Contracts(ID),
	AccountID int FOREIGN KEY REFERENCES Accounts(ID),
);

CREATE TABLE ContractProperties(
	ID int IDENTITY(1,1) PRIMARY KEY,
	ContractID int FOREIGN KEY REFERENCES Contracts(ID),
	PropertyID int FOREIGN KEY REFERENCES IntelProperties(ID)
);

CREATE TABLE UserInbox(
	ID int IDENTITY(1,1) PRIMARY KEY,
	UserID int FOREIGN KEY REFERENCES Users(ID),
	ContractID int FOREIGN KEY REFERENCES Contracts(ID),
	SentBy VARCHAR(300) NOT NULL,
	SentTime DATETIME NOT NULL
);