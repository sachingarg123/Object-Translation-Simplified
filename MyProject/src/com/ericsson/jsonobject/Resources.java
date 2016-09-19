package com.ericsson.jsonobject;

public class Resources
{
    private String resource;

    private String[] omitFilter;

    private String[] operations;

    public String getResource()
    {
        return resource;
    }

    public void setResource(String resource)
    {
        this.resource = resource;
    }

    public String[] getOmitFilter()
    {
        return omitFilter;
    }

    public void setOmitFilter(String[] omitFilter)
    {
        this.omitFilter = omitFilter;
    }

    public String[] getOperations()
    {
        return operations;
    }

    public void setOperations(String[] operations)
    {
        this.operations = operations;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [resource = " + resource + ", omitFilter = " + omitFilter + ", operations = " + operations + "]";
    }
}
