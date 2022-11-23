package ch.zli.m223.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Booking {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private User user;


  public Booking(Long id, Date date, User user) {
    this.id = id;
    this.date = date;
    this.user = user;
  }

  public Booking() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
