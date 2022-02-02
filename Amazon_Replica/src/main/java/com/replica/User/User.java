package com.replica.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "userData")
@Getter @Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "passwd")
    private String passwd;

    @Column(name = "fullAddress")
    private String fullAddress;

    @Column(name = "userType")
    private String userType;

    public User(String firstName, String lastName, String email, String passwd, String fullAddress, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwd = passwd;
        this.fullAddress = fullAddress;
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User [id="+id+", first name="+firstName+", last name"+lastName+", email="+email+", passwd="+passwd+", fulladdress="+fullAddress+"]";
    }
}
