package ch.zli.m223.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
public class Group {
  @Id
    @GeneratedValue
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "group")
    @JsonIgnoreProperties("category")
    @Fetch(FetchMode.JOIN)
    private List<User> members;


  public Group(String name, List<User> members) {
    this.name = name;
    this.members = members;
  } 
  
  public Group() {}

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

  public List<User> getMembers() {
    return this.members;
  }

  public void setMembers(List<User> members) {
    this.members = members;
  }
}
