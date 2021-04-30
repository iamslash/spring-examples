package com.iamslash.exgrpcstarter.greeter;

import com.iamslash.exgrpcstarter.GreeterGrpc;
import com.iamslash.exgrpcstarter.GreeterOuterClass;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {
  @Override
  public void sayHello(GreeterOuterClass.HelloRequest request,
                       StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
    final GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass
        .HelloReply
        .newBuilder()
        .setMessage("Hello " + request.getName());
    responseObserver.onNext(replyBuilder.build());
    responseObserver.onCompleted();
  }
}
