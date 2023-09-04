package dev.cami.demospringmongodb.service;

import dev.cami.demospringmongodb.document.Prize;
import dev.cami.demospringmongodb.repository.PrizeRepository;
import org.springframework.stereotype.Service;

@Service
public record PrizeService(
    PrizeRepository prizeRepository)
{
  public Prize create(Prize document) {
    return prizeRepository.save(document);
  }

}
