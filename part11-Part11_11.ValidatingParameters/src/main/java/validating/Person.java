package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) throws IllegalArgumentException {
        if (name==null||name.isBlank()||name.length() > 40||
                age < 0 || age > 120) {//validates input
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
