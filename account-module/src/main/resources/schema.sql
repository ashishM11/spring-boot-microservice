DROP TABLE IF EXISTS tblAccount;
CREATE TABLE IF NOT EXISTS tblAccount(
	accountId bigint not null auto_increment,
    custId bigint not null,
    accountNo VARCHAR(11) NOT NULL DEFAULT '0',
    accountType varchar(11) not null,
    accountBalance DECIMAL NOT NULL DEFAULT 0.0,
    accountCreationDT datetime not null default current_timestamp,
    primary key(accountId,accountNo,custId,accountType)
);