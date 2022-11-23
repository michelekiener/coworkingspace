package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Booking;
import ch.zli.m223.service.BookingService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/bookings")
@Tag(name = "Bookings", description = "Handling of Bookings")
public class BookingController {
  @Inject
    BookingService bookingService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"user", "admin"})
    @Operation(
        summary = "Creates new booking",
        description = "Creates a new booking and returns the newly added booking"
    )
    public Booking create(Booking booking){
        return bookingService.createBooking(booking);
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"user", "admin"})
    @Operation(
        summary = "find booking by id",
        description = "find a booking by its id and return it"
    )
    public Booking find(@PathParam("id")Long id){
        return bookingService.getBooking(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"admin"})
    @Operation(
        summary = "index all bookings",
        description = "returns a list of all bookings"
    )
    public List<Booking> index(){
        return bookingService.findAll();
    }

    @Path("/{id}")
    @DELETE
    @RolesAllowed({"user", "admin"})
    @Operation(
        summary = "Deletes a booking",
        description = "deletes a booking by its id"
    )
    public void delete(@PathParam("id") Long id){
        bookingService.deleteBooking(id);
    }

    @Path("/{id}")
    @PUT
    @RolesAllowed({"user", "admin"})
    @Operation(
        summary = "updates a booking",
        description = "Updates a booking by its id and returns new version"
    )
    public Booking update(@PathParam("id") Long id, Booking booking){
        return bookingService.updateBooking(id, booking);
    }
  
}
