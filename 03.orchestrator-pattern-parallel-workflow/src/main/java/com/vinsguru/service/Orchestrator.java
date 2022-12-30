package com.vinsguru.service;

import com.vinsguru.dto.OrchestrationRequestContext;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class Orchestrator {
    public abstract Mono<OrchestrationRequestContext> create(OrchestrationRequestContext ctx);
    public abstract Predicate<OrchestrationRequestContext> isSuccess();
    public abstract Consumer<OrchestrationRequestContext> cancel();
}