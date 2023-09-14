package org.jnosql.demo.se;

import jakarta.data.repository.*;
import org.eclipse.jnosql.mapping.Database;
import org.eclipse.jnosql.mapping.DatabaseType;

import java.util.Set;
import java.util.stream.Stream;

@Repository
public interface JavaDay extends PageableRepository<Developer, String> {

    Stream<Developer> findByCity(String lakeBenny);

    @Query("select * from Developer where name like @name")
    Set<Developer> cade(@Param("name") String name);
}
