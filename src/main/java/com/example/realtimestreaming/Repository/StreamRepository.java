package com.example.realtimestreaming.Repository;

import com.example.realtimestreaming.Domain.Stream;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StreamRepository {

    @PersistenceContext
    EntityManager em;

    public void save (Stream stream) {
        em.persist(stream);
    }
}
