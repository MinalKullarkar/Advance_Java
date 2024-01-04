package com.jspiders.smswithspringrest2.response;

import com.jspiders.smswithspringrest2.pojo.Admin;

import lombok.Data;

@Data
public class AdminResponse {

	private String message;
	private Admin admin;
	private int Status;
}
