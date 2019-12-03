package models;

public class User {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String lastname;
    private String university;
    private String role;
    private String group;
    private String avatarPath;

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password,String name, String surname, String lastname,String university, String role, String group) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.university = university;
        this.role = role;
        this.group = group;
    }
    public User(String email, String password,String name, String surname, String lastname,String university, String role, String group,String avatarPath ) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.university = university;
        this.role = role;
        this.group = group;
        this.avatarPath = avatarPath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", university='" + university + '\'' +
                ", role='" + role + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
