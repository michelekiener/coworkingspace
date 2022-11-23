package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.BookingRequest;

@ApplicationScoped
public class BookingRequestService {
  @Inject
    EntityManager entityManager;

    @Transactional
    public BookingRequest createBookingRequest(BookingRequest bookingRequest){
        return entityManager.merge(bookingRequest);
    }

    @Transactional
    public BookingRequest updateBookingRequest(Long id, BookingRequest bookingRequest){
        bookingRequest.setId(id);
        return entityManager.merge(bookingRequest);
    }

    @Transactional
    public void deleteBookingRequest(Long id){
        var entity = entityManager.find(BookingRequest.class, id);
        entityManager.remove(entity);
    }

    public BookingRequest getBookingRequest(Long id){
        return entityManager.find(BookingRequest.class, id);
    }

    public List<BookingRequest> findAll(){
        var query = entityManager.createQuery("FROM BookingRequest", BookingRequest.class);
        return query.getResultList();
    }
}
