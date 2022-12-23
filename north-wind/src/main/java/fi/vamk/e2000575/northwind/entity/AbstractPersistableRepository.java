package fi.vamk.e2000575.northwind.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractPersistableRepository<T extends AbstractPersistable, ID> extends JpaRepository<T, ID> {
}