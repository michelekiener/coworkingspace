package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Group;
import ch.zli.m223.model.User;

@ApplicationScoped
public class GroupService {
  @Inject
    EntityManager entityManager;

    @Transactional
    public Group find(Long id){
        return entityManager.find(Group.class, id);
    }

    @Transactional
    public Group createGroup(Group group){
        return entityManager.merge(group);
    }

    @Transactional
    public Group updateGroup(Long id,Group group){
        group.setId(id);
        return entityManager.merge(group);
    }

    @Transactional
    public void deleteGroup(Long id){
        Group entity = entityManager.find(Group.class, id);
        for(User user : entity.getMembers()){
            entityManager.remove(user);
        }
        entityManager.remove(entity);
    }

    public List<Group> findAll(){
        var query = entityManager.createQuery("FROM Group", Group.class);
        return query.getResultList();
    }
}
