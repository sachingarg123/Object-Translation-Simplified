//**********************************************************************
// Copyright (c) 2016 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package com.project.to;

import java.util.ArrayList;

public class ToObject
{

    private Integer id;
    private String specification;
    private ToStudent student;
    private ArrayList<ToStudent> studentList;

    /**
     * @return the studentList
     */
    public ArrayList<ToStudent> getStudentList()
    {
        return studentList;
    }

    /**
     * @param parStudentList the studentList to set
     */
    public void withStudentList(ArrayList<ToStudent> parStudentList)
    {
        studentList = parStudentList;
    }

    /**
     * @return the student
     */
    public ToStudent getStudent()
    {
        return student;
    }

    /**
     * @param parStudent the student to set
     */
    public void withStudent(ToStudent parStudent)
    {
        student = parStudent;
    }

    public void withId(Integer id)
    {
        this.id = id;
    }

    public void withSpecification(String specification)
    {
        this.specification = specification;
    }

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @return the specification
     */
    public String getSpecification()
    {
        return specification;
    }

}
