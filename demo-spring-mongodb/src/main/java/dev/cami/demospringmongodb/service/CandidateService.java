package dev.cami.demospringmongodb.service;

import dev.cami.demospringmongodb.document.Candidate;
import dev.cami.demospringmongodb.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public record CandidateService(
    CandidateRepository candidateRepository)
{
  public Candidate create(Candidate candidate) {
    return candidateRepository.save(candidate);
  }

  public Candidate findById(String id) {
    return candidateRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Candidate not found"));
  }
}
