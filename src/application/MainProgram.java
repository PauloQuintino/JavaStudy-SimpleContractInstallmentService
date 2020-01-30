package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contract;
import entities.Installments;
import services.ContractService;
import services.PaypalService;

public class MainProgram {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("***** ENTER CONTRACT DATA *****");
		System.out.print("Number: ");
		int contractNumber = sc.nextInt();
		System.out.print("Contract date (dd/mm/yyyy): ");
		Date dateScan = sdf.parse(sc.next());
		System.out.print("Contract value: R$ ");
		double value = sc.nextDouble();
		System.out.print("Enter the number of installments: ");
		int quotes = sc.nextInt();
		
		Contract contract = new Contract(contractNumber, dateScan, value);
		
		ContractService service = new ContractService(new PaypalService());
		service.processContract(contract, quotes);
		
		System.out.println("INSTALLMENTS");
		
		for (Installments x : contract.getInstallments()) {
			System.out.println(x);
		}

		sc.close();
	}

}
