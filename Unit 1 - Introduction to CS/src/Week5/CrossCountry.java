package Week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        //Variables needed for the First Runner

        Scanner in = new Scanner(System.in);

        processRunner(in);
        processRunner(in);
        processRunner(in);
    }

    private static void processRunner(Scanner in) {
        String n, firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;
        
        System.out.print("Please enter runner's number: ");
        n = in.nextLine();

        System.out.print("Please enter runner's first name: ");
        firstName = in.nextLine();

        System.out.print("Please enter runner's last name: ");
        lastName = in.nextLine();

        System.out.print("Please enter runner's Mile 1 time: ");
        mileOne = in.nextLine();

        System.out.print("Please enter runner's Mile 2 time: ");
        mileTwo = in.nextLine();

        System.out.print("Please enter runner's total 5km time: ");
        finish = in.nextLine();

        splitTwo = subtractTime(mileTwo, mileOne);

        //Step 1 - prompt user name
        //Step 2 - get mileOne time
        //Step 3 - get mileTwo time
        //Step 4 - get finish time
        //Step 5 - find splitTwo time
        //Step 6 - find splitThree time
        splitThree = subtractTime(finish, mileTwo);
        System.out.println("\nSummary of run:");
        System.out.println("Runner "+n+": "+firstName+" "+lastName);
        System.out.println("Runner "+n+" - Split 1 Time: "+mileOne);
        System.out.println("Runner "+n+" - Split 2 Time: "+splitTwo);
        System.out.println("Runner "+n+" - Split 3 Time: "+splitThree);
        System.out.println("Runner "+n+" - Total 5km Time: "+finish+"\n");
    }

    private static String subtractTime(String time2, String time1) {
        double time2InSeconds = convertToSeconds(time2);
        double time1InSeconds = convertToSeconds(time1);
        double splitTimeSec = time2InSeconds - time1InSeconds;
        return convertToMinutes(splitTimeSec);
    }

    private static String convertToMinutes(double seconds) {
        int min = (int)(seconds/60);
        double sec = seconds - min*60;
        return min+":"+sec;
    }

    private static double convertToSeconds(String time) {
        int mintosec = Integer.parseInt(time.substring(0, time.indexOf(":"))) * 60;
        double secaddminsec = Double.parseDouble(time.substring(time.indexOf(":")+1)) + mintosec;
        return secaddminsec;
    }
}
