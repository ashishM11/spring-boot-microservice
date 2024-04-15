DROP TABLE IF EXISTS tblLoan;

CREATE TABLE IF NOT EXISTS tblLoan(
    loanId  bigint not null primary key auto_increment,
    loanAccountNo VARCHAR(11) NOT NULL unique,
    loanStartDate DATE NOT NULL,
    loanEndDate DATE NOT NULL,
    loanTenureInMonths int NOT NULL,
    loanTypeId BIGINT NOT NULL,
    loanRateOfInterest double NOT NULL,
    loanCreationDT DATETIME default current_timestamp NOT NULL,
    loanAmount DOUBLE NOT NULL,
    loanPendingAmount DOUBLE NOT NULL,
    custId bigint not null
);

DROP TABLE IF EXISTS tblLoanType;
CREATE TABLE IF NOT EXISTS tblLoanType(
	loanTypeId bigint not null primary key auto_increment,
    loanType VARCHAR(3) NOT NULL UNIQUE,
    loanTypeDesc VARCHAR(20) NOT NULL
);