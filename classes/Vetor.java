package classes;

//Desenvolvimento do Algoritmo

public class Vetor {

    String[] elementos;
    int tamanho;

    //construtor força a informar o tamanho do vetor na aplicação
    public Vetor(int capacidade) {
    
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }
    //método que será chamado pelo objeto na aplicação para adicionar caracteres
    
    public void adicionar(String caracteres) {
        aumentaCapacidade();//aqui eu chamei o meu método aumentar capacidade para ele verificar as condições que foram impostas se são atendidas ou não.
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = caracteres;
            this.tamanho++;
        }
    }
    
    //aumenta a capacidade do vetor, copiando os valores existentes para um novo vetor,
    //depois aumentando o tamanho do vetor anterior antes de devolver os valores
    
    public void aumentaCapacidade() {
    
        if (this.tamanho == this.elementos.length) {
            String[] elementosNovos = new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
    //exibe na aplicação o resultado
    
    @Override
    public String toString() {
    
       for (int i = 0; i < this.tamanho; i++) {
            System.out.print("Posição :" + i);
            System.out.print(" ");
            System.out.println("Elemento :" + this.elementos[i]);
        }
        return "";
    }
    }