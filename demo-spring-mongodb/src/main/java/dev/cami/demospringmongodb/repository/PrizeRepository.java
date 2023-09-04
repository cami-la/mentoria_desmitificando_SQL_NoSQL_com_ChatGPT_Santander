package dev.cami.demospringmongodb.repository;

import dev.cami.demospringmongodb.document.Prize;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrizeRepository extends MongoRepository<Prize, String> {
}
