package org.academiadecodigo.bootcamp.glass.model.customer;
import org.academiadecodigo.bootcamp.glass.model.products.Subscriptions;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {


    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    private String password;
    private String address;
    @Column(unique = true)
    private String phone;

    private double balance = 0;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(
            cascade = CascadeType.ALL
    )
    private Subscriptions subscriptions;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Subscriptions getProducts() {
        return subscriptions;
    }

    public void setProducts(Subscriptions subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", products=" + subscriptions +
                super.toString() +
                '}';
    }
}

