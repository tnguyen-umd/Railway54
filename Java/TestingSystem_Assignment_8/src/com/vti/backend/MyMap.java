package com.vti.backend;

public class MyMap<K, V> {

//	 * Question 6: K & V generic
//	 * 
//	 * Tạo 1 class có tên là MyMap, lưu dữ liệu theo dạng key, value Tạo các method
//	 * a) GetValue() b) getKey () Viết chương trình demo: tạo 1 object Student có
//	 * key là Mã sinh viên và value là tên của sinh viên đó

	// ==========================================================NEED WORK ON

	private K key;
	private V value;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValueV() {
		return value;
	}

	public void setValueV(V value) {
		this.value = value;
	}

	public MyMap(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyMap [key=" + key + ", value=" + value + "]";
	}

}

/*
 * 
 * 
 * Question 7: K & V generic Tạo 1 class có tên là Phone, lưu dữ liệu theo dạng
 * key, value (extends MyMap) Với key là email hoặc là số thứ tự hoặc là tên
 * người sử dụng Với value là số điện thoại Tạo các method
 * 
 * a) GetPhoneNumber()
 * 
 * b) getKey ()
 * 
 * Viết chương trình demo với
 * 
 * a) key là email
 * 
 * b) key là số thứ tự
 * 
 * 
 * c) key là tên của người sử dụng
 * 
 * Question 8: K & V generic Tạo 1 class có tên là Staff, lưu dữ liệu theo dạng
 * key, value (extends MyMap) Với key là id của Staff (ID có thể là int, long)
 * Với value là tên của Staff Tạo các method a) GetId () b) getName () Viết
 * chương trình demo 4
 */