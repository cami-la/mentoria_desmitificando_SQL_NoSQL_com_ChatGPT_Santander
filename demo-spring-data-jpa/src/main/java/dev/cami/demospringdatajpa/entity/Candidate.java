package dev.cami.demospringdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "candidates")
public class Candidate {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @Column(unique = true)
  private String email;
}
