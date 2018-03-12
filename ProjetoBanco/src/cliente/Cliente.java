package cliente;

import agencia.Agencia;
import contaCorrente.ContaCorrente;
import contaPoupança.ContaPoupança;
/*Essa classe vai existir e ter função unica de modelagem e de armazenamento das informações do
* objeto cliente, já que suas funções seram implementadas na classe de regra de negócio
* por isso no momento essa classe só recebe informações de outras classes também como conta e agencia
*/
public class Cliente {

    private String primeiroNome;
    private String sobreNome;
    private String cpf;
    private String senha;
    private String contaC;
    private String contaP;
    private String numAgencia;

    public Cliente(String primeiroNome,String sobreNome,String cpf, String senha,String agencia){
        this.primeiroNome=primeiroNome;
        this.sobreNome=sobreNome;
        this.cpf=cpf;
        this.senha=senha;
        this.numAgencia=agencia;
    }


    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setCpf(String cpf){
        this.cpf=cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setContaC(String contaC) {
        this.contaC = contaC;
    }

    public void setContaP(String contaP) {
        this.contaP = contaP;
    }

    public void setAgencia(Agencia agencia) {
        this.numAgencia = agencia.getNumeroAgencia();
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getContaC() {
        return contaC;
    }

    public String getContaP() {
        return contaP;
    }

    public String getAgencia() {
        return numAgencia;
    }

}
