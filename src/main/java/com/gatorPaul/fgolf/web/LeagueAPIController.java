package com.gatorPaul.fgolf.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gatorPaul.fgolf.data.model.League;

@RestController
public class LeagueAPIController {
	
	@GetMapping("/league/list")
	public ResponseEntity<List<League>> listLeagues() {		
		List<League> leagueList = new ArrayList<>();
		
		League l1 = new League();
		l1.setId(1234L);
		l1.setName("Test");
		leagueList.add(l1);
		
		l1 = new League();
		l1.setId(9999L);
		l1.setName("ABC");
		leagueList.add(l1);
		
		return new ResponseEntity<>(leagueList, HttpStatus.OK);
	}

}
