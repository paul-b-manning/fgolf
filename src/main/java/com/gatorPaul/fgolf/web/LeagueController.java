package com.gatorPaul.fgolf.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gatorPaul.fgolf.data.model.League;
import com.gatorPaul.fgolf.service.LeagueService;
import com.gatorPaul.fgolf.service.LeagueServiceException;

@Controller
@RequestMapping("/admin/league")
public class LeagueController {
	
	private static final Logger log = LoggerFactory.getLogger(LeagueController.class);
	
	@Autowired
	private LeagueService leagueService; 

	@GetMapping("/list")
	public String listLeagues(Model model) {		
		List<League> leagueList = leagueService.getAllLeagues();
		model.addAttribute("leagues", leagueList);
		return "leagueList";
	}
	
	@GetMapping("/createForm")
	public String createLeagueForm(Model model) {
		League league = new League();
		model.addAttribute("league", league);
		return "leagueForm";
	}
	
	@GetMapping("/updateForm")
	public String updateLeagueForm(Long id, Model model) {		
		League league = leagueService.getLeagueById(id);
		model.addAttribute("league", league);
		return "leagueList";
	}
	
	@PostMapping("/createLeague")
	public String createLeague(String name, Model model) {		
		log.info("Create League {}", name);
		League league = new League();
		league.setName(name);
		
		String nextView = "redirect:/admin/league/list";
		
		try {
			leagueService.createLeague(league);
		} catch (LeagueServiceException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("league", league);
			nextView = "leagueForm";
		}
		
		return nextView;
	}
	
	@PostMapping("/updateLeague")
	public String updateLeague(String name) {		
		
		return "leagueList";
	}
}
