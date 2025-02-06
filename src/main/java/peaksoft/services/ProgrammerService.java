package peaksoft.services;

import peaksoft.models.Programmer;

import java.util.List;

public interface ProgrammerService {
    void save(Programmer programmer);

    List<Programmer> findAll();
}
