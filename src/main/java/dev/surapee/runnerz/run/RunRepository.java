package dev.surapee.runnerz.run;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface RunRepository extends ListCrudRepository<Run, Integer> {

//  If you want to write your own query
//  @Query(("select * from run where location = :location"))
    List<Run> findAllByLocation(String location);

}
