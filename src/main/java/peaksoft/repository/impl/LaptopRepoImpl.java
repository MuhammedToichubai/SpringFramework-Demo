package peaksoft.repository.impl;

import org.springframework.stereotype.Repository;
import peaksoft.models.Programmer;
import peaksoft.repository.CrudRepository;
import peaksoft.repository.LaptopRepo;

@Repository
public class LaptopRepoImpl implements LaptopRepo, CrudRepository{

    @Override
    public void saveProgrammer(Programmer programmer) {

    }
}
