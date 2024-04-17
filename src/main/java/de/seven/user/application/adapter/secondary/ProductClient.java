package de.seven.user.application.adapter.secondary;

import reactor.core.publisher.Mono;

public interface ProductClient {
    Mono<String> saveHost(String user);

    void deleteHost(String hostId);
}
