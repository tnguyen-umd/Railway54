package TestingSystem_Assignment_5;

public class Student implements IStudent {
	int id;
	private String name;
	private int group;

	@Override
	public void diemDanh() {
		System.out.println(name + " điểm danh");

	}

	@Override
	public void hocBai() {
		// TODO Auto-generated method stub

		System.out.println(name + " hoc bai");

	}

	@Override
	public void veSinh() {
		System.out.println(name + " don ve sinh");

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public Student(int id, String name, int group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}

}
