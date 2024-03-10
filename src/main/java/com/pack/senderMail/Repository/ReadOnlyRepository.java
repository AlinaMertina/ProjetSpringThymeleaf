package com.pack.senderMail.Repository;

import org.springframework.data.repository.Repository;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> findAll(); // Correction de la méthode findAll()
    Optional<T> findById(ID id);
    long count();
}
