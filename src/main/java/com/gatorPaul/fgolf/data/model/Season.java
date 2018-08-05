package com.gatorPaul.fgolf.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(generator = "season_generator")
    @SequenceGenerator(
            name = "season_generator",
            sequenceName = "season_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    private String name;
    
    @Min(value=2000)
    @Max(value=9999)
    private int year;
    
    @ManyToOne
    @JoinColumn(name="league_id", nullable=false)
    private League league;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

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
