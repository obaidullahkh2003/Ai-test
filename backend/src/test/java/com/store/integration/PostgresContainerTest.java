package com.store.integration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@Disabled("Enable in CI with Docker daemon")
class PostgresContainerTest {
  @Container
  static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16");

  @Test
  void containerDefinitionLoads() {
    assertTrue(postgres.getDockerImageName().contains("postgres"));
  }
}
