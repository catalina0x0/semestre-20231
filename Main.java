import aula2402.Elevador;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Criando um elevador
        Elevador elevador1 = new Elevador(1, 5, 0, 0, 10, 0);

        // Recebendo passageiros
        elevador1.receberPassageiros(3);

        // Movendo o elevador para cima
        elevador1.movimentarAndar(3, "subir");

        // Despachando passageiros
        elevador1.despacharPassageiros(2);

        // Movendo a porta do elevador
        elevador1.movimentarPorta("aberta");

        // Criando outro elevador
        Elevador elevador2 = new Elevador(2, 10, 0, 0, 10, 0);

        // Teste para receber passageiros com porta fechada
        elevador2.receberPassageiros(12);

        // Teste para despachar passageiros com quantidade maior que a atual
        elevador2.despacharPassageiros(5);

        // Teste para movimentar andar acima do máximo
        elevador2.movimentarAndar(12, "subir");

        // Teste para movimentar andar abaixo do mínimo
        elevador2.movimentarAndar(1, "descer");

        // Teste para movimentar porta sem especificar se é para abrir ou fechar
        elevador2.movimentarPorta("");

        // Teste para movimentar porta com comando inválido
        elevador2.movimentarPorta("invalido");
    }
}