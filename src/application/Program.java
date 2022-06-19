package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> List = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		
		for(int i =1;i<=n;i++) {
			System.out.println("Employee #"+i+" data:");
			System.out.print("Outsourced? (y/n)");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			if(ch =='y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				Employee emp= new OutsourcedEmployee(name,hours,valuePerHour,additionalCharge);
				List.add(emp);
			}else {
				Employee emp = new Employee(name,hours,valuePerHour);
				List.add(emp);
			}
		}
		System.out.println();
		System.out.println("Payment:");
		for(Employee emp:List) {
			System.out.println(emp.getName()+" - $ " + String.format("%.2f",+emp.payment()));
		}
		
		sc.close();
	}
}
