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

        //Step 1 - get runner number
        System.out.print("Please enter runner's number: ");
        n = in.nextLine();

        //Step 2 - prompt user first name
        System.out.print("Please enter runner's first name: ");
        firstName = in.nextLine();

        //Step 3 - prompt user last name
        System.out.print("Please enter runner's last name: ");
        lastName = in.nextLine();

        //Step 4 - get mileOne time
        System.out.print("Please enter runner's Mile 1 time: ");
        mileOne = in.nextLine();

        //Step 5 - get mileTwo time
        System.out.print("Please enter runner's Mile 2 time: ");
        mileTwo = in.nextLine();

        //Step 6 - get finish time
        System.out.print("Please enter runner's total 5km time: ");
        finish = in.nextLine();

        //Step 7 - calculate splitTwo time
        splitTwo = subtractTime(mileTwo, mileOne);

        //Step 8 - calculate splitThree time
        splitThree = subtractTime(finish, mileTwo);

        //Step 9 - Display Summary of Run
        System.out.println("\nSummary of run:");
        System.out.println("Runner "+n+": "+firstName+" "+lastName);
        System.out.println("Runner "+n+" - Split 1 Time: "+mileOne);
        System.out.println("Runner "+n+" - Split 2 Time: "+splitTwo);
        System.out.println("Runner "+n+" - Split 3 Time: "+splitThree);
        System.out.println("Runner "+n+" - Total 5km Time: "+finish+"\n");
    }

    /**
     * The subtractTime method finds the difference of the times entered in as parameters
     * @param time2 - Time it takes a runner to run a specific distance
     * @param time1 - Time it takes a runner to run a specific distance
     * @return - returns the difference between time2 and time1
     */
    private static String subtractTime(String time2, String time1) {
        double time2InSeconds = convertToSeconds(time2);
        double time1InSeconds = convertToSeconds(time1);
        double splitTimeSec = time2InSeconds - time1InSeconds;
        return convertToMinutes(splitTimeSec);
    }

    /**
     * convertToMinutes converts time in seconds to format showing minutes:seconds.milliseconds
     * @param seconds - the time it takes a runner to run a specific distance in seconds
     * @return - the new format showing the time minutes:seconds.milliseconds
     */
    private static String convertToMinutes(double seconds) {
        int min = (int)(seconds/60);
        double sec = seconds - min*60;
        return min+":"+sec;
    }

    /**
     * convertToSeconds converts the time format of minutes:seconds.milliseconds into a format with just seconds and milliseconds
     * @param time - the amount of time it takes for a runner to run a specific distance in minutes:seconds.milliseconds
     * @return - returns the time in seconds
     */
    private static double convertToSeconds(String time) {
        int mintosec = Integer.parseInt(time.substring(0, time.indexOf(":"))) * 60;
        double secaddminsec = Double.parseDouble(time.substring(time.indexOf(":")+1)) + mintosec;
        return secaddminsec;
    }
}
