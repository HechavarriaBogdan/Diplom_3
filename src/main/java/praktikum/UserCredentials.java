package praktikum;

import com.github.javafaker.Faker;

public class UserCredentials {
    private String name;
    private String email;
    private String password;

    public UserCredentials(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static UserCredentials random() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        return new UserCredentials(name, email, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
