package dev.cami.demospringdatajpa.repository;

import dev.cami.demospringdatajpa.entity.Draw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrawRepository extends JpaRepository<Draw, Long> {
  //TODO: Method to find all draws on range with a given start date and finish date

}
