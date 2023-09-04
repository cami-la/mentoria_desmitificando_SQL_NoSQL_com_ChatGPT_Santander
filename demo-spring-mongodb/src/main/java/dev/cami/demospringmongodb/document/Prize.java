package dev.cami.demospringmongodb.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Document(collection = "prizes")
@Getter
@Setter
@NoArgsConstructor
public class Prize {
  @Id
  private String documentId;
  private String title;
  private String urlImage;
  private String link;
}
