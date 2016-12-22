package com.example;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.example.dao.TeamDao;
import com.example.domain.Player;
import com.example.domain.Team;

@SpringBootApplication
public class MicroservicesBootApplication extends SpringBootServletInitializer {

	/**
	 * Used when run as JAR
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBootApplication.class, args);
	}

	/**
	 * Used when run as WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroservicesBootApplication.class);
	}

	@PostConstruct
	public void init() {
		Set<Player> players = new HashSet<>();
		players.add(new Player("Maldini", "Center Back"));
		players.add(new Player("Del Piero", "Forward"));
		players.add(new Player("Pirlo", "Forward"));

		Team team = new Team("Italy", "Italy Football Team", players);
		teamDao.save(team);
	}

	@Autowired
	TeamDao teamDao;

}
