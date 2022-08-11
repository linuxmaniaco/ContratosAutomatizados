package Services;

public class PaypalService implements OnlinePaymentService {
	
	public static final double  FEE_PERCENTEGE = 0.02;
	public static final double  MONTHLY_INTEREST = 0.01;
	
	
	@Override
	public double paymentFee(double amount) {	
		return amount * FEE_PERCENTEGE;
	}
	
	@Override
	public double interest(double amount, int months) {		
		return amount * MONTHLY_INTEREST * months;
	}
	
}
