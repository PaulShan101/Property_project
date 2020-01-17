package PropertyAgents;

public class PropertyAgent {


    public static int productId = 0;
    private int id;
    private String name;
    private int phoneNumber;





    public PropertyAgent( String name, int phoneNumber) {
        this.id = productId++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return
                "  Agent Name   = " + name + '\'' +
                "  PhoneNumber   = " + phoneNumber +
                '.';
    }
}
