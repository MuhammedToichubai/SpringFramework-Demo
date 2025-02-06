package peaksoft.repository;

import peaksoft.models.Programmer;

import java.util.List;

public interface ProgrammerRepo {
    List<Programmer> findAll();
}
