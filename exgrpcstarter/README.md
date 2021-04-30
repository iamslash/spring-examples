# Abstract

This is an example of io.github.lognet:grpc-spring-boot-starter.

# Materials

* [grpc-spring-boot-starter @ github](https://github.com/LogNet/grpc-spring-boot-starter)

# How to test grpc

* Set configurations

```yaml
grpc:
  port: 6565
  enableReflection: true
```

* Install grpcurl
  * [grpcurl](https://github.com/fullstorydev/grpcurl)
* grpc.enableReflection should be true

```bash
$ brew install grpcurl

$ grpcurl -plaintext localhost:6565 list Greeter
Greeter.SayAuthHello
Greeter.SayHello

$ grpcurl -plaintext localhost:6565 describe Greeter.SayHello
Greeter.SayHello is a method:
rpc SayHello ( .HelloRequest ) returns ( .HelloReply );

$ grpcurl -emit-defaults -plaintext localhost:6565 \
    Greeter.SayHello
{
  "message": "Hello "
}

$ grpcurl -emit-defaults -plaintext \
    -d '{"name":"iamslash"}' \
    localhost:6565 Greeter.SayHello
{
  "message": "Hello iamslash"
}
```
