package aula2402;

import java.util.Objects;

public class Elevador {
    private int id, qtdeMaximaPessoas, qtdAtualPessoas, andarAtual, andarMaximo, andarMinimo;
    private String estadoPorta;

    public Elevador(int id, int qtdeMaximaPessoas, int qtdAtualPessoas, int andarAtual, int andarMaximo, int andarMinimo) {
        this.id = id;
        this.qtdeMaximaPessoas = qtdeMaximaPessoas;
        this.andarAtual = andarMinimo;
        this.andarMaximo = andarMaximo;
        this.andarMinimo = andarMinimo;
        this.estadoPorta = "fechada";
    }

    public Elevador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtdeMaximaPessoas() {
        return qtdeMaximaPessoas;
    }

    public void setQtdeMaximaPessoas(int qtdeMaximaPessoas) {
        this.qtdeMaximaPessoas = qtdeMaximaPessoas;
    }

    public int getQtdAtualPessoas() {
        return qtdAtualPessoas;
    }

    public void setQtdAtualPessoas(int qtdAtualPessoas) {
        this.qtdAtualPessoas = qtdAtualPessoas;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getAndarMaximo() {
        return andarMaximo;
    }

    public void setAndarMaximo(int andarMaximo) {
        this.andarMaximo = andarMaximo;
    }

    public int getAndarMinimo() {
        return andarMinimo;
    }

    public void setAndarMinimo(int andarMinimo) {
        this.andarMinimo = andarMinimo;
    }

    public String getEstadoPorta() {
        return estadoPorta;
    }

    public void abrirPorta() {
        this.estadoPorta = "aberta";
    }

    public void fecharPorta() {
        this.estadoPorta = "fechada";
    }

    public String log(int id, String acao, int andar) {
        return ("Elevador " + id + " vai " + acao + " para o andar " + andar);
    }

    public String log(int id, String acao) {
        return("Elevador " + id + " está com a porta " + acao);
    }

    //receberPessoa
    public void receberPassageiros(int qtdePessoa){
        if (this.qtdAtualPessoas + qtdePessoa > this.qtdeMaximaPessoas) {
            System.out.println("Quantidade máxima de passageiro excedida.");
        } else if (this.estadoPorta.equals("aberta")) {
            System.out.println("Abra a porta!");
        } else {
            this.qtdAtualPessoas += qtdePessoa;
            this.fecharPorta();
        }
    }

    //despacharPessoa
    public void despacharPassageiros(int qtdePessoa){
        if (this.qtdAtualPessoas - qtdePessoa < 0) {
            System.out.println("Quantidade inválida de passageiros (menor que 0).");
        } else {
            this.qtdAtualPessoas -= qtdePessoa;
        }
    }

    //movimentarAndar
    public void movimentarAndar(int andar, String acao){
        if (this.estadoPorta.equals("aberta")) {
            System.out.println("Elevador com porta aberta! Feche a porta primeiro.");
        } else if (acao.equals("subir") && this.andarAtual + andar > this.andarMaximo) {
            System.out.println("Andar inválido! Quantidade máxima de andares atingida.");
        } else if (acao.equals("descer") && this.andarAtual - andar < this.andarMinimo) {
            System.out.println("Andar inválido! Quantidade mínima de andares atingida.");
        } else {
            this.andarAtual += andar;
            System.out.println(this.log(this.id, acao, andar));
        }
    }

    //movimentarPorta
    public void movimentarPorta(String acao) {
        if (acao == null || acao.trim().isEmpty()) {
            System.out.println("Estado de porta inválido!");
            return;
        }
        String acaoFormatada = acao.toLowerCase().trim();
        if (!acaoFormatada.equals("abrir") && !acaoFormatada.equals("fechar")) {
            System.out.println("Estado de porta inválido! Informe 'abrir' ou 'fechar'.");
            return;
        }
        if(acaoFormatada.equals("abrir")){
            this.abrirPorta();
        }
        else{
            this.fecharPorta();
        }
    }
}