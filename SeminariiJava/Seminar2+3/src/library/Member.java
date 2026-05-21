package library;


public class Member {

    private String name;
    private int id;

    public Member() {}

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public int getId() { return id; }


    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
