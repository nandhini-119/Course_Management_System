package week5Project;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Project {

	public static String name, course, prefBatch, trainerName;
	public static int pendingPay, stdId, initialPayment;
	public static Project batchAvailable, courseDetailsWithAmt, joinedStudents;

	public static void main(String[] args) {

		HashMap<String, Integer> courseDetailsWithAmt = new HashMap<>();
		courseDetailsWithAmt.put("java", 20000);
		courseDetailsWithAmt.put("python", 15000);
		courseDetailsWithAmt.put("js", 18000);

		HashMap<String, String> trainerName = new HashMap<>();
		trainerName.put("java", "John");
		trainerName.put("python", "Jack");
		trainerName.put("js", "David");

		HashMap<String, Integer> javaslotAvailable = new HashMap<>();
		javaslotAvailable.put("weekdays", 0);
		javaslotAvailable.put("weekends", 3);

		HashMap<String, Integer> pythonslotAvailable = new HashMap<>();
		pythonslotAvailable.put("weekdays", 4);
		pythonslotAvailable.put("weekends", 2);

		HashMap<String, Integer> jsslotAvailable = new HashMap<>();
		jsslotAvailable.put("weekdays", 3);
		jsslotAvailable.put("weekends", 2);

		HashMap<String, HashMap<String, Integer>> batchAvailable = new HashMap<>();

		batchAvailable.put("java", javaslotAvailable);
		batchAvailable.put("python", pythonslotAvailable);
		batchAvailable.put("js", jsslotAvailable);

		HashMap<Integer, StudentDetails> joinedStudents = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		System.out.println("TechThirst Academy Welcomes You!");
		String s = "Y";

		stdId = 100;
		while (s.equalsIgnoreCase("Y")) {

			System.out.println(
					"Choose any from below \n 1.Join Course\n 2.Course Details\n 3.Pending pay List \n 4.Joined student details\n 5.Exit\n");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println("Enter your name");
				name = sc.next();
				// Select Course
				while (true) {
					System.out.println("Enter your Course");
					course = sc.next();
					// checking valid course
					boolean checkCourse = courseDetailsWithAmt.containsKey(course);
					if (!checkCourse)
						System.out.println(
								"You can only Register for the available courses,please refer course details!");
					else
						break;
				}

				// Select Batch
				System.out.println("Enter your Batch either weekdays or weekends");
				prefBatch = sc.next();
				// Checking slot availability
				if (batchAvailable.get(course).get(prefBatch) > 0) {
					System.out.println(
							"You are allocated to your prefered batch " + prefBatch + " for the " + course + " course");
					int slotcountUpdate = batchAvailable.get(course).get(prefBatch) - 1;

					// updated slot
					// System.out.println(batchAvailable.get(course));
					batchAvailable.get(course).put(prefBatch, slotcountUpdate);
				} else if (batchAvailable.get(course).get(prefBatch) == 0) {
					batchAvailable.get(course).entrySet().forEach(e -> {
						if (e.getValue() > 0)
							System.out.println("your prefered batch " + prefBatch
									+ "is currently not available for the " + course + " course,"
									+ " so allocated to available batch " + e.getKey() + " " + e.getValue() + " slots");
					});
					int slotcountUpdate = batchAvailable.get(course).get(prefBatch) - 1;

					// updated slot
					// System.out.println(batchAvailable.get(course));
					batchAvailable.get(course).put(prefBatch, slotcountUpdate);
				} else
					System.out.println("Invalid batch");

				// Make Payment
				while (true) {
					System.out.println("Enter your initial payment amount:\n");
					initialPayment = sc.nextInt();

					// PaymentValidation
					pendingPay = 0;
					int minFee = 5000;
					int maxFee = courseDetailsWithAmt.get(course);
					if (initialPayment < minFee || initialPayment > maxFee || initialPayment <= 0) {
						System.out.println(
								"The fee amount is invalid. Please enter a valid fee\n.Refer Course Details.Minimum fee amount paid to be paid is 5000");

					} else {
						pendingPay = courseDetailsWithAmt.get(course) - initialPayment;
						break;
					}
				}

				// Adding joinedStudentDetails
				joinCourse(name, course, prefBatch, pendingPay, stdId, batchAvailable, courseDetailsWithAmt,
						joinedStudents, trainerName); // method invoke
				stdId++;
				break;

			case 2:
				System.out.println("Course Details:\n");
				courseDetailsWithAmt.entrySet().forEach(e -> {
					System.out.println(e.getKey() + " : " + e.getValue());
				});
				System.out.println();
				System.out.println("Trainer Details:\n");
				trainerName.entrySet().forEach(e -> {
					System.out.println(e.getKey() + " : " + e.getValue());
				});
				System.out.println();
				break;

			case 3:
				System.out.println("Pending Payment List:\n");
				System.out.println("Student_id" + "\t" + "Student_Name" + "\t" + "Pending_Amount");
				joinedStudents.entrySet().forEach(e -> {
					if (e.getValue().getPendingPay() > 0)
						System.out.println(e.getValue().id + "\t\t" + e.getValue().getStudName() + "\t\t"
								+ e.getValue().getPendingPay() + "\n");
				});
				break;

			case 4:
				System.out.println("Joined Students List:\n");
				joinedStudents.entrySet().forEach(e -> {
					System.out.println("Student_id:" + e.getValue().id + "\n" + "Student_Name:"
							+ e.getValue().getStudName() + "\n" + "Course_Name:" + e.getValue().getCourseName() + "\n"
							+ "Trainer_Name:" + e.getValue().getTrainerName() + "\n" + "Pending_Payment:"
							+ e.getValue().getPendingPay() + "\n");
				});
				break;

			case 5:
				System.out.println("Thank you");
				s = "N";
				break;

			default:
				System.out.println("Choose a correct option to proceed");
				break;
			}
			System.out.println("Do you want to continue?(Y/N)");
			s = sc.next();
		}
	}

	// joinCourse method
	private static void joinCourse(String name, String course, String prefBatch, int pendingPay, int stdId,
			HashMap<String, HashMap<String, Integer>> batchAvailable, HashMap<String, Integer> courseDetailsWithAmt,
			HashMap<Integer, StudentDetails> joinedStudents, HashMap<String, String> trainerName) {
		System.out.println(name + " you have successfully joined the " + course + " course!");
		joinedStudents.put(stdId, new StudentDetails(stdId, name, course, trainerName.get(course), pendingPay));

	}
}
