package com.gatorPaul.fgolf.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(generator = "tournament_generator")
    @SequenceGenerator(
            name = "tournament_generator",
            sequenceName = "tournament_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    private String name;
    
    @ManyToOne
    @JoinColumn(name="season_id", nullable=false)
    private Season season;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
