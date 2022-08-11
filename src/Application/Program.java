package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Services.ContractService;
import Services.OnlinePaymentService;
import Services.PaypalService;
import entities.Contract;
import entities.Installment;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type contract data");
		
		System.out.print("Contract Number: ");
		int number = sc.nextInt(); sc.nextLine();
		System.out.print("Contract date: ");
		Date data = sdf.parse(sc.nextLine());

		System.out.print("Contract Value: ");
		double amount = sc.nextDouble();
				
		Contract contract = new Contract(number, data, amount);
		
		System.out.print("Quantity installments: ");
		int months = sc.nextInt();
		ContractService cs = new ContractService(new PaypalService());
		
		cs.processContract(contract, months);
		
		
		
		// SAIDA //
		System.out.println("Calculations (1% monthly simple interest + 2% payment fee): ");
		System.out.println("Installments");
		
		for (Installment it : contract.getInstallments()) {
			System.out.println(it);
		}
		
				
		
		sc.close();
	}

}
