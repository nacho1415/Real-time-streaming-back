package com.example.realtimestreaming.Repository;

import com.example.realtimestreaming.Domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public void save (User user) {
        em.persist(user);
    }
}
