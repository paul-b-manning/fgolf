package com.gatorPaul.fgolf.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gatorPaul.fgolf.data.model.League;
import com.gatorPaul.fgolf.data.model.LeagueRepository;

@Service
public class LeagueService {

	private static final Logger log = LoggerFactory.getLogger(LeagueService.class);

	@Autowired
	private LeagueRepository leagueRepository;

	public List<League> getAllLeagues() {
		List<League> result = new ArrayList<>();
		result = leagueRepository.findAll();
		return result;
	}

	public League getLeagueById(Long id) {
		League result = leagueRepository.getOne(id);
		return result;
	}

	public void createLeague(League league) throws LeagueServiceException {
		try {
			leagueRepository.save(league);
		} catch (Exception e) {
			log.error("Error occurred during League creation. {} ", league, e);
			throw new LeagueServiceException(LeagueServiceException.ERROR_SAVE_GENERAL, league, e);
		}
	}
}
