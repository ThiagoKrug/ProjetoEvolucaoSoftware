package com.exemplo.validacao.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car {

    /**
     * Diz que a variavel não pode ser nula
     */
    @NotNull
    private String manufacturer;

    /**
     * Diz que a variavel não pode ser nula e o tamanho tem que ser maior ou igual 2 e no maximo 14
     */
    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;
    
    /**
     * Diz que a variavel tem que ser maior ou igual 2
     */
    @Min(2)
    private int seatCount;
    
    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    
}
