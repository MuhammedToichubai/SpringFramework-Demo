package peaksoft.repository;

import peaksoft.models.Programmer;

public interface CrudRepository {
    void saveProgrammer(Programmer programmer);
}
