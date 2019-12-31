package com.gatorPaul.fgolf.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "leagues")
public class League {
    @Id
    @GeneratedValue(generator = "league_generator")
    @SequenceGenerator(
            name = "league_generator",
            sequenceName = "league_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotBlank
    @Size(min = 8, max = 100)
    private String name;

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

	@Override
	public String toString() {
		return "League [id=" + id + ", name=" + name + "]";
	}
	
	
}
