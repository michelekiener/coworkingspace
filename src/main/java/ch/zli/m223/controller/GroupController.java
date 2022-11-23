package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Group;
import ch.zli.m223.service.GroupService;

@Path("/groups")
@Tag(name = "Groups", description = "Handling of groups")
@RolesAllowed({"admin"})
public class GroupController {
  @Inject
    GroupService groupService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Create new Group",
        description = "Create a new Group and return the newly created entity"
    )
    public Group create(Group group){
        return groupService.createGroup(group);
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "find single group by id",
        description = "find a single group by its id and return it"
    )
    public Group find(@PathParam("id") Long id){
        return groupService.find(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Index all groups",
        description = "Returns a list of all entries "
    )
    public List<Group> index (){
        return groupService.findAll();
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Update group",
        description = "Update group with speciefied id"
    )
    public Group update(@PathParam("id") Long id, Group group){
        return groupService.updateGroup(id, group);
    }

    @Path("/{id}")
    @DELETE
    @Operation(
        summary = "deletes an existing group",
        description = "deletes an existing group with speciefied id"
    )
    public void delete(@PathParam("id") Long id){
        groupService.deleteGroup(id);
    }
}
