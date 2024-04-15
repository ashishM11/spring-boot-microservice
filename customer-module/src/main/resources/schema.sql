DROP TABLE IF EXISTS tblBranch;

CREATE TABLE IF NOT EXISTS tblBranch(
	branchId bigint not null primary key auto_increment,
    branchCode varchar(10) not null unique,
    branchAddress text not null,
    branchCreationDT datetime default current_timestamp
);

DROP TABLE IF EXISTS tblCustomer;
CREATE TABLE IF NOT EXISTS tblCustomer(
	custId bigint not null primary key auto_increment,
    custFname varchar(30) not null,
    custLname varchar(30) not null,
    custEmail varchar(50) not null unique,
    custMobile varchar(10) not null unique,
    custGender varchar(1) not null,
    branchId bigint not null,
    custCreationDT datetime not null default current_timestamp,
    constraint fk_branch foreign key(branchId) references tblBranch(branchId)
);