package dev.cami.demospringdatajpa.service;


import dev.cami.demospringdatajpa.entity.Prize;
import dev.cami.demospringdatajpa.repository.PrizeRepository;
import org.springframework.stereotype.Service;

@Service
public record PrizeService(
    PrizeRepository prizeRepository)
{
  public Prize create(Prize prize) {
    return prizeRepository.save(prize);
  }

}
