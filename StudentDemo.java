package excepetion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemo {
	ArrayList<Student> al = new ArrayList<Student>();
	Scanner scanner = new Scanner(System.in);
	Student student = new Student();
	Connect connect = new Connect();

	public void display() {

		StudentDemo demo = new StudentDemo();
		System.out.println("1.add \n 2.update \n 3.delete \n ");
		switch (scanner.nextInt()) {

		case 1:
			demo.add();
			break;
		case 2:
			demo.update();
			break;
		case 3:
			demo.delete();
			break;
		default:
			System.out.println("invalid");
			break;
		}
	}

	public void add() {
		Connect connect = new Connect();
		Scanner scanner = new Scanner(System.in);
		StudentDemo demo = new StudentDemo();
		System.out.println("enter the student details");

		System.out.println("enter the student rollno");
		student.setRollno(scanner.next());

		System.out.println("enter the student name");
		student.setName(scanner.next());
		String name=student.getName();
		int l, temp = 0;
		l = name.length();
		for (int i = 0; i < l; i++) {
			char ch;
			ch = name.charAt(i);
			if (ch < 'A' || ch > 'Z' && ch < 'a' || ch > 'z')
				temp = 1;
		}

		try {
			if (temp == 1)
				throw new NameNotValidException();
			else
				name = name;
		} catch (NameNotValidException e) {
			System.out.println(e);
		}

		
		System.out.println("enter the student age");
		student.setAge(scanner.nextInt());
		int age=student.getAge();
		try {
			if (age>= 15 && age <= 21)
				age = age;
			else
				throw new AgeNotFoundException();
		} catch (AgeNotFoundException e) {
			System.out.println(e);
		}


		System.out.println("enter the student course");
		student.setCourse(scanner.next());
		al.add(student);
		connect.addStudent(student);

		demo.display();
	}

	public void update() {

		StudentDemo demo = new StudentDemo();

		System.out.println("enter the student rollno");
		student.setRollno(scanner.next());

		System.out.println("enter the student name");
		student.setName(scanner.next());
		String name=student.getName();
		int l, temp = 0;
		l = name.length();
		for (int i = 0; i < l; i++) {
			char ch;
			ch = name.charAt(i);
			if (ch < 'A' || ch > 'Z' && ch < 'a' || ch > 'z')
				temp = 1;
		}

		try {
			if (temp == 1)
				throw new NameNotValidException();
			else
				name = name;
		} catch (NameNotValidException e) {
			System.out.println(e);
		}


		System.out.println("enter the student age");
		student.setAge(scanner.nextInt());
		int age=student.getAge();
		try {
			if (age>= 15 && age <= 21)
				age = age;
			else
				throw new AgeNotFoundException();
		} catch (AgeNotFoundException e) {
			System.out.println(e);
		}

		System.out.println("enter the student course");
		student.setCourse(scanner.next());

		connect.upStudent(student);

		System.out.println("update successfully");

		demo.display();
	}

	public void delete() {
		StudentDemo demo = new StudentDemo();

		System.out.println("enter  rollno to be delete");
		String rollno = scanner.next();
		connect.delStudent(rollno);
		System.out.println("delete successfully");

		demo.display();
	}

	public static void main(String[] args) throws IOException {
		StudentDemo demo = new StudentDemo();
		demo.display();
	}

}
