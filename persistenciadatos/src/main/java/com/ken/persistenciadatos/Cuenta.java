package com.ken.persistenciadatos;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Ken on 24/02/17.
 */

public class Cuenta extends RealmObject {

    private String cuenta;
    private double saldo;
    private double deuda;
    private int userKey;

    @PrimaryKey
    private int idCuenta;

    public Cuenta() {
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public int getUserKey() {
        return userKey;
    }

    public void setUserKey(int userKey) {
        this.userKey = userKey;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "cuenta='" + cuenta + '\'' +
                ", saldo=" + saldo +
                ", deuda=" + deuda +
                ", userKey=" + userKey +
                ", idCuenta=" + idCuenta +
                '}';
    }
}
