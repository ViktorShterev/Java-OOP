package ExceptionsAndErrorHandling.Lab.Person;

public class InvalidPersonNameException extends Exception {

    public InvalidPersonNameException(String message) {
        super(message);
    }
}
