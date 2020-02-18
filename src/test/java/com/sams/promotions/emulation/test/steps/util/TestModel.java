package com.sams.promotions.emulation.test.steps.util;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="testModel")
public class TestModel {
	private final String name;

	public TestModel() {
		this.name = null;
	}

	public TestModel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof TestModel &&
				obj != null && Objects.equals(((TestModel)obj).name, name);
	}
}