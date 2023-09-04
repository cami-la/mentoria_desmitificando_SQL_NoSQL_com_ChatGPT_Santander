package dev.cami.demospringdatajpa.service;

import dev.cami.demospringdatajpa.entity.Candidate;
import dev.cami.demospringdatajpa.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public record CandidateService(
    CandidateRepository candidateRepository
) {
  public Candidate create(Candidate candidate) {
    return candidateRepository.save(candidate);
  }

  public Candidate findById(long id) {
    return candidateRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Candidate not found"));
  }
}
