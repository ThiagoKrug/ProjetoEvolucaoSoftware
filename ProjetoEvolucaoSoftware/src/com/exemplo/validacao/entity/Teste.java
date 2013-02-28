package com.exemplo.validacao.entity;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * Documentação do Hibernate Validator
 * http://docs.jboss.org/hibernate/validator/4.3/reference/en-US/html_single/#validator-customconstraints
 *
 */
public class Teste {

    private static Validator validator;

    public static void main(String[] args) {
        /**
         *
         * Documentação do Hibernate Validator
         * http://docs.jboss.org/hibernate/validator/4.3/reference/en-US/html_single/#validator-customconstraints
         *
         */
        //Chama classe para validar a entidade
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        //Cria entidade com valores fora da validação
        Car car = new Car(null, "DD-AB-12AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA3", 0);
        //Faz a validação e salva as violações de validação num vetor
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Car> constraintViolation : constraintViolations) {
                //System.out.println(constraintViolation);
                System.out.println("O atributo " + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
            }
        }
        System.out.println("=========== Validação para pessoa ================");
        Pessoa p = new Pessoa();
        p.setNome("");
        p.setDataNascimento(new Date(2014, 2, 2));
        p.setIdade(25);
        p.setEmail("joooose");
        p.setRg(null);
        //Faz a validação e salva as violações de validação num vetor
        Set<ConstraintViolation<Pessoa>> constraintViolations2 = validator.validate(p);
        if (constraintViolations2.size() > 0) {
            for (ConstraintViolation<Pessoa> constraintViolation : constraintViolations2) {
                //System.out.println(constraintViolation);
                System.out.println("O atributo " + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
            }
        }
    }
}
