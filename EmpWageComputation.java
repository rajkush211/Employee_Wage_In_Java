public class EmpWageComputation {
	//CONSTANTS
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static String COMPANY_NAME;
	public static int EMP_RATE_PER_HOUR;
	public static int MAX_NUM_OF_WORKING_DAYS;
	public static int MAX_HRS_IN_MONTH;
	public static int TOTAL_EMP_WAGE;

	//CONSTRUCTOR
	public EmpWageComputation( String COMPANY_NAME, int EMP_RATE_PER_HOUR, int MAX_NUM_OF_WORKING_DAYS, int MAX_HRS_IN_MONTH )	{
		this.COMPANY_NAME = COMPANY_NAME;
		this.EMP_RATE_PER_HOUR = EMP_RATE_PER_HOUR;
		this.MAX_NUM_OF_WORKING_DAYS = MAX_NUM_OF_WORKING_DAYS;
		this.MAX_HRS_IN_MONTH = MAX_HRS_IN_MONTH;
	}

	public static String getCompanyName()	{
		return COMPANY_NAME;
	}

	public static int getEmpRatePerHour()	{
		return EMP_RATE_PER_HOUR;
	}

	public static int getMaxNumOfWorkingDays()	{
		return MAX_NUM_OF_WORKING_DAYS;
	}

	public static int getMaxHrsInMonth()	{
		return MAX_HRS_IN_MONTH;
	}

	public static int getTotalEmpWage()	{
		return TOTAL_EMP_WAGE;
	}

	//COMPUTATION
	public static void computeTotalEmpWage()	{
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while( totalEmpHrs <= getMaxHrsInMonth() &&
				totalWorkingDays < getMaxNumOfWorkingDays() )  {
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
		TOTAL_EMP_WAGE = totalEmpHrs * getEmpRatePerHour();
		System.out.println("Total Wage of " + getCompanyName() + " Employee is " + getTotalEmpWage());
	}

	public static void main(String args[]) {
		//CREATING OBJECTS FOR COMPANY
		EmpWageComputation bridgelabz = new EmpWageComputation( "Bridgelabz", 20, 20, 100 );
		bridgelabz.computeTotalEmpWage();

		EmpWageComputation google = new EmpWageComputation( "Google", 50, 15, 75 );
		google.computeTotalEmpWage();
	}
}
