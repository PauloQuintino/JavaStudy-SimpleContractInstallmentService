package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installments;

public class ContractService {
	
	private OnlinePaymentService onlineService;
	
	
	public ContractService(OnlinePaymentService onlineService) {
		this.onlineService = onlineService;
	}
	

	public void processContract(Contract contract, int months) {
		
		double basicQuota = contract.getTotalValue() / months;
		
		for(int i =0; i <= months; i++) {
			Date date = addMonths(contract.getDate(), i);
			double updatedQuota = basicQuota + onlineService.interest(basicQuota, i);
			double fullQuota = updatedQuota + onlineService.paymentFee(updatedQuota);
			contract.addInstallment(new Installments(date, fullQuota));
		}
		
	}
	
	public Date addMonths(Date date, int n) {	
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return calendar.getTime();
	}
	
}
