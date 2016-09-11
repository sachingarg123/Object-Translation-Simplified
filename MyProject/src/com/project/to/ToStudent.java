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

public class ToStudent
{
    private String name;
    private Integer age;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param parName the name to set
     */
    public void withName(String parName)
    {
        name = parName;
    }

    /**
     * @return the age
     */
    public Integer getAge()
    {
        return age;
    }

    /**
     * @param parAge the age to set
     */
    public void withAge(Integer parAge)
    {
        age = parAge;
    }
}
