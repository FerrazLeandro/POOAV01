package classes;

public class Piloto extends Pessoa{
    String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return String.format("\nNome: %s \nCPF: %s \nMatrícula: %s", getNome(), getCpf(), getMatricula());
    }
}
