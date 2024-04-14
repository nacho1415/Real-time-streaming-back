package com.example.realtimestreaming.Repository;

import com.example.realtimestreaming.Common.ErrorCode;
import com.example.realtimestreaming.Common.UserApplicationException;
import com.example.realtimestreaming.Domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public User findUserByUserId(Long userId) {
        try {
            User user = em.createQuery("SELECT u FROM User u WHERE u.id = :userId", User.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
            return user;
        } catch (Exception ex) {
            throw new UserApplicationException(ErrorCode.NO_MATCHING_USER_FOUND_WITH_USERID);
        }
    }

    public void save (User user) {
        em.persist(user);
    }
}
