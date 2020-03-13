package com.fastandfoodius.users.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="person")
public class UserBean  {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "person_ID", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateofbirth")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateOfBirth;

    private String gender;
    private String title;
    private String phone;
    private String address;
    private String city;
    @Column(name = "postalcode")
    private String postalCode;

    @Column(name = "emailaddress")
    private String emailAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer person_ID) {
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


     public Date getDateOfBirth() {
        return dateOfBirth;
     }

     public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
      }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = email;
    }

    @Override
    public String toString() {
        return "Customer details: [Id= " + id + " - First Name= " + firstName + " - Last Name= " + lastName
                + " - Date of birth= " + " - Gender= " + gender + " - Title= " + title + " - Phone "
                + phone + " - Address= " + address + " - City= " + city + " - postalCode= " + postalCode + " - Email= "
                + emailAddress;
    }
}
