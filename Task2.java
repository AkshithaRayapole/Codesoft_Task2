import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("How many subjects? ");
            int num = sc.nextInt();
            
            if(num <= 0) {
                System.out.println("Must have at least 1 subject");
                return;
            }
            
            int[] subs = new int[num];
            int sum = 0;
            
            for(int i=0; i<num; i++) {
                System.out.print("Marks for subject "+(i+1)+": ");
                subs[i] = sc.nextInt();
                
                if(subs[i] < 0 || subs[i] > 100) {
                    System.out.println("Marks must be 0-100");
                    i--;
                    continue;
                }
                
                sum += subs[i];
            }
            
            double avg = (double)sum / num;
            String grade = getGrade(avg);
            
            System.out.println("\nReport Card");
            System.out.println("Total: "+sum);
            System.out.printf("Average: %.1f%%\n", avg);
            System.out.println("Grade: "+grade);
        } finally {
            sc.close();
        }
    }
    
    static String getGrade(double p) {
        if(p >= 90) return "A+";
        if(p >= 80) return "A";
        if(p >= 70) return "B";
        if(p >= 60) return "C";
        if(p >= 50) return "D";
        return "F";
    }
}