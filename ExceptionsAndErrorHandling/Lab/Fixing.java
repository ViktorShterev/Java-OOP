package ExceptionsAndErrorHandling.Lab;

public class Fixing {
    public static void main(String[] args) {

        String[] weekdays = new String[5];
        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";
        weekdays[4] = "Friday";

        for (int i = 0; i <= weekdays.length; i++) {
            try {
                System.out.println(weekdays[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid workday!");
                break;
            }
        }
    }
}
