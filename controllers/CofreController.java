package controllers;

import java.util.Scanner;

import exceptions.SenhaInvalidException;
import models.Cofre;

public class CofreController {
    
    Cofre cofre;
    Scanner inp = new Scanner(System.in);

    public  double retirarMontante(Double valor) throws SenhaInvalidException{
        String senhaUsuario;
        Double montante;

        System.out.println("Digite a senha do cofre");
        senhaUsuario = inp.next();

        if(!cofre.getSenha().equals(senhaUsuario))
            throw new SenhaInvalidException();

        montante = cofre.getMontante();
        cofre.setMontante(0);
        
        return montante;
    }
}