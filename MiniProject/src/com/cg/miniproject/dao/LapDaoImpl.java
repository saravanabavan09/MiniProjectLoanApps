package com.cg.miniproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.miniproject.exception.LAPException;
import com.cg.miniproject.model.Loan;
import com.cg.miniproject.utility.JDBCUtility;

public class LapDaoImpl implements LapDao {
	Connection connection = null;

	PreparedStatement statement = null;
	ResultSet resultSet = null;
	static Logger logger = Logger.getLogger(LapDaoImpl.class);

	@Override
	public int addApplicationDetails(Loan loan) throws LAPException {
		logger.info("in add Customer method");
		/**
		 * method       : addCustomerDetails
		 * argument     : it's taking model object as an argument
		 * return type  : this method return the generated id to the user 
		 * Author       : Capgemini
		 * Date         : 17 - Jan - 2019
		 * 
		 **/

		connection = com.cg.miniproject.utility.JDBCUtility.getConnection();
		logger.info("connection object created");
		int generatedId = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertLoanPrograms);
			logger.debug("statement object created");
			statement.setString(1, loan.getProgramName());
			statement.setString(2, loan.getDescription());
			statement.setString(3, loan.getType());
			statement.setInt(4, loan.getDurationinyears());
			statement.setInt(5, loan.getMinloanamount());
			statement.setInt(6, loan.getMaxloanamount());
			statement.setDouble(7, loan.getRateofinterest());
			statement.setString(8, loan.getProofsrequired());

			/*
			 * statement.setString(1, loan.getLoanProgram()); statement.setDouble(2,
			 * loan.getAmountOfLoan()); statement.setString(3, loan.getAddressOfProperty());
			 * statement.setDouble(4, loan.getAnnualFamilyIncome()); statement.setString(5,
			 * loan.getDocumentsProofAvailable()); statement.setString(6,
			 * loan.getGuaranteeCover()); statement.setDouble(7,
			 * loan.getMarketValueOfGuaranteeCover()); statement.setString(8,
			 * loan.getStatus());
			 */
			generatedId = statement.executeUpdate();
			logger.info("execute update called");

			/*
			 * statement = connection.prepareStatement(QueryMapper.getApplicationId);
			 * logger.info("statement created to getPurchaseId"); resultSet =
			 * statement.executeQuery(); logger.info("result object get created");
			 * resultSet.next(); generatedId = resultSet.getInt(1);
			 * logger.info("generated id is: " + generatedId);
			 */
		} catch (SQLException e) {
			/*logger.error(e.getMessage());
			throw new LAPException("problem occured while creating the statement object");*/
			e.printStackTrace();
		}

		/*finally {
			logger.info("in finally block");

			try {

				logger.info("resultset closed");
			} catch (SQLException e) {
				throw new LAPException("problem occured while closing resultset");
			}
			try {
				statement.close();
				logger.info("statement closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new LAPException("problem occured while closing statement");
			}
			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new LAPException("problem occured while closing connection");
			}

		}
*/		return generatedId;
	}

	@Override
	public List<Loan> getLoans() throws LAPException {
		List<Loan> list = new ArrayList<>();
		connection = JDBCUtility.getConnection();
		
		
		try {
			statement = connection.prepareStatement(QueryMapper.getLoans);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String program  = resultSet.getString(1);
				String description = resultSet.getString(2);
				String type = resultSet.getString(3);
				int durationInYears = resultSet.getInt(4);
				int minLoanAmount =resultSet.getInt(5);
				int maxLoanAmount = resultSet.getInt(6);
				int rateOfInterest=resultSet.getInt(7);
				String proofsRequired = resultSet.getString(8);
			 Loan loan = new Loan();
			 loan.setProgramName(program);
			 loan.setDescription(description);
			 loan.setType(type);
			 loan.setDurationinyears(durationInYears);
			 loan.setMinloanamount(minLoanAmount);
			 loan.setMaxloanamount(maxLoanAmount);
			 loan.setRateofinterest(rateOfInterest);
			 loan.setProofsrequired(proofsRequired);

				list.add(loan);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Loan> getDetails(Loan loan) throws LAPException {
			connection = JDBCUtility.getConnection();
			List<Loan> list = new ArrayList<>();
			
			try {
				statement = connection.prepareStatement(QueryMapper.getDetails);
				
				statement.setInt(1, loan.getApplicationId());
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String status = resultSet.getString(1);
					loan.setStatus(status);

					list.add(loan);
				}
			} catch (SQLException e) {
				throw new LAPException("Statement was not created");
			} finally {
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new LAPException("ResultSet was not closed");
				}
				try {
					statement.close();
				} catch (SQLException e) {
					throw new LAPException("Statement was not closed");
				}
				try {
					connection.close();
				} catch (SQLException e) {
					throw new LAPException("Connection was not closed");
				}

			}
		return list;
	}

	@Override
	public int addApplicationMapping(Loan loan1) throws LAPException {
		connection = com.cg.miniproject.utility.JDBCUtility.getConnection();
		logger.info("connection object created");
		int generatedId = 0;
		try {
			statement = connection.prepareStatement(QueryMapper.insertApplicationPrograms);
			logger.debug("statement object created");
			statement.setInt(1, loan1.getApplicationId());
			statement.setString(2, loan1.getLoanProgram());
			statement.setString(3, loan1.getAddressOfProperty());
			statement.setDouble(4, loan1.getAnnualFamilyIncome());
			statement.setString(5, loan1.getDocumentsProofAvailable());
			statement.setString(6, loan1.getGuaranteeCover());
			statement.setDouble(7, loan1.getMarketValueOfGuaranteeCover());
			statement.setString(8, loan1.getStatus());
			generatedId = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generatedId;
	}

}
