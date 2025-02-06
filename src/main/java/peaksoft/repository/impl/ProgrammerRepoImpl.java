package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.models.Programmer;
import peaksoft.repository.CrudRepository;
import peaksoft.repository.ProgrammerRepo;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProgrammerRepoImpl implements ProgrammerRepo, CrudRepository {

    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public void saveProgrammer(Programmer programmer) {
        entityManager.getTransaction().begin();
        entityManager.persist(programmer);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Programmer> findAll() {
       return entityManager.createQuery("select p from Programmer p", Programmer.class).getResultList();
    }
}
