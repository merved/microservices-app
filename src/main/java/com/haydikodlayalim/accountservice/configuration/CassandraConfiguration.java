package com.haydikodlayalim.accountservice.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.*;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@EnableReactiveCassandraRepositories
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {
    //oto konfigürasyon şeklinde çalıştıgı için keyspacename i istiyor.Çünkü keysapce i bilmez. implement ederiz
    //implement ederek keyspace i vermemiz gerekiyor
    // bu keyspace name de application.properties içerisinde bulundurucaz

    @Value("${spcloud.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${spcloud.cassandra.port}")
    private int port;

    @Value("${spcloud.cassandra.contact.point}")
    private String contactPoint;

    @Value("${spcloud.cassandra.username}")
    private String username;

    @Value("${spcloud.cassandra.password}")
    private String password;


    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.haydikodlayalim.accountservice"};
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean =super.cluster();
        clusterFactoryBean.setPassword(password);
        clusterFactoryBean.setUsername(username);
        return  clusterFactoryBean;
    }
}