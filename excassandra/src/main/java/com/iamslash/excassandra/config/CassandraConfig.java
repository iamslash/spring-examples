package com.iamslash.excassandra.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
@EnableCassandraRepositories(basePackages = "com.iamslash.excassandra.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {
  private static final Log LOGGER = LogFactory.getLog(CassandraConfig.class);

  @Override
  protected String getKeyspaceName() {
    return "iamslash";
  }

  @Override
    protected String getLocalDataCenter() {
      return "dc1";
    }
}
