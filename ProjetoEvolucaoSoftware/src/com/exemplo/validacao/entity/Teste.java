/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.entity;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Rafael
 */
public class Teste {

    private static Validator validator;

    public static void main(String[] args) {
        //Chama classe para validar a entidade
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        //Cria entidade com valores fora da validação
        Car car = new Car(null, "DD-AB-12AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA3", 0);
        //Faz a validação e salva as violações de validação
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Car> constraintViolation : constraintViolations) {
                //System.out.println(constraintViolation);
                System.out.println("O atributo "+constraintViolation.getPropertyPath() +" "+ constraintViolation.getMessage());
            }
        }
    }
}
