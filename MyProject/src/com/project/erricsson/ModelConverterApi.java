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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * API for converting data model from one set to another
 */
public class ModelConverterApi
{
    public static Object translateObject(Object inputObj) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
    {

        if (inputObj == null)
        {
            return null;
        }
        switch (inputObj.getClass().getSimpleName())
        {
            case "String":
            case "Bytes":
            case "Integer":
            case "Long":
            case "Float":
            case "Double":
            case "Boolean":
                return inputObj;
            case "ArrayList":
                Method sizeMethod = inputObj.getClass().getDeclaredMethod("size");
                Method getMethod = inputObj.getClass().getDeclaredMethod("get", int.class);
                int size = (int) sizeMethod.invoke(inputObj);
                ArrayList<Object> myList = new ArrayList<>();
                for (int i = 0; i < size; i++)
                {
                    Object obj = getMethod.invoke(inputObj, i);
                    Object myObj = translateObject(obj);
                    myList.add(myObj);
                }
                return myList;
            default:

                String alianClassName = inputObj.getClass().getSimpleName();
                String myClassName = "com.project.to." + alianClassName.replace("From", "To");
                Class<?> toclass = Class.forName(myClassName);
                Object toObject = null;
                try
                {
                    toObject = toclass.newInstance();
                }
                catch (InstantiationException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Method[] methods = inputObj.getClass().getDeclaredMethods();
                for (Method method : methods)
                {
                    if (method.getName().startsWith("get"))
                    {
                        Object obj = translateObject(method.invoke(inputObj));
                        if (obj != null)
                        {
                            String myMethodName = method.getName().replace("get", "with");
                            Method builderMethod = toclass.getDeclaredMethod(myMethodName, obj.getClass());
                            if (builderMethod != null)
                            {
                                builderMethod.invoke(toObject, obj);
                            }
                        }
                    }
                }
                return toObject;
        }

    }

}
