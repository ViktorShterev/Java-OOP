package ExceptionsAndErrorHandling.Lab.Person;

public class StringValidation {

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }
}
