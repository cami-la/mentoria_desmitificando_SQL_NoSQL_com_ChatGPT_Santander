package dev.cami.demospringmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringMongodbApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringMongodbApplication.class, args);
  }

/*  @Bean
  CommandLineRunner runner(CandidateRepository repository, MongoTemplate mongoTemplate) {
    return args -> {
      String email = "camila@email.com";
      Candidate candidate = new Candidate("Camila", email);

      Query query = new Query();
      query.addCriteria(Criteria.where("email").is(email));
      List<Candidate> candidates = mongoTemplate.find(query, Candidate.class);
      if(candidates.size() > 1) {
        throw new IllegalStateException("Found many students with email " + email);
      }
      if(candidates.isEmpty()) {
        System.out.println("Inserting student " + candidate);
        repository.insert(candidate);
      }
    };
  }*/
}
