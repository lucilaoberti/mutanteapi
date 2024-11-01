package com.example.mutantapi.repositories;

import com.example.mutantapi.domain.entities.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HumanRepository extends JpaRepository<Human,Long> {
   Optional<Human> findByDna(String [] dna);
   long countByIsMutant(boolean isMutant);
}
