package dev.cami.demospringmongodb.repository;

import dev.cami.demospringmongodb.document.Draw;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DrawRepository extends MongoRepository<Draw, String> {
  //TODO: Method to find all draws on range with a given start date and finish date
}
