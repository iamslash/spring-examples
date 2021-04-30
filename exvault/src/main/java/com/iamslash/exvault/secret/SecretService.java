package com.iamslash.exvault.secret;

import java.net.URISyntaxException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;

@Service
public class SecretService {
    private final String SECRET_PATH = "secret/data/hello";

    @Autowired
    private VaultTemplate vaultTemplate;

    public void secureSecret(Secret credentials) throws URISyntaxException {

        vaultTemplate.write(SECRET_PATH, credentials);
    }

    public Secret accessSecret() throws URISyntaxException {

        VaultResponseSupport<Secret> response = vaultTemplate.read(SECRET_PATH, Secret.class);
        return response.getData();
    }

    public String readSecret() {
        VaultResponse vaultResponse = vaultTemplate.read(SECRET_PATH);
        String mapAsString = vaultResponse.getData().keySet().stream()
                .map(key -> key + "=" + vaultResponse.getData().get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

}
