package com.example.wallet;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabet supported")
    @NotBlank(message = "firstname is mandatory")
    private String firstName;

    @Pattern(regexp = "^[A-Za-z]*$", message = "Only alphabet supported")
    @NotBlank(message = "lastname is mandatory")
    private String lastName;

    @NotBlank(message = "username is mandatory")
    private String userName;

    @Pattern(regexp = "^[0-9]*$", message = "Only number supported")
    @Size(min = 9, max = 9, message = "check the number")
    @NotBlank(message = "phone number is mandatory")
    private String phoneNumber;

    //TODO password encryption on subscribtion and login
    @Size(min = 8, message = "Password must at least have 8 characters")
    @NotBlank(message = "password is mandatory")
    private String password;

    // TODO email validation still accept uncomplete domain like @gmail without.com
    @Email(message = "Email incorrect")
    @NotBlank(message = "email is mandatory")
    private String email;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Card> cards;

    User(){}
    // public User(int id, String firstName, String lastName, String userName, String phoneNumber, String password, String email){
    //     this.id = id;
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.userName = userName;
    //     this.phoneNumber = phoneNumber;
    //     this.password = password;
    //     this.email = email;
    // }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
    
    public String getEmail() {
        return email;
    }

    public List<Card> getCards() {
        return cards;
    }

}
