package com.cg.miniproject.dao;

import java.util.List;

import com.cg.miniproject.exception.LAPException;
import com.cg.miniproject.model.Loan;

public interface LapDao {

	int addApplicationDetails(Loan loan) throws LAPException;

	List<Loan> getLoans() throws LAPException;

	List<Loan> getDetails(Loan loan) throws LAPException;

	int addApplicationMapping(Loan loan1) throws LAPException;

}
