package com.vti.entity;

public class GenericStudent<T extends Number> {
	private T id;
	private String name;

	public GenericStudent(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
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
		return "GenericStudent [id=" + id + ", name=" + name + "]";
	}

}
