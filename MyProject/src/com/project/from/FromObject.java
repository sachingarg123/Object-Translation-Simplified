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
package com.project.from;

import java.util.ArrayList;

public class FromObject
{

    private int id;
    private String specification;
    private FromStudent student;
    private ArrayList<FromStudent> studentList;

    /**
     * @return the studentList
     */
    public ArrayList<FromStudent> getStudentList()
    {
        return studentList;
    }

    /**
     * @param parStudentList the studentList to set
     */
    public void setStudentList(ArrayList<FromStudent> parStudentList)
    {
        studentList = parStudentList;
    }

    public FromObject()
    {

    }

    /**
     * @return the student
     */
    public FromStudent getStudent()
    {
        return student;
    }

    /**
     * @param parStudent the student to set
     */
    public void setStudent(FromStudent parStudent)
    {
        student = parStudent;
    }

    FromObject(int id, String specification)
    {
        this.id = id;
        this.specification = specification;
    }

    public int getId()
    {
        return id;
    }

    public String getSpecification()
    {
        return specification;
    }

    /**
     * @param parId the id to set
     */
    public void setId(int parId)
    {
        id = parId;
    }

    /**
     * @param parSpecification the specification to set
     */
    public void setSpecification(String parSpecification)
    {
        specification = parSpecification;
    }

}
