package fr.hackathon.server.ws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"fr.hackathon.server.ws.repository"})
public class ContextConfiguration {

	// jvoulais tester les bdd mais je mets en pause pr le moment 
//	@Bean
//    public DataSource dataSource(){
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        // mettre les scripts si g le tps de faire mumuz ac les bdd
//        return  builder.build();
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(){
//        return new JdbcTemplate(dataSource());
//    }
}