package com.cg.miniproject.dao;

public interface QueryMapper {
	public static final String insertLoanPrograms = "insert into loanprogramsoffered values(?,?,?,?,?,?,?,?)";
	public static final String insertApplicationPrograms = "insert into loanapplication values(?,?,?,?,?,?,?,?)";
	public static final String getApplicationId = "select application_seq.CURRVAL from dual";
	public static final String getLoans = "select *from loanprogramsoffered";
	public static final String getDetails = "select Status from LoanApplication where Application_id=?";
}
