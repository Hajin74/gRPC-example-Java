package org.example.grpctestclient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloServiceClient helloServiceClient;

    @GetMapping("/grpc/send")
    public String grpcSend(@RequestParam String message) {
        return helloServiceClient.sendMessage(message);
    }
}
