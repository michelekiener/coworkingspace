package ch.zli.m223.model;

import io.smallrye.common.constraint.NotNull;

public class Login {

  @NotNull
  private String email;

  @NotNull
  private String password;

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
}
