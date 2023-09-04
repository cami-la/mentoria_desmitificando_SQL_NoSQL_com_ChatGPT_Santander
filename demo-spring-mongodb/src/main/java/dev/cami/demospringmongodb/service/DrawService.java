package dev.cami.demospringmongodb.service;

import dev.cami.demospringmongodb.document.Candidate;
import dev.cami.demospringmongodb.document.Draw;
import dev.cami.demospringmongodb.document.Prize;
import dev.cami.demospringmongodb.repository.DrawRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public record DrawService(
    DrawRepository drawRepository,
    PrizeService prizeService,
    CandidateService candidateService
) {
  private static final Long DATE_TO_DRAW = 5L;
  public Draw create(Draw document) {
    Prize prize = Prize.builder()
        .title(document.getPrize().getTitle())
        .urlImage(document.getPrize().getUrlImage())
        .link(document.getPrize().getLink())
        .build();
    Prize savedPrize = prizeService.create(prize);
    Draw draw = Draw.builder()
        .prize(savedPrize)
        .description(document.getDescription())
        .initialDate(LocalDate.now())
        .finishDate(LocalDate.now().plusDays(DATE_TO_DRAW))
        .active(true)
        .candidates(new ArrayList<>())
        .build();
    return drawRepository.save(draw);
  }

  public Draw findById(String documentId) {
    return drawRepository.findById(documentId)
        .orElseThrow(() -> new NoSuchElementException("Draw not found"));
  }
  public Draw insertCandidate(String documentIdDraw, String documentIdCandidate) {
    Draw draw = findById(documentIdDraw);
    Candidate candidate = candidateService.findById(documentIdCandidate);
    draw.getCandidates().add(candidate);
    return drawRepository.save(draw);
  }

  //TODO: Method to find all draws on range with a given start date and finish date

}
