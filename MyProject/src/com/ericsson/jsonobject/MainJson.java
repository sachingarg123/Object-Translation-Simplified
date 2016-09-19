package com.ericsson.jsonobject;

public class MainJson
{
    private String id;

    private Resources[] resources;

    private String role;

    private String profile;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Resources[] getResources()
    {
        return resources;
    }

    public void setResources(Resources[] resources)
    {
        this.resources = resources;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        this.profile = profile;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = " + id + ", resources = " + resources + ", role = " + role + ", profile = " + profile + "]";
    }
}
