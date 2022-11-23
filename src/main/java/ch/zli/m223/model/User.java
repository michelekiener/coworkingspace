package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List; 

@Entity
public class User {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean admin;

    @ManyToOne(optional = true)
    @Fetch(FetchMode.JOIN)
    private Group group;

    @OneToMany(mappedBy = "User")
    @JsonIgnoreProperties("User")
    @Fetch(FetchMode.JOIN)
    private List<Booking> bookings;


  public User(Long id, String name, String firstname, Date birthdate, String email, String password, boolean admin, Group group, List<Booking> bookings) {
    this.id = id;
    this.name = name;
    this.firstname = firstname;
    this.birthdate = birthdate;
    this.email = email;
    this.password = password;
    this.admin = admin;
    this.group = group;
    this.bookings = bookings;
  }

  public User() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public Date getBirthdate() {
    return this.birthdate;
  }

  public void setBirthdate(Date birthdate) {
    this.birthdate = birthdate;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAdmin() {
    return this.admin;
  }

  public boolean getAdmin() {
    return this.admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public Group getGroup() {
    return this.group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public List<Booking> getBookings() {
    return this.bookings;
  }

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

}
