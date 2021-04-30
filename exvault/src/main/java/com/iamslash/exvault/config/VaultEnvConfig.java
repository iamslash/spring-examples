package com.iamslash.exvault.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.vault.config.EnvironmentVaultConfiguration;

@Configuration
@PropertySource(value = { "application.properties" })
@Import(value = EnvironmentVaultConfiguration.class)
public class VaultEnvConfig {

}