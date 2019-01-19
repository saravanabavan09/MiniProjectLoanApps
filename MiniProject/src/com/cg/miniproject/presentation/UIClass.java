package com.cg.miniproject.presentation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.cg.miniproject.exception.LAPException;
import com.cg.miniproject.model.Loan;
import com.cg.miniproject.service.LoanService;
import com.cg.miniproject.service.LoanServiceImpl;
 
public class UIClass {

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scanner = null;
		int choice = 0;
		boolean choiceFlag = false;
		do {
			scanner = new Scanner(System.in);
			System.out.println("******** Loan Application System **********");
			System.out.println("1. View all loan programs offered by the provider");
			System.out.println("2. Apply for the online application");
			System.out.println("3. View my application status ");
			System.out.println("4. Exit");

			System.out.println("Enter your choice");
			try {
				choice = scanner.nextInt();
				choiceFlag = true;
				switch (choice) {
				case 1:
					scanner.nextLine();
					System.out.println("Enter the ProgramName:");
					String ProgramName = scanner.nextLine();
					System.out.println("Enter the description:");
					String description = scanner.nextLine();
					System.out.println("Enter the type:");
					String type = scanner.nextLine();
					System.out.println("Enter the durationinyears");
					int durationinyears = scanner.nextInt();
					System.out.println("Enter the minloanamount");
					int minloanamount = scanner.nextInt();
					System.out.println("Enter the maxloanamount");
					int maxloanamount = scanner.nextInt();
					System.out.println("Enter the rateofinterest");
					double rateofinterest = scanner.nextDouble();
					System.out.println("Enter the proofsrequired: ");
					scanner.nextLine();
					String proofsrequired = scanner.nextLine();

					Loan loan = new Loan();
					loan.setProgramName(ProgramName);
					loan.setDescription(description);
					loan.setType(type);
					loan.setDurationinyears(durationinyears);
					loan.setMinloanamount(minloanamount);
					loan.setMaxloanamount(maxloanamount);
					loan.setRateofinterest(rateofinterest);
					loan.setProofsrequired(proofsrequired);

					LoanService service = new LoanServiceImpl();

					try {
						
						 boolean validateFlag = service.validateParamaters(loan); 
						 if (validateFlag) {
						 
						int ApplicationId = service.addApplicationDetails(loan);
						System.out.println("successfully completed" + ApplicationId);
						 }
						List<Loan> list;
						list = service.getLoans();
						System.out.println("Loan Details");
						for (Loan lap : list) {

							System.out.println(lap.getProgramName() + "---" + lap.getDescription() + "---"
									+ lap.getType() + "---" + lap.getDurationinyears() + "----" + lap.getMinloanamount()
									+ "----" + lap.getMaxloanamount() + "----" + lap.getRateofinterest() + "----"
									+ lap.getProofsrequired());
						}

					}
				
					catch (LAPException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;

				case 2:
					scanner.nextLine();
					System.out.println("Enter the LoanProgram:");
					String LoanProgram = scanner.nextLine();
					System.out.println("Enter the AmountofLoan:");
					Double AmountofLoan = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter the AddressofProperty:");
					String AddressofProperty = scanner.nextLine();
					System.out.println("Enter the AnnualFamilyIncome");
					Double AnnualFamilyIncome = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter the DocumentsProofsAvailable");
					String DocumentsProofsAvailable = scanner.nextLine();
					System.out.println("Enter the GuaranteeCover");
					String GuaranteeCover = scanner.nextLine();
					System.out.println("Enter the MarketValueofGuarantee");
					Double MarketValueofGuarantee = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Enter the Status: ");
					String Status = scanner.nextLine();

					Loan loan1 = new Loan();
					loan1.setLoanProgram(LoanProgram);
					loan1.setAmountOfLoan(AmountofLoan);
					loan1.setAddressOfProperty(AddressofProperty);
					loan1.setAnnualFamilyIncome(AnnualFamilyIncome);
					loan1.setDocumentsProofAvailable(DocumentsProofsAvailable);
					loan1.setGuaranteeCover(GuaranteeCover);
					loan1.setMarketValueOfGuaranteeCover(MarketValueofGuarantee);
					loan1.setStatus(Status);

					LoanService service1 = new LoanServiceImpl();

					try {
						/*boolean validateFlag = service1.validateFields(loan1);*/
						/*if (validateFlag) {*/
							int ApplicationId = service1.addApplicationMapping(loan1);
							System.out.println("successfully completed" + ApplicationId);
						/*}*/
					
						
						}
						catch (LAPException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
						
						}
						
					break;
				case 3:
					System.out.println("Enter the Application ID: ");
					int applicationId = scanner.nextInt();
					Loan loan2 = new Loan();
					loan2.setApplicationId(applicationId);
					LoanService loanService = new LoanServiceImpl();

					try {
						List<Loan> list1 = loanService.getDetails(loan2);
						for (Loan loan3 : list1) {
							System.out.println(loan3.getStatus());

						}

					} catch (LAPException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:

					break;
				default:
					choiceFlag = false;
					System.out.println("input should be in the range of (1-4)");
					System.out.println("Enter your input again");
					break;

				}
			} catch (InputMismatchException e) {
				System.err.println("Enter only digits");
				System.out.println("Enter you input again");
			}

		} while (!choiceFlag);

		scanner.close();

	}
}