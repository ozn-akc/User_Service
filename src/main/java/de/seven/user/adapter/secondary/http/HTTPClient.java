package de.seven.user.adapter.secondary.http;

import de.seven.user.application.adapter.secondary.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Profile("http")
@RequiredArgsConstructor
public class HTTPClient implements ProductClient {
    private final WebClient webClient;

    @Autowired
    public HTTPClient(WebClient.Builder webClientBuilder, @Value("${search.client.http}") String baseUrl) {
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();
    }

    @Override
    public Mono<String> saveHost(String user) {
        return webClient.post()
                .uri("/host/")
                .body(BodyInserters.fromValue(user))
                .retrieve()
                .bodyToMono(String.class);
    }

    @Override
    public Mono<Void> deleteHost(String hostId) {
        return webClient.delete()
                .uri("/host/{hostId}", hostId)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
