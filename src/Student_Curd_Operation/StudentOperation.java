package Student_Curd_Operation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentOperation {
	Address a = null;
	Student s = null;
	static ArrayList<Student> arraylist = new ArrayList<Student>();
	public static void main(String[] args) {
		System.out.println("***Welcome To Student Management System***");
		System.out.println("==========================================");
		
		getMenu();

	}
	
	@SuppressWarnings("resource")
	public static void getMenu() {
		StudentOperation s = new StudentOperation();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Choice:");
		System.out.println("1. Add Student Details");
		System.out.println("2. Display Student Details");
		System.out.println("3. Display Student Details Based On Id");
		System.out.println("4. Delete Student Details Based On Id");
		System.out.println("5. Delete All Student Details");
		System.out.println("6. Update Student Details");
		System.out.println("7. Quit/Exit");
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				s.add_Student();
				getMenu();
			case 2:
				s.display_StudentDetails();
				getMenu();
			case 3:
				s.display_ParticularStudentDetails();
				getMenu();
			case 4:
				s.delete_ParticularStudentDetails();
				getMenu();
			case 5:
				s.delete_AllStudentDetails();
				getMenu();
			case 6:
				s.Update_StudentDetails();
				getMenu();
			case 7:
				 System.exit(0);
				
		}
		
	}
	static int id = 1;
	@SuppressWarnings("resource")
	public void add_Student() {
		System.out.println();
		System.out.println("Add Student Details:");
		System.out.println("====================");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name:");
		String name = sc.nextLine();
		System.out.println("Enter the Age:");
		int age = sc.nextInt();sc.nextLine();
		
		System.out.println("Add Student Address:");
		System.out.println("====================");
		System.out.println("Enter the City:");
		String city = sc.nextLine();
		System.out.println("Enter the State:");
		String state = sc.nextLine();
		System.out.println("Enter the Country:");
		String country = sc.nextLine();
		
		a = new Address();
		a.setS_city(city);
		a.setS_State(state);
		a.setS_Country(country);
		
		s = new Student();
		s.setS_id(id);
		s.setS_Name(name);
		s.setS_Age(age);
		s.setS_Ad(a);
		
		id++;
		
		arraylist.add(s);
	}
	
	public void display_StudentDetails() {
		System.out.println("Student Details:");
		System.out.println("================");
		
		if(arraylist.isEmpty()) {
			System.out.println("No Students in the list.");
			System.out.println("************************");
			getMenu();
		}
		
		Iterator<Student> itr = arraylist.iterator();
		while(itr.hasNext()) {
			Student s = itr.next();
			System.out.println("ID: "+s.getS_id());
			System.out.println("=====");
			System.out.println("Name: "+s.getS_Name());
			System.out.println("Age: "+s.getS_Age());
			System.out.println("City: "+s.getS_Ad().getS_city());
			System.out.println("State: "+s.getS_Ad().getS_State());
			System.out.println("Country: "+s.getS_Ad().getS_Country());
			System.out.println();
		}
		System.out.println("*********************");
	}
	
	@SuppressWarnings("resource")
	public void display_ParticularStudentDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id:");
		int id = sc.nextInt();
		
		Iterator<Student> itr = arraylist.iterator();
		while(itr.hasNext()) {
			Student s = itr.next();
			if(id == s.getS_id()) {
				System.out.println("ID: "+s.getS_id());
				System.out.println("=====");
				System.out.println("Name: "+s.getS_Name());
				System.out.println("Age: "+s.getS_Age());
				System.out.println("City: "+s.getS_Ad().getS_city());
				System.out.println("State: "+s.getS_Ad().getS_State());
				System.out.println("Country: "+s.getS_Ad().getS_Country());
			}
		}
	}
	
	@SuppressWarnings("resource")
	public void delete_ParticularStudentDetails() {
		if(arraylist.isEmpty()) {
			System.out.println("No Students in the list.");
			System.out.println("************************");
			getMenu();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student id to delete:");
		int id = sc.nextInt();
		
		Iterator<Student> itr = arraylist.iterator();
		while(itr.hasNext()) {
			Student s = itr.next();
			if(id == s.getS_id()) {
				itr.remove();
				System.out.println("Successfully Deleted");
				System.out.println("********************");
			}
		}
	}
	
	public void delete_AllStudentDetails() {
		if(arraylist.isEmpty()) {
			System.out.println("No Students in the list to delete");
		}else {
			arraylist.clear();
			System.out.println("Successfully deleted all the details");
			System.out.println("************************************");
		}
	}
	
	@SuppressWarnings("resource")
	public void Update_StudentDetails() {
		if(arraylist.isEmpty()) {
			System.out.println("No Students in the list to update:");
			System.out.println("**********************************");
			getMenu();
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of student you want to update:");
		int id = sc.nextInt();
		Iterator<Student> itr = arraylist.iterator();
		while(itr.hasNext()) {
			Student s = itr.next();
			if(s.getS_id() == id) {
				System.out.println("Do you want to edit:");
				System.out.println("1.Name 2.Age 3.City 4.State 5.Country");
				int update = sc.nextInt();
				switch (update) {
				case 1:
					System.out.println("Enter the new Name:");
					String s_name = sc.next();
					s.setS_Name(s_name);
					break;
				case 2:
					System.out.println("Enter the New Age:");
					int age = sc.nextInt();
					s.setS_Age(age);
					break;
				case 3:
					System.out.println("Enter the New City:");
					String city = sc.next();
					s.getS_Ad().setS_city(city);
					break;
				case 4:
					System.out.println("Enter the New State:");
					String state = sc.next();
					s.getS_Ad().setS_State(state);
					break;
				case 5:
					System.out.println("Enter the New Country:");
					String country = sc.next();
					s.getS_Ad().setS_Country(country);
					break;
				default:
					System.out.println("Enter the Correct Number:");
					Update_StudentDetails();
				  }
			}
		}
	}
}
