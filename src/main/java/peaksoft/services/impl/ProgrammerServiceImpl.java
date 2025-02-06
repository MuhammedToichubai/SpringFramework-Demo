package peaksoft.services.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import peaksoft.models.Programmer;
import peaksoft.repository.CrudRepository;
import peaksoft.repository.ProgrammerRepo;
import peaksoft.services.ProgrammerService;

import java.util.List;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {
    private final CrudRepository crudRepository;
    private final ProgrammerRepo programmerRepo;

    public ProgrammerServiceImpl(@Qualifier("programmerRepoImpl") CrudRepository crudRepository,
                                 ProgrammerRepo programmerRepo) {
        this.crudRepository = crudRepository;
        this.programmerRepo = programmerRepo;
    }


    @Override
    public void save(Programmer programmer){
        crudRepository.saveProgrammer(programmer);
    }

    @Override
    public List<Programmer> findAll(){
        return programmerRepo.findAll();
    }

    @PostConstruct
    public void defaultSave(){
        crudRepository.saveProgrammer(new Programmer("Almaz", 27));
    }



}
