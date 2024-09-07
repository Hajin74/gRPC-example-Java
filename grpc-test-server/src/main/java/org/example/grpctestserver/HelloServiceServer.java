package org.example.grpctestserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.grpctest.grpc.HelloRequest;
import org.example.grpctest.grpc.HelloResponse;
import org.example.grpctest.grpc.HelloServiceGrpc;

@GrpcService
public class HelloServiceServer extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String requestMessage = request.getRequest();

        HelloResponse response = HelloResponse.newBuilder()
                .setResponse("이 답변은 gRPC 통신을 통해 왔습니다.  " + requestMessage + "라고 보내셨죠?")
                .build();

        // 응답 전송
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
