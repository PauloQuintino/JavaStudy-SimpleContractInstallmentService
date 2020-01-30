package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	// method to calculte simple monthly payment
	public static void calculateMonthlyPayment(Date dateScan) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateScan);
		calendar.add(Calendar.MONTH, 1);

		System.out.println("Result: " + sdf.format(calendar.getTime()));

	}

	public static void calculateMonthlyPaymentWithQuote(Date date, int quotes) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		System.out.println("NEXT INSTALLMENTS");

		if (quotes == 1) {
			calendar.add(Calendar.MONTH, 1);
			System.out.println("Quote 1: " + sdf.format(calendar.getTime()));
		} else if (quotes == 2) {

			for (int i = 0; i < 2; i++) {
				calendar.add(Calendar.MONTH, 1);
				System.out.println("Quote " +(i+1)+": " + sdf.format(calendar.getTime()));
			}

		} else if (quotes == 3) {

			for (int i = 0; i < 3; i++) {
				calendar.add(Calendar.MONTH, 1);
				System.out.println("Quote "+(i+1)+": " + sdf.format(calendar.getTime()));
			}

		}

	}

}
