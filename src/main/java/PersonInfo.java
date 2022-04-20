public class PersonInfo {
    private final String city;
    private final String firstName;
    private final String lastName;
    private final String pesel;

    public PersonInfo(String city, String firstName, String lastName, String pesel) {
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }
}
