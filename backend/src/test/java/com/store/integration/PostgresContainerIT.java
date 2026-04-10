package com.store.integration;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PostgresContainerIT {
    @Test
    void postgresContainerStarts() {
        try (PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16")) {
            postgres.start();
            assertTrue(postgres.isRunning());
        }
    }
}
