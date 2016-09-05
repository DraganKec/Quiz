package org.kecmen.quiz.model;

import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int categoryid;

	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Question> question;

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
