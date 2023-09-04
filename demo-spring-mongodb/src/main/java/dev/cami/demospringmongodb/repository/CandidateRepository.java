package dev.cami.demospringmongodb.repository;

import dev.cami.demospringmongodb.document.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
}
