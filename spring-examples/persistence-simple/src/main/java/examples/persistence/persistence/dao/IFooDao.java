package examples.persistence.persistence.dao;

import com.baeldung.spring.data.persistence.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface IFooDao extends JpaRepository<Foo, Long> {

    @Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
    Foo retrieveByName(@Param("name") String name);
}