package sample.model;

public class User {
    private String name;
    private String phoneNumber;
    private String mail;
    private String country;
    private String password;
    private String gender;
    private String dateOfBirth;

    public User(String name, String phoneNumber, String mail, String country, String password, String gender, String dateOfBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.country = country;
        this.password = password;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", country='" + country + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", date of birth='" + dateOfBirth + '\'' +
                '}';
    }
}
