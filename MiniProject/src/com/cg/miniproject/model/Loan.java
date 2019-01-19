package com.cg.miniproject.model;

public class Loan {
	private Integer ApplicationId;

	public Integer getApplicationId() {
		return ApplicationId;
	}

	public void setApplicationId(Integer applicationId) {
		ApplicationId = applicationId;
	}

	public String getLoanProgram() {
		return LoanProgram;
	}

	public void setLoanProgram(String loanProgram) {
		LoanProgram = loanProgram;
	}

	public Double getAmountOfLoan() {
		return AmountOfLoan;
	}

	public void setAmountOfLoan(Double amountOfLoan) {
		AmountOfLoan = amountOfLoan;
	}

	public String getAddressOfProperty() {
		return AddressOfProperty;
	}

	public void setAddressOfProperty(String addressOfProperty) {
		AddressOfProperty = addressOfProperty;
	}

	public Double getAnnualFamilyIncome() {
		return AnnualFamilyIncome;
	}

	public void setAnnualFamilyIncome(Double annualFamilyIncome) {
		AnnualFamilyIncome = annualFamilyIncome;
	}

	public String getDocumentsProofAvailable() {
		return DocumentsProofAvailable;
	}

	public void setDocumentsProofAvailable(String documentsProofAvailable) {
		DocumentsProofAvailable = documentsProofAvailable;
	}

	public String getGuaranteeCover() {
		return GuaranteeCover;
	}

	public void setGuaranteeCover(String guaranteeCover) {
		GuaranteeCover = guaranteeCover;
	}

	public Double getMarketValueOfGuaranteeCover() {
		return MarketValueOfGuaranteeCover;
	}

	public void setMarketValueOfGuaranteeCover(Double marketValueOfGuaranteeCover) {
		MarketValueOfGuaranteeCover = marketValueOfGuaranteeCover;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Loan(Integer applicationId, String loanProgram, Double amountOfLoan, String addressOfProperty,
			Double annualFamilyIncome, String documentsProofAvailable, String guaranteeCover,
			Double marketValueOfGuaranteeCover, String status) {
		super();
		ApplicationId = applicationId;
		LoanProgram = loanProgram;
		AmountOfLoan = amountOfLoan;
		AddressOfProperty = addressOfProperty;
		AnnualFamilyIncome = annualFamilyIncome;
		DocumentsProofAvailable = documentsProofAvailable;
		GuaranteeCover = guaranteeCover;
		MarketValueOfGuaranteeCover = marketValueOfGuaranteeCover;
		Status = status;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String LoanProgram;
	private Double AmountOfLoan;
	private String AddressOfProperty;
	private Double AnnualFamilyIncome;
	private String DocumentsProofAvailable;
	private String GuaranteeCover;
	private Double MarketValueOfGuaranteeCover;
	private String Status;
	private String ProgramName;
	private String description;
	private String type;
	private Integer durationinyears;

	public String getProgramName() {
		return ProgramName;
	}

	public void setProgramName(String programName) {
		ProgramName = programName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDurationinyears() {
		return durationinyears;
	}

	public void setDurationinyears(int durationinyears) {
		this.durationinyears = durationinyears;
	}

	public int getMinloanamount() {
		return minloanamount;
	}

	public void setMinloanamount(int minloanamount) {
		this.minloanamount = minloanamount;
	}

	public int getMaxloanamount() {
		return maxloanamount;
	}

	public void setMaxloanamount(int maxloanamount) {
		this.maxloanamount = maxloanamount;
	}

	public double getRateofinterest() {
		return rateofinterest;
	}

	public void setRateofinterest(double rateofinterest) {
		this.rateofinterest = rateofinterest;
	}

	public String getProofsrequired() {
		return proofsrequired;
	}

	public void setProofsrequired(String proofsrequired) {
		this.proofsrequired = proofsrequired;
	}

	private Integer minloanamount;
	private Integer maxloanamount;
	private Double rateofinterest;
	private String proofsrequired;

	public Loan(String programName, String description, String type, int durationinyears, int minloanamount,
			int maxloanamount, double rateofinterest, String proofsrequired) {
		super();
		ProgramName = programName;
		this.description = description;
		this.type = type;
		this.durationinyears = durationinyears;
		this.minloanamount = minloanamount;
		this.maxloanamount = maxloanamount;
		this.rateofinterest = rateofinterest;
		this.proofsrequired = proofsrequired;
	}
}
