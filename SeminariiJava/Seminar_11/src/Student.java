public class Student {

    private String name;
    private int age;
    private String email;

    // Constructor 1: no-arg
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.email = "unknown@email.com";
    }

    // Constructor 2: name only
    public Student(String name) {
        this.name = name;
        this.age = 0;
        this.email = "unknown@email.com";
    }

    // Constructor 3: name + age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "unknown@email.com";
    }

    // Constructor 4: all fields
    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // public method
    public void sayHello() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }

    // private method
    private void secretInfo() {
        System.out.println("My secret email is: " + email);
    }

    // getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}
