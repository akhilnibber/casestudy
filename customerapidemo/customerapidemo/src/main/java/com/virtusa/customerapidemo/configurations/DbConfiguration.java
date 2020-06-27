package com.virtusa.customerapidemo.configurations;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Data
@Slf4j
@EnableConfigurationProperties(VaultConfig.class)
public class DbConfiguration {
	@Value("${db_url}")
	private String url;
	@Value("${db_driver}")
	private String driverClassName;
	@Value("${db_username}")
	private String userName;
	@Value("${db_password}")
	private String password;

	//@Profile("production")
	@Bean
	public DataSource prodDataSource()
	{
		
		DataSourceBuilder builder= DataSourceBuilder.create();
		builder.url(url);
		builder.username(vaultConfiguration.getUsername());
		builder.password(vaultConfiguration.getPassword());
		builder.driverClassName(driverClassName);
		System.out.println("Production.....");
		
		 Logger logger = LoggerFactory.getLogger(DbConfiguration.class);

		    logger.info("----------------------------------------");
		    logger.info("Configuration properties");
		    logger.info("   mysql.username is {}", vaultConfiguration.getUsername());
		    logger.info("   mysql.password is {}", vaultConfiguration.getPassword());
		    logger.info("----------------------------------------");
		
		return builder.build();	
	}
	private final VaultConfig vaultConfiguration;
	public DbConfiguration(VaultConfig configuration) {
	    this.vaultConfiguration = configuration;
	  }
	

//	@Profile("development")
//	@Bean
//	public DataSource devDataSource()
//	{
//		DataSourceBuilder builder= DataSourceBuilder.create();
//		builder.url(url);
//		builder.username(userName);
//		builder.password(password);
//		builder.driverClassName(driverClassName);
//		System.out.println("Development.....");
//		return builder.build();	
//		
//	}
//	@Profile("qa")
//	@Bean
//	public DataSource qaDataSource()
//	{		
//		DataSourceBuilder builder= DataSourceBuilder.create();
//		builder.url(url);
//		builder.username(userName);
//		builder.password(password);
//		builder.driverClassName(driverClassName);
//		System.out.println("QA.....");
//		return builder.build();	
//	}

}
