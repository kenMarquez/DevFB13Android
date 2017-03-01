package com.ken.retrofit3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ken on 28/02/17.
 */

public class UserCreated {


    private String nombre;

    private String apaterno;

    private String amaterno;

    @Expose
    @SerializedName("email")
    private String email123;

    @SerializedName("is_active")
    private boolean isActive;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getEmail123() {
        return email123;
    }

    public void setEmail123(String email123) {
        this.email123 = email123;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "UserCreated{" +
                "nombre='" + nombre + '\'' +
                ", apaterno='" + apaterno + '\'' +
                ", amaterno='" + amaterno + '\'' +
                ", email123='" + email123 + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
