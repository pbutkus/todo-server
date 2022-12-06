package com.pbutkus.todoserver.repositories;

import com.pbutkus.todoserver.models.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TODORepository extends JpaRepository<TODO, UUID> {

    Optional<TODO> findById(UUID id);

    List<TODO> findAll();

    List<TODO> findAllByOrderByCreatedDesc();

}