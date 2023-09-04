package dev.cami.demospringdatajpa.repository;

import dev.cami.demospringdatajpa.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
