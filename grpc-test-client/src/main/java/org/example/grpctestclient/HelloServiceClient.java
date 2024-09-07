package org.example.grpctestclient;

import io.grpc.StatusRuntimeException;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpctest.grpc.HelloRequest;
import org.example.grpctest.grpc.HelloResponse;
import org.example.grpctest.grpc.HelloServiceGrpc;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class HelloServiceClient {

    @GrpcClient("test")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public String sendMessage(String message) {
        try {
            HelloResponse response = helloServiceBlockingStub.sayHello(
                    HelloRequest.newBuilder()
                            .setRequest(message)
                            .build());
            return response.getResponse();
        } catch (StatusRuntimeException exception) {
            return "FAIL : " + exception.getStatus().getCode().name();
        }
    }

}
