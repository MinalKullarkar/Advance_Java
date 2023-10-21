package com.jspiders.designpattern.structuralmain;

import com.jspiders.designpattern.structural.StudentAdaptor;
import com.jspiders.designpattern.structural.TeacherAdapter;

public class AdapterMain {

	public static void main(String[] args) {
		
		StudentAdaptor studentAdaptor=new StudentAdaptor();
		studentAdaptor.football();
		studentAdaptor.hockey();
		
		TeacherAdapter teacherAdapter=new TeacherAdapter();
		teacherAdapter.football();
		teacherAdapter.hockey();
	}
}
