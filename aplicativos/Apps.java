package aplicativos;

import classes.Vetor;

//Aplicação do algoritmo

public class Apps {
    public static void main(String[] args) {
    
        Vetor vetor = new Vetor(2);
    
        vetor.adicionar("b");
        vetor.adicionar("c");
        System.out.println(vetor.toString());
        System.out.println("");
    
        System.out.println(vetor.toString());
        }   
    }