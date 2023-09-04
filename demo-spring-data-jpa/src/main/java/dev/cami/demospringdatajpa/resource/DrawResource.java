package dev.cami.demospringdatajpa.resource;

import dev.cami.demospringdatajpa.entity.Draw;
import dev.cami.demospringdatajpa.service.DrawService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public ResponseEntity<Draw> findById(@PathVariable Long id) {
    Draw drawById = drawService.findById(id);
    return ResponseEntity.ok(drawById);
  }

  @PatchMapping("{drawId}/{candidateId}")
  public ResponseEntity<Draw> insertCandidate(@PathVariable Long drawId, @PathVariable Long candidateId) {
    Draw updatedDraw = drawService.insertCandidate(drawId, candidateId);
    return ResponseEntity.ok(updatedDraw);
  }

  //TODO: Method to find all draws on range with a given start date and finish date
}
