package dev.cami.demospringmongodb.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class Candidate {
  @Id
  private String documentId;
  private String name;
  @Indexed(unique = true)
  private String email;
}
