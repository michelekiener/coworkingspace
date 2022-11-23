package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.User;

@ApplicationScoped
public class UserService {
  @Inject
  EntityManager entityManager;

  @Transactional
  public User createUser(User user) {
      // if(user.getBirthdate().isBefore(LocalDate.of(2003, 11, 2))){
      // user.setAdmin(false);
      // return entityManager.merge(user);
      // }else{
      //     return user;
      // }
      return entityManager.merge(user);

  }

  @Transactional
  public void deleteUser(Long id){
      var entity = entityManager.find(User.class, id);
      entityManager.remove(entity);
  }

  @Transactional
  public User updateUser(Long id, User user){
      user.setId(id);
      return entityManager.merge(user);
  }

  public User getUser(Long id){
      return entityManager.find(User.class, id);
  }

  public List<User> findAll(){
      var query = entityManager.createQuery("FROM User", User.class);
      return query.getResultList();
  }
}
