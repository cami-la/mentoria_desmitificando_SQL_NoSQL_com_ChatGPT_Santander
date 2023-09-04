package dev.cami.demospringdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "draws")
public class Draw {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String description;
  @OneToOne
  private Prize prize;
  private LocalDate initialDate;
  private LocalDate finishDate;
  private Boolean active;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Candidate> candidates;
  private String winner;
}
