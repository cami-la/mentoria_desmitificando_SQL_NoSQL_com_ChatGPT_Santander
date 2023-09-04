package dev.cami.demospringmongodb.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Builder
@Document(collection = "draws")
@Getter
@Setter
@NoArgsConstructor
public class Draw {
  @Id
  private String id;
  private String description;
  private Prize prize;
  private LocalDate initialDate;
  private LocalDate finishDate;
  private Boolean active;
  private List<Candidate> candidates;
  private String winner;
}
