package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class SessionService {
  @Inject
  UserService userService;

  public Response authenticate(){};

  
}
