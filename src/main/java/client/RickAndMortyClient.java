package client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import response.CharacterResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpStatus;

@Service
@Slf4j
public class RickAndMortyClient {
	
    private final WebClient webClient;


    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }
    
    public Mono<CharacterResponse> findACharacterById(String id) {
    	log.info("Buscando personagem com o id [{}]", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
               .onStatus(t -> HttpStatus.BAD_REQUEST.equals(t),
                        error -> Mono.error(new RuntimeException("Check the entered parameters")))
                .bodyToMono(CharacterResponse.class);
    }

}
