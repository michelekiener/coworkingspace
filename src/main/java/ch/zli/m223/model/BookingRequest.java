package ch.zli.m223.model;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;

@Entity
public class BookingRequest {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private User user;


  public BookingRequest(Long id, Date date, User user) {
    this.id = id;
    this.date = date;
    this.user = user;
  }

  public BookingRequest() {}


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
