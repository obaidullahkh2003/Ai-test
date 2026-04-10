package com.store.integration;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PostgresContainerTest {
    @Test
    void containerStarts() {
        try (PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")) {
            postgres.start();
            assertTrue(postgres.isRunning());
        }
    }
}
