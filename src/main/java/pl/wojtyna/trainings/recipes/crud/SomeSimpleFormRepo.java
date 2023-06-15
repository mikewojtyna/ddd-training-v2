package pl.wojtyna.trainings.recipes.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "forms", path = "forms")
public interface SomeSimpleFormRepo extends JpaRepository<SomeSimpleForm, Long> {
}
