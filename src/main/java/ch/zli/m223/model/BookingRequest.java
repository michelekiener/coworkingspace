package ch.zli.m223.model;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;

@Entity
public class BookingRequest {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private LocalDate localDate;

    @ManyToOne(optional = false)
    @Fetch(FetchMode.JOIN)
    private User user;


  public BookingRequest(Long id, LocalDate localDate, User user) {
    this.id = id;
    this.localDate = localDate;
    this.user = user;
  }

  public BookingRequest() {}


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getLocalDate() {
    return this.localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
