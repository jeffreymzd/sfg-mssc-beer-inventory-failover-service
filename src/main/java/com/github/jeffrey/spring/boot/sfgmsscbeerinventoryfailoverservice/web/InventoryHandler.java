package com.github.jeffrey.spring.boot.sfgmsscbeerinventoryfailoverservice.web;

import guru.sfg.brewery.model.BeerInventoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by jeffreymzd on 4/5/20
 */
@Slf4j
@Component
public class InventoryHandler {

    public Mono<ServerResponse> listInventory(ServerRequest request) {

        log.debug("listInventory is called");

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(Arrays.asList(BeerInventoryDto.builder()
                        .id(UUID.randomUUID())
                        .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                        .beerUpc("0000000000000")
                        .quantityOnHand(999)
                        .createdDate(OffsetDateTime.now())
                        .lastModifiedDate(OffsetDateTime.now())
                        .build())), List.class);
    }
}
