package controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import client.RickAndMortyClient;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import response.CharacterResponse;

@RestController
@RequestMapping("/webclient")
@AllArgsConstructor
public class RickAndMortyController {
	
	RickAndMortyClient rickAndMortyClient;
	
    @GetMapping("/character/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findACharacterById(id);

    }
}
