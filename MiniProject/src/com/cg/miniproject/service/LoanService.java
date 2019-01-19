package com.cg.miniproject.service;

import java.util.List;

import com.cg.miniproject.exception.LAPException;
import com.cg.miniproject.model.Loan;

public interface LoanService {

	boolean validateFields(Loan loan1) throws LAPException;

	int addApplicationDetails(Loan loan) throws LAPException;

	List<Loan> getLoans() throws LAPException;

	List<Loan> getDetails(Loan loan)throws LAPException;

	int addApplicationMapping(Loan loan1) throws LAPException;

	boolean validateParamaters(Loan loan) throws LAPException;

}
