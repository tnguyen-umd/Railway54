package com.vti.entity;

import TestingSystem_Assignment_5.Assignment_5_Exercise_1_Program;

public class News implements INews {
	private int id;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	private float sum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", publishDate=" + publishDate + ", author=" + author + ", content=" + content
				+ ", averageRate=" + averageRate + "]";
	}

	@Override
	public void Display() {
		System.out.println("News info: " + toString());
	}

	@Override
	public void Calculate() {
		for (int i = 0; i < Assignment_5_Exercise_1_Program.rates.size(); i++) {
			sum += Assignment_5_Exercise_1_Program.rates.get(i);
		}

		averageRate = sum / Assignment_5_Exercise_1_Program.rates.size();
		System.out.println("The average rate is " + averageRate);

	}

}

//Implement các method trong interface INews như sau:
//a) Method Display() sẽ in ra Title, PublishDate, Author, Content và AverageRate của tin tức ra console.
//b) Method có tên Calculate() để thiết đặt thuộc tính Khai báo một array có tên Rates kiểu int gồm 3 phần tử
//AverageRate là trung bình cộng của 3 phần tử của array Rates.
//c) Tạo chương trình demo có tên là MyNews và tạo một menu lựa chọn gồm các mục sau:
//1- Insert news, 2 View list news, 3 Average rate, 4 Exit

//Nếu người dùng chọn 1 từ bàn phím thì tạo một object của class News và nhập giá trị cho các thuộc tính Title, 
//PublishDate, Author, Content sau đó yêu cầu người dùng nhập vào 3 đánh giá để lưu vào Rates.
//Nếu người dùng chọn 2 từ bàn phím thì thực thi method Display().
//Nếu người dùng chọn 3 từ bàn phím thì thực hiện method Calculate() để tính đánh giá trung bình, sau đó thực thi method Display().
//Trường hợp người dùng chọn 4 thì sẽ thoát khỏi chương trình.

//Tạo một class News bao gồm thuộc tính: 
//ID (int), Title (String), PublishDate (String), Author (String), Content (String) và AverageRate (float). 
//Tạo các setter và getter cho từng thuộc tính, riêng AverageRate thì chỉ có getter.