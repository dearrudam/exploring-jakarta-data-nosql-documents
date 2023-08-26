package org.jnosql.demo.se;

import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.PageableRepository;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.Set;
import java.util.stream.Stream;

@Repository
public interface JavaDay extends PageableRepository<Developer, String> {

    Stream<Developer> findByCity(String lakeBenny);

    @Query("select * from Developer where name='Yugo Sakamoto'")
    Set<Developer> cadeYugo();
}
