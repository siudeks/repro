package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

// Used only to register DaprApplication
@Component
@RequiredArgsConstructor
class GrpcServer implements AutoCloseable {

  @Value("${APP_PORT}")
  private int appPort;

  private final DaprCallbacks daprCallbacks;
  private Server server;

  @PostConstruct
  @SneakyThrows
  public void start() {
    var builder = ServerBuilder.forPort(appPort);
    builder.addService(daprCallbacks);
    server = builder
        .build();
    server.start();
  }

  @Override
  public void close() throws Exception {
    server.shutdownNow();
    server.awaitTermination();
  }

}
