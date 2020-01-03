package shop.entity;

public class User {
    private String id;
    private String name;
    private String email;
    private String PhoneNumber;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String a) {
        name = a;
    }

    public String getId() {
        return id;
    }

    public void setId(String a) {
        id = a;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String a) {
        email = a;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String a) {
        password = a;
    }
}

