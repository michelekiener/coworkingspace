package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Booking;

@ApplicationScoped
public class BookingService {
  @Inject
    EntityManager entityManager;

    @Transactional
    public Booking createBooking(Booking booking){
        return entityManager.merge(booking);
    }

    @Transactional
    public Booking updateBooking(Long id, Booking booking){
        booking.setId(id);
        return entityManager.merge(booking);
    }

    @Transactional
    public void deleteBooking(Long id){
        var entity = entityManager.find(Booking.class, id);
        entityManager.remove(entity);
    }

    public Booking getBooking(Long id){
        return entityManager.find(Booking.class, id);
    }

    public List<Booking> findAll(){
        var query = entityManager.createQuery("FROM booking", Booking.class);
        return query.getResultList();
    }
  
}
