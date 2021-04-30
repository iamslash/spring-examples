package com.iamslash.exvault.api.v1;

import com.iamslash.exvault.secret.SecretService;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaultController {

    @Autowired
    private SecretService secretService;

    @GetMapping("/secret")
    public String readSecret() throws URISyntaxException {
        return secretService.readSecret();
    }
}
