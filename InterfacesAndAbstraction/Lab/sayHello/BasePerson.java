package InterfacesAndAbstraction.Lab.sayHello;

public abstract class BasePerson implements Person {

    private String name;

    public BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
