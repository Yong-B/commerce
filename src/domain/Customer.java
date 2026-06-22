package domain;

public class Customer {
    private String name;
    private String email;
    private Grade grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Grade getGrade() {
        return grade;
    }
    
    // 생성자
    public Customer(String name, String email, Grade grade) {
        this.name = name;
        this.email = email;
        this.grade = grade;
    }
}
