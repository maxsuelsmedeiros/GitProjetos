package conta;

import agencia.Agencia;
public abstract class Conta {

    private String númeroConta;
    private  String senha;
    private String cpfCliente;
    private Double saldo;
    private String numAgencia;

    public Conta(String numero, String senha,String cpf, double saldo, String agencia){
        this.númeroConta=numero;
        this.senha=senha;
        this.cpfCliente=cpf;
        this.saldo=saldo;
        this.numAgencia=agencia;
    }

    public void setNúmeroConta(String númeroConta) {
        this.númeroConta = númeroConta;
    }

    public void setSenha(String senha){
        this.senha=senha;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setAgencia(String agencia) {
        this.numAgencia = agencia;
    }

    public String getNúmeroConta() {
        return númeroConta;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getAgencia() {
        return numAgencia;
    }
}
