package dev.cami.demospringmongodb.resource;

import dev.cami.demospringmongodb.document.Draw;
import dev.cami.demospringmongodb.service.DrawService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/draws")
public record DrawResource(
    DrawService drawService
) {

  @PostMapping
  public ResponseEntity<Draw> create(@RequestBody Draw draw) {
    Draw savedDraw = drawService.create(draw);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedDraw);
  }

  @GetMapping("/{documentId}")
  public ResponseEntity<Draw> findById(@PathVariable String documentId) {
    Draw drawById = drawService.findById(documentId);
    return ResponseEntity.ok(drawById);
  }

  @PatchMapping("{documentIdDraw}/{documentIdCandidate}")
  public ResponseEntity<Draw> insertCandidate(@PathVariable String documentIdDraw, @PathVariable String documentIdCandidate) {
    Draw updatedDraw = drawService.insertCandidate(documentIdDraw, documentIdCandidate);
    return ResponseEntity.ok(updatedDraw);
  }

  //TODO: Method to find all draws on range with a given start date and finish date

}
