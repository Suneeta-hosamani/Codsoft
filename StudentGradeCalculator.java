import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        // Using try-with-resources to automatically close the Scanner
        try (Scanner sc = new Scanner(System.in)) {

            // Step 1: Take marks input
            System.out.print("Enter number of subjects: ");
            int numSubjects = sc.nextInt();

            int totalMarks = 0;

            // Step 2: Input marks for each subject
            for (int i = 1; i <= numSubjects; i++) {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                int marks = sc.nextInt();

                // Validate input
                if (marks < 0 || marks > 100) {
                    System.out.println("❌ Invalid marks! Please enter marks between 0 and 100.");
                    i--; // re-enter for the same subject
                    continue;
                }
                totalMarks += marks;
            }

            // Step 3: Calculate average percentage
            double averagePercentage = (double) totalMarks / numSubjects;

            // Step 4: Determine grade
            char grade;
            if (averagePercentage >= 90) {
                grade = 'A';
            } else if (averagePercentage >= 80) {
                grade = 'B';
            } else if (averagePercentage >= 70) {
                grade = 'C';
            } else if (averagePercentage >= 60) {
                grade = 'D';
            } else if (averagePercentage >= 50) {
                grade = 'E';
            } else {
                grade = 'F';
            }

            // Step 5: Display results
            System.out.println("\n--- Result ---");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
            System.out.println("Grade: " + grade);
        }
    }
}
