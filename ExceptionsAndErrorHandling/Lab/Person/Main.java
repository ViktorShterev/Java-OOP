package ExceptionsAndErrorHandling.Lab.Person;

public class Main {
    public static void main(String[] args) {

        try {
            Person person3 = new Person("First name", "Last name", 14);
            Student student = new Student("4avdar", "gmail.com");

        } catch (IllegalArgumentException | InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }
}
