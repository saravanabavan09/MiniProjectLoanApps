package com.cg.miniproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.miniproject.dao.LapDao;
import com.cg.miniproject.dao.LapDaoImpl;
import com.cg.miniproject.exception.LAPException;
import com.cg.miniproject.model.Loan;

public class LoanServiceImpl implements LoanService {
	List<String> list = new ArrayList<>();
	LapDao lapDao = new LapDaoImpl();

	@Override
	public boolean validateFields(Loan loan1) throws LAPException {
		boolean validateFlag = false;
		if (!checkLoanProgram(loan1.getLoanProgram())) {
			list.add("The input should be maximum of 10 letters only \n");
		}

		if (!checkAmountOfLoan(loan1.getAmountOfLoan())) {
			list.add("Should be a valid digit");
		}
		if (!checkAddressOfProperty(loan1.getAddressOfProperty())) {
			list.add("Should be maximum of 30 letters \n");
		}
		if (!checkAnnualFamilyIncome(loan1.getAnnualFamilyIncome())) {
			list.add("Should be a valid digits");
		}
		if (!checkDocumentsProofsAvailable(loan1.getDocumentsProofAvailable())) {
			list.add("Should contains maximum of 50 letters");
		}
		if (!checkGuaranteeCover(loan1.getGuaranteeCover())) {
			list.add("Should contains maximum of 20 letters");
		}
		if (!checkMarketValueofGuarantee(loan1.getMarketValueOfGuaranteeCover())) {
			list.add("Should be a valid digit");
		}

		if (!checkstatus(loan1.getStatus())) {
			list.add("Should contain a maximum of 10 letters");
		}

		if (!list.isEmpty()) {
			list.add("List is Not Empty");

		} else {
			validateFlag = true;
		}
		// TODO Auto-generated method stub
		return validateFlag;
	}

	private boolean checkLoanProgram(String loanProgram) {
		String LoanProgramRegEx = " [A-Za-z0-9]*$";
		return Pattern.matches(LoanProgramRegEx, loanProgram);
	}
	private boolean checkAmountOfLoan(double amountOfLoan) {
		String AmountOfLoanRegEx = " [0-9]*$";
		return Pattern.matches(AmountOfLoanRegEx, String.valueOf(amountOfLoan));
	}
	private boolean checkAddressOfProperty(String addressOfProperty) {
		String AddressOfPropertyRegEx = " [A-Za-z0-9]*$";
		return Pattern.matches(AddressOfPropertyRegEx, addressOfProperty);
	}
	private boolean checkAnnualFamilyIncome(double annualFamilyIncome) {
		String AnnualFamilyIncomeRegEx = " [0-9]*$";
		return Pattern.matches(AnnualFamilyIncomeRegEx, String.valueOf(annualFamilyIncome));
	}
	private boolean checkDocumentsProofsAvailable(String documentsProofAvailable) {
		String DocumentsProofsAvailableRegEx = " [A-Za-z0-9]*$";
		return Pattern.matches(DocumentsProofsAvailableRegEx, documentsProofAvailable);
	}
	private boolean checkGuaranteeCover(String guaranteeCover) {
		String GuaranteeCoverRegEx = " [A-Za-z0-9]*$";
		return Pattern.matches(GuaranteeCoverRegEx, guaranteeCover);
	}
	private boolean checkMarketValueofGuarantee(double marketValueOfGuaranteeCover) {
		String MarketValueofGuaranteeRegEx = " [0-9]*$";
		return Pattern.matches(MarketValueofGuaranteeRegEx, String.valueOf(marketValueOfGuaranteeCover));
	}
	private boolean checkstatus(String status) {
		String StatusRegEx = " [A-Za-z0-9]*$";
		return Pattern.matches(StatusRegEx, status);
	}

	

	

	

	



	@Override
	public List<Loan> getLoans() throws LAPException {
		// TODO Auto-generated method stub
		return lapDao.getLoans();
	}

	@Override
	public List<Loan> getDetails(Loan loan) throws LAPException {
		// TODO Auto-generated method stub
		return lapDao.getDetails(loan);
	}

	@Override
	public int addApplicationDetails(Loan loan) throws LAPException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addApplicationMapping(Loan loan1) throws LAPException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validateParamaters(Loan loan) throws LAPException {
		// TODO Auto-generated method stub
		return false;
	}

	


	}


