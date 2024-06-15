package org.example.demoexams3.repositories;

import org.example.demoexams3.model.Hamster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HamsterRepository extends JpaRepository<Hamster, Long> {
}
