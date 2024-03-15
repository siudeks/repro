package com.example;

import org.springframework.stereotype.Component;

import com.google.protobuf.Empty;

import io.dapr.v1.AppCallbackGrpc.AppCallbackImplBase;
import io.dapr.v1.DaprAppCallbackProtos.ListTopicSubscriptionsResponse;
import io.grpc.stub.StreamObserver;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

// Purpose:
// Handle AppCallbackImplBase#listTopicSubscriptions required to dynamically register application for available topics.
// if the method is not invoked, the whole application is not able to listen to any external event
// inspiration: https://github.com/dapr/java-sdk/blob/master/examples/src/main/java/io/dapr/examples/pubsub/grpc/SubscriberGrpcService.java
@Component
@Slf4j
public class DaprCallbacks extends AppCallbackImplBase {

    @PostConstruct
    public void init() {
        log.info("init");
    }

    @Override
    public void listTopicSubscriptions(Empty request, StreamObserver<ListTopicSubscriptionsResponse> responseObserver) {
        log.info("listTopicSubscriptions");
        var response = ListTopicSubscriptionsResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}