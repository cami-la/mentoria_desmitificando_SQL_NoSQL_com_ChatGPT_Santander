package dev.cami.demospringdatajpa.repository;

import dev.cami.demospringdatajpa.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrizeRepository extends JpaRepository<Prize, Long> {
}
