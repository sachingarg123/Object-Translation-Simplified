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
package com.project.erricsson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.ericsson.jsonobject.MainJson;
import com.google.gson.Gson;
import com.project.from.FromObject;
import com.project.from.FromStudent;
import com.project.to.ToObject;
import com.project.to.ToStudent;

public class SampleConverterImpl
{

    static void withModelConverter(FromObject fromObj) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
        ToObject toObject = (ToObject) ModelConverterApi.translateObjectWithoutAnnotation(fromObj);
        displayData(toObject);
    }

    static void withAnnotation(FromObject fromObj) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {

        MainJson mainJson = (MainJson) readJson();
        String[] omitFilter = mainJson.getResources()[0].getOmitFilter();
        ToObject toObject = (ToObject) ModelConverterApi.translateObjectWithAnnotation(fromObj, omitFilter);
        displayData(toObject);
    }

    static Object readJson()
    {

        Gson gson = new Gson();
        MainJson mainJson = null;
        try (Reader reader = new FileReader("C:\\Sachin\\Docs\\Security\\SSO_CPM\\rule_json.json"))
        {

            // Convert JSON to Java Object
            mainJson = gson.fromJson(reader, MainJson.class);
            System.out.println(mainJson);

            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return mainJson;
    }

    static void withoutModelConverter(FromObject fromObj)
    {
        ToObject toObject = new ToObject();
        toObject.withId(fromObj.getId());
        toObject.withSpecification(fromObj.getSpecification());

        FromStudent fromStudent = fromObj.getStudent();
        ToStudent toStudent = new ToStudent();
        toStudent.withAge(fromStudent.getAge());
        toStudent.withName(fromStudent.getName());
        toObject.withStudent(toStudent);
        ArrayList<FromStudent> fromStudentList = fromObj.getStudentList();
        ArrayList<ToStudent> toStudentList = new ArrayList<ToStudent>();
        for (FromStudent fromStudentData : fromStudentList)
        {
            ToStudent toStudentData = new ToStudent();
            toStudentData.withAge(fromStudentData.getAge());
            toStudentData.withName(fromStudentData.getName());
            toStudentList.add(toStudentData);
        }
        toObject.withStudentList(toStudentList);

        displayData(toObject);
    }

    public static void main(String arg[]) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {
        withModelConverter(fromObj);
        withoutModelConverter(fromObj);
        withAnnotation(fromObj);
    }

    static FromObject fromObj = new FromObject();
    static
    {

        fromObj.setId(1);
        fromObj.setSpecification("Sachin");
        FromStudent student = new FromStudent();
        student.setName("abc");
        student.setAge(22);
        FromStudent student1 = new FromStudent();
        student1.setName("firstobj");
        student1.setAge(21);
        FromStudent student2 = new FromStudent();
        student2.setName("secondobj");
        student2.setAge(22);
        ArrayList<FromStudent> studentList = new ArrayList<FromStudent>();
        studentList.add(student1);
        studentList.add(student2);
        fromObj.setStudent(student);
        fromObj.setStudentList(studentList);
    }

    static void displayData(ToObject toObject)
    {
        System.out.println("Final OutputData: Id =  " + toObject.getId() +
                ", Specification = " + toObject.getSpecification() +
                ", StudentName =" + toObject.getStudent().getName() +
                ", Student Age = " + toObject.getStudent().getAge() +
                ",Student List Name 1 = " + toObject.getStudentList().get(0).getName() +
                ", Student List Age 1 = " + toObject.getStudentList().get(0).getAge() +
                ", Student List Name 2 = " + toObject.getStudentList().get(1).getName() +
                ", Student List Age 2 = " + toObject.getStudentList().get(1).getAge());
    }
}
