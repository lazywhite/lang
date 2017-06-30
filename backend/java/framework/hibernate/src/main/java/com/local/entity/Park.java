package com.local.entity;

import java.util.Set;

/**
 * Created by white on 17/6/29.
 */
public class Park {

    private int id;
    private String loc;
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }


    public Park() {

    }

    public Park(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Park park = (Park) o;

        if (id != park.id) return false;
        if (loc != null ? !loc.equals(park.loc) : park.loc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (loc != null ? loc.hashCode() : 0);
        return result;
    }
}
