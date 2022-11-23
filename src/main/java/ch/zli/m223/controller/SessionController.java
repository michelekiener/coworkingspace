package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Login;
import ch.zli.m223.service.SessionService;

@Path("/sessions")
@Tag(name = "Session", description = "Handling of sessions")
@PermitAll
public class SessionController {
  @Inject
  SessionService sessionService;

  @POST
  @Operation(summary = "Authenticate a user.", description = "Returns a token upon successful authentication")
  public Response create(Login login) {
    return this.sessionService.authenticate(login);
  }
  
}
