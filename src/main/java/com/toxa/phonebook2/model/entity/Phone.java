package com.toxa.phonebook2.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String patronymic;

    @Column(name = "phone_mobile")
    private String phoneMobile;

    @Column(name = "phone_home")
    private String phoneHome;

    @Column
    private String address;

    @Column
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Phone() {
    }

    public Phone(String name, String lastName, String patronymic, String phoneMobile, String phoneHome,
                 String address, String email, User user) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phoneMobile = phoneMobile;
        this.phoneHome = phoneHome;
        this.address = address;
        this.email = email;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Phone that = (Phone) obj;
        if(!name.equals(that.name) || !lastName.equals(that.lastName) || !patronymic.equals(that.patronymic)
                || !phoneMobile.equals(that.phoneMobile) || !phoneHome.equals(that.phoneHome) || !address.equals(that.address)
                || !email.equals(that.email))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 53 * hash + name.hashCode() + lastName.hashCode() + patronymic.hashCode() + phoneMobile.hashCode()
                + ((phoneHome == null) ? 0 : phoneHome.hashCode()) + ((address == null) ? 0 : address.hashCode())
        + ((email == null) ? 0 : email.hashCode());
        return hash;
    }

    @Override
    public String toString(){
        return "[id=" + this.id + ", name=" + this.name + ", last name=" + this.lastName + ", patronymic=" + this.patronymic
                + ", mobile phone=" + this.phoneMobile+ "]";
    }
}