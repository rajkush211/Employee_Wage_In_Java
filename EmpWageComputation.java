import java.util.ArrayList;

interface WageMethod	{

	public void computeTotalEmpWage( CompanyEmpWage object );

}

public class EmpWageComputation implements WageMethod	{
	//CONSTANTS
	public final int IS_PART_TIME = 1;
	public final int IS_FULL_TIME = 2;
	//COMPUTATION
	public void computeTotalEmpWage( CompanyEmpWage companyEmployee )	{
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while( totalEmpHrs <= companyEmployee.getMaxHrsInMonth() &&
				totalWorkingDays < companyEmployee.getMaxNumOfWorkingDays() )  {
			totalWorkingDays++;
			int empCheck = (int) ( Math.random() * 10 ) % 3;
			switch (empCheck) {
				case IS_PART_TIME:
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
			}
			totalEmpHrs += empHrs;
			System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " +  empHrs);
		}
		companyEmployee.setTotalEmpWage( totalEmpHrs * companyEmployee.getEmpRatePerHour() );
		System.out.println("Total Wage of " + companyEmployee.getCompanyName() + " Employee is " + companyEmployee.getTotalEmpWage());
	}

	//MAIN
	public static void main(String args[]) {

		EmpWageComputation empwagecomputation = new EmpWageComputation();

		//DECLARING ARRAYLIST OF COMPANY EMPLOYEE WAGE OBJECT
		ArrayList<CompanyEmpWage> company = new ArrayList<CompanyEmpWage>();

		company.add( new CompanyEmpWage( "BRIDGELABZ", 20, 20, 100 ));
		empwagecomputation.computeTotalEmpWage(company.get(0));

		company.add( new CompanyEmpWage( "GOOGLE", 30, 20, 70 ));
		empwagecomputation.computeTotalEmpWage(company.get(1));
	}
}

class CompanyEmpWage	{

	public String COMPANY_NAME;
	public int EMP_RATE_PER_HOUR;
	public int MAX_NUM_OF_WORKING_DAYS;
	public int MAX_HRS_IN_MONTH;

	public int totalEmpWage = 0;
	//CONSTRUCTOR
	public CompanyEmpWage( String COMPANY_NAME, int EMP_RATE_PER_HOUR, int MAX_NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH )	{
		this.COMPANY_NAME = COMPANY_NAME;
		this.EMP_RATE_PER_HOUR = EMP_RATE_PER_HOUR;
		this.MAX_NUM_OF_WORKING_DAYS = MAX_NUM_OF_WORKING_DAYS;
		this.MAX_HRS_IN_MONTH = MAX_HRS_IN_MONTH;
	}
	//GETTERS
	public String getCompanyName()	{
		return COMPANY_NAME;
	}
	public int getEmpRatePerHour()	{
		return EMP_RATE_PER_HOUR;
	}

	public int getMaxNumOfWorkingDays()	{
		return MAX_NUM_OF_WORKING_DAYS;
	}

	public int getMaxHrsInMonth()	{
		return MAX_HRS_IN_MONTH;
	}

	public void setTotalEmpWage( int totalEmpWage )	{
		this.totalEmpWage = totalEmpWage;
	}

	public int getTotalEmpWage()  {
		return totalEmpWage;
   }
}

