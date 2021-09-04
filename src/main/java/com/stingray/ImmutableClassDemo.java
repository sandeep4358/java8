package com.stingray;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class ImmutableClassDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "first");
		map.put("2", "second");

		immutable im = new immutable(1, "AAAAA", map);

		System.out.println(im);
		map.put("3", "third");
		Map<String, String> ik = im.getMetaData();
		ik.put("4", "forth");
		System.out.println(im);

	}
}

@ToString
final class immutable {
	private int id;
	private String desc;
	private Map<String, String> map;

	public immutable(int id, String desc, Map<String, String> map) {
		super();
		this.id = id;
		this.desc = desc;
		Map<String, String> temp = new HashMap<String, String>();
		map.entrySet().stream().forEach((e) -> temp.put(e.getKey(), e.getValue()));
		this.map = temp;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public Map<String, String> getMetaData() {
		Map<String, String> temp = new HashMap<String, String>();
		map.entrySet().stream().forEach((e) -> temp.put(e.getKey(), e.getValue()));
		return temp;
	}

}

@ToString
@Data
@AllArgsConstructor
class Student {
	String studentName;
}