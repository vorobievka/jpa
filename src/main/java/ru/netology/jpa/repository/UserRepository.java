package ru.netology.jpa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        String queryString = "select a from Person a " +
                "where lower(a.city_of_living) = lower(:city)";
        TypedQuery<Person> query = entityManager.createQuery(queryString, Person.class);
        query.setParameter("city", city);
        return query.getResultList();

    }

}