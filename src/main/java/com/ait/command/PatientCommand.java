package com.ait.command;

import lombok.Data;

@Data
public class PatientCommand {
	private String patName;
	private Integer age;
	private String location;
	private String hospital;
}
