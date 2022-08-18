package TestingSystem;
import java.util.Date;

public class Account {
	int			id;
	String		Email;
	Department[]	departments;//this is foreign key from Department class
	String		userName;
	String		fullName;
	Position	position;
	Date		createDate;

}
