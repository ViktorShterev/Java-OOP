package ExceptionsAndErrorHandling.Lab.Person;

public class Student {

    private String name;
    private String email;

    public Student(String name, String email) throws InvalidPersonNameException {
        this.setName(name);
        this.email = email;
    }

    private void setName(String name) throws InvalidPersonNameException {
        for (int i = 0; i < name.length(); i++) {
            char current = name.charAt(i);
            if (Character.isLetter(current)) {
               this.name = name;
            } else {
                throw new InvalidPersonNameException("Invalid character in name!");
            }
        }
    }
}
