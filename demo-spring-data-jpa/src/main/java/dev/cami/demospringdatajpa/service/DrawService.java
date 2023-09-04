package dev.cami.demospringdatajpa.service;


import dev.cami.demospringdatajpa.entity.Candidate;
import dev.cami.demospringdatajpa.entity.Draw;
import dev.cami.demospringdatajpa.entity.Prize;
import dev.cami.demospringdatajpa.repository.DrawRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public record DrawService(
    DrawRepository drawRepository,
    PrizeService prizeService,
    CandidateService candidateService
) {
  private static final Long DATE_TO_DRAW = 5L;
  public Draw create(Draw draw) {
    Prize prizeToSave = Prize.builder()
        .title(draw.getPrize().getTitle())
        .urlImage(draw.getPrize().getUrlImage())
        .link(draw.getPrize().getLink())
        .build();
    Prize savedPrize = prizeService.create(prizeToSave);
    Draw drawToSave = Draw.builder()
        .prize(savedPrize)
        .description(draw.getDescription())
        .initialDate(LocalDate.now())
        .finishDate(LocalDate.now().plusDays(DATE_TO_DRAW))
        .active(true)
        .candidates(new ArrayList<>())
        .build();
    return drawRepository.save(drawToSave);
  }

  public Draw findById(Long id) {
    return drawRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Draw not found"));
  }
  public Draw insertCandidate(Long drawId, Long candidateId) {
    Draw draw = findById(drawId);
    Candidate candidate = candidateService.findById(candidateId);
    draw.getCandidates().add(candidate);
    return drawRepository.save(draw);
  }

  //TODO: Method to find all draws on range with a given start date and finish date

}
