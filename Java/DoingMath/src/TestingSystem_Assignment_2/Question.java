package TestingSystem_Assignment_2;

import java.time.LocalDate;

public class Question {
	private int id;
	private String content;
	private TypeName isQuestionType;
	private String category;
	private Account account;
	private LocalDate createDate;

	// constructors

	// getters and setters
	public int getId() {
		return id;
	}

	public Question(int id, String content, TypeName isQuestionType, String category, Account account,
			LocalDate createDate) {
		this.id = id;
		this.content = content;
		this.isQuestionType = isQuestionType;
		this.category = category;
		this.account = account;
		this.createDate = createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TypeName getIsQuestionType() {
		return isQuestionType;
	}

	public void setIsQuestionType(TypeName isQuestionType) {
		this.isQuestionType = isQuestionType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

}
