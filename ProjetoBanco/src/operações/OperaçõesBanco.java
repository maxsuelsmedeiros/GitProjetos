package operações;

/*
*   Essa classe tem como objetivo modelar as operações realizadas pelo banco, como foi solicitadas no projeto
*  inicialmente seram trabalhados os dados os objetos dentro de ArrayLists de cada obejeto e depois de
*  ter classe modulada, será alterado para trabalhar com banco de dados.
*/

import cliente.Cliente;
import agencia.Agencia;
import contaCorrente.ContaCorrente;
import contaPoupança.ContaPoupança;
import conta.Conta;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
//Classes que o professor utilizou para ensinar socket
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class OperaçõesBanco  {
    private DataInputStream in;
    private DataOutputStream out;
    private ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    private ArrayList<Agencia> listaAgencias = new ArrayList<Agencia>();
    private ArrayList<ContaCorrente> listaCC = new ArrayList<ContaCorrente>();
    private ArrayList<ContaPoupança> listaCP = new ArrayList<ContaPoupança>();
    private Scanner scan = new Scanner(System.in);
    /*
    O professor ensinou uma dica muito boa que é receber tudo que vai ser utilizado na classe
    de regra de negócio e também, utilizar os metodos de criação como boolean que informa se deu certo
    ou se deu erraddo dependendo do retorno
    */


    public ArrayList<Agencia> getListaAgencias() {
        return listaAgencias;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public ArrayList<ContaCorrente> getListaCC() {
        return listaCC;
    }

    public ArrayList<ContaPoupança> getListaCP() {
        return listaCP;
    }
    public boolean verificarAgencia(String numAg){
        for(Agencia atual:listaAgencias){
            if(numAg.equals(atual.getNumeroAgencia())){
                return true;
            }
        }
        return false;
    }
    public void verificarDadosCliente(String cpf, String senha){
        for(Cliente atual:listaCliente){
            if(cpf.equals(atual.getCpf()) & senha.equals(atual.getSenha())){
                System.out.printf("\nNome do cliente é: %s  %s",atual.getPrimeiroNome(),atual.getSobreNome());
                System.out.printf("\n É um cliente da agência número: %s",atual.getAgencia());
                if(atual.getContaC() != null){
                    System.out.printf("\nO número da conta corrente do cliente é : %s",atual.getContaC());
                }
                if(atual.getContaP() != null){
                    System.out.printf("\nO número da conta poupança  do cliente é : %s",atual.getContaP());
                }
            }
        }
    }
    //Verificar se esta tudo correto em relação a conta corrente para transferencia
    public boolean retornarTranferenciaPossivelContaC(String numConta, String numAgencia, double valor){
        for(ContaCorrente atual:listaCC){
            if(numAgencia.equals(atual.getAgencia()) & numConta.equals(atual.getNúmeroConta()) & valor<=atual.getSaldo()){
                System.out.println("Tranferência é possível!");
                return true;
            }
        }
        return false;
    }

    //Verificar se esta tudo correto em relação a conta poupança para a transferência
    public boolean retornarTranferenciaPossivelContaP(String numConta, String numAgencia, double valor){
        for(ContaPoupança atual:listaCP){
            if(numAgencia.equals(atual.getAgencia()) & numConta.equals(atual.getNúmeroConta()) & valor<=atual.getSaldo()){
                System.out.println("Tranferência é possível!");
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarAgencia(String numAgencia, String endereço ){
        Agencia ag;
        for(Agencia atual:listaAgencias){
            if(numAgencia.equals(atual.getNumeroAgencia())){
                System.out.println("Essa agencia já existe, não é possível criar outra agencia com a mesma informação");
                return false;
            }

        }
        ag = new Agencia(numAgencia,endereço);
        this.listaAgencias.add(ag);
        return true;
    }
    public boolean cadastrarCliente(String pNome,String sNome,String cpf, String senha, String agencia){
        Cliente cl;
        for(Cliente atual:listaCliente){
            if(cpf.equals(atual.getCpf())){
                System.out.println("Esse cliente já esta cadastrado no sistema, não é possível cadastrar outro cliente com o mesmo cpf");
                return false;
            }
        }
        //Depois adicionar o cliente criado para o Array de clientes que estão na agencia pertencente
        cl = new Cliente(pNome,sNome,cpf,senha,agencia);
        listaCliente.add(cl);
        for(Agencia atual:listaAgencias){
            if(agencia.equals(atual.getNumeroAgencia())){
                atual.AdicionarCliente(cl);
            }
        }
        return true;
    }
    public boolean cadastrarContaCorrente(String numConta, String cpf, double saldo, String senha,String agencia, double saldoEspecial){
        ContaCorrente contaC;
        for(ContaCorrente atual:listaCC){
            if(cpf.equals(atual.getCpfCliente())){
                System.out.println("Esse cliente já possui uma conta corrente, não é possível ter 2 contas com o mesmo cliente!");
                return false;
            }
        }
        contaC = new ContaCorrente(numConta,senha,cpf,saldo,saldoEspecial,agencia);
        listaCC.add(contaC);
        for(Cliente atual:listaCliente){
            if(cpf.equals(atual.getCpf())){
                atual.setContaC(numConta);
            }
        }
        return true;
    }
    public boolean cadastrarContaPoupança(String numConta, String cpf, double saldo, String senha,String agencia, String variação){
        ContaPoupança contaP;
        for(ContaPoupança atual:listaCP){
            if(cpf.equals(atual.getCpfCliente())){
                System.out.println("Esse cliente já possui uma conta poupança, não é possível ter 2 contas com o mesmo cliente!");
                return false;
            }
        }
        contaP = new ContaPoupança(numConta,senha,cpf,saldo,variação,agencia);
        listaCP.add(contaP);
        for(Cliente atual:listaCliente){
            if(cpf.equals(cpf)){
                atual.setContaP(numConta);
            }
        }
        return true;
    }
    //Verificar os saldos tanto de conta corrente que são o saldo normal e o saldoespecial
    public void saldoContaCorrente(String numConta, String senha){
        for(ContaCorrente atual:listaCC){
            if(numConta.equals(atual.getNúmeroConta()) & senha.equals(atual.getSenha())){
                System.out.printf("\nSeu saldo é de : %.2f",atual.getSaldo());
                System.out.printf("\nSeu saldo especial é de: %.2f",atual.getChequeEspecial());
            }else{
                System.out.println("Suas informações não esta no nosso sistema, verifique os dados e tente novamente mais tarde!");
            }
        }
    }
    //Esse método é bem simples e só existe para o cliente verificar se realmente existe valor suficiente para saque
    public void saldoContaPoupança(String numConta, String senha){
        for(ContaPoupança atual:listaCP){
            if(numConta.equals(atual.getNúmeroConta()) & senha.equals(atual.getSenha())){
                System.out.printf("\nSeu saldo é de : %.2f",atual.getSaldo());
            }else{
                System.out.println("Suas informações não esta no nosso sistema, verifique os dados e tente novamente mais tarde!");
            }
        }
    }
    //Nesse método o retorno continua como boolean pois testes seram feitos para verificar se existe valor
    //suficiente para saque, e se existir, o retorno é verdadeiro, caso não exista retorna um falso
    public boolean saqueContaCorrente(String numConta,String senha,double valorSaque,String agencia){
        for(ContaCorrente atual:listaCC){
            //Essa operação verifica se a conta existe e se o cliente possui saldo suficiente
            if(numConta.equals(atual.getNúmeroConta()) & senha.equals(atual.getSenha()) & agencia.equals(atual.getAgencia()) & valorSaque<=atual.getSaldo()){
                atual.setSaldo(atual.getSaldo()-valorSaque);
                //esse else if serve para realizar o saque a partir do saldo especial do cliente
                //Incluindo verificar se existe saldo e/ou saldo especial suficiente
            }else if(numConta.equals(atual.getNúmeroConta()) & senha.equals(atual.getSenha()) & agencia.equals(atual.getAgencia()) & valorSaque>atual.getSaldo() & atual.getSaldo()-valorSaque>=atual.getChequeEspecial()){
                System.out.println("Você não tem saldo suficiente para realizar o saque só com seu saldo atual, mas pode utilziar o seu cheque especial, deseja continuar?");
                System.out.println("Digite Sim para continuar e Nao para não realizar o saque e sair!");
                String opção=scan.next();
                opção=opção.toUpperCase();
                if(opção.equals("SIM")){
                    atual.setSaldo(valorSaque-atual.getChequeEspecial());
                }else{
                    System.out.println("Volte sempre!");
                    return false;
                }
            }else{
                System.out.println("O cliente não possui saldo suficiente para realizar o saque");
                return false;
            }
        }
        System.out.printf("Seu saque no valor de %.2f foi feito com sucesso!",valorSaque);
        return true;
    }
    public boolean saqueContaPoupança(String numConta,String senha,double valorSaque,String agencia){
        for(ContaPoupança atual:listaCP){
            //Essa operação verifica se a conta existe e se o cliente possui saldo suficiente
            if(numConta.equals(atual.getNúmeroConta()) & senha.equals(atual.getSenha()) & agencia.equals(atual.getAgencia()) & valorSaque<=atual.getSaldo()){
                atual.setSaldo(atual.getSaldo()-valorSaque);
        }else{
             System.out.println("Não foi possível realizar o saque, verifique se existe saldo suficiente, e também a senha e a número da conta");
             return false;
            }
        }
        System.out.printf("Seu saque no valor de %.2f foi feito com sucesso!",valorSaque);
        return true;
    }
    //Realizar o deposito, para adicionar o valor ao saldo do cliente e o saldo especial
    public void despositoContaCorrente(String numConta,double valorDeposito,String agencia){
        //Talvez seja um boa opção adicionar o nome do cliente no momento do deposito, perguntar ao professor
        for(ContaCorrente atual:listaCC){
            if(numConta.equals(atual.getNúmeroConta())& agencia.equals(atual.getAgencia())){
                atual.setSaldo(atual.getSaldo()+valorDeposito);
            }else{
                System.out.println("Infelizmente não foi possível encontar uma conta no sistema com esse número, tente novamente depois!");
            }
        }
        System.out.printf("O seu deposito de: %.2f \nNa conta: %S foi um sucesso ",valorDeposito,numConta);
    }
    public void despositoContaPoupança(String numConta,double valorDeposito,String agencia){
        //Talvez seja um boa opção adicionar o nome do cliente no momento do deposito, perguntar ao professor
        for(ContaPoupança atual:listaCP){
            if(numConta.equals(atual.getNúmeroConta())& agencia.equals(atual.getAgencia())){
                atual.setSaldo(atual.getSaldo()+valorDeposito);
            }else{
                System.out.println("Infelizmente não foi possível encontar uma conta no sistema com esse número, tente novamente depois!");
            }
        }
        System.out.printf("O seu deposito de: %.2f \nNa conta: %S foi um sucesso ",valorDeposito,numConta);
    }
    public void transferCorrenteCorrente(ContaCorrente contaA,double valorTransfer, ContaCorrente contaB){
        int cont=0;
        for(ContaCorrente atual:listaCC){
            String verificar = atual.getNúmeroConta();
            if(verificar.equals(contaA.getNúmeroConta())){
                cont++;
            }
            if(verificar.equals(contaB.getNúmeroConta())){
                cont++;
            }
        }
        if(cont==2){
            System.out.println("As contas existem proximo passo verificar se existe saldo suficiente!");
        }else{
            System.out.println("As informações estão incorretas, verifique e tente novamente mais tarde!");
            return;
        }
        if(contaA.getSaldo()-valorTransfer>=0){
            contaB.setSaldo(contaB.getSaldo()+valorTransfer);
            contaA.setSaldo(contaA.getSaldo()-valorTransfer);
            System.out.println("A transferencia foi um sucesso");
        }else{
            System.out.println("Saldo insuficiente para transferencia!");
        }
    }

    public void transferPoupançaPoupança(ContaPoupança contaA,double valorTransfer, ContaPoupança contaB){
        int cont=0;
        for(ContaPoupança atual:listaCP){
            String verificar = atual.getNúmeroConta();
            if(verificar.equals(contaA.getNúmeroConta())){
                cont++;
            }
            if(verificar.equals(contaB.getNúmeroConta())){
                cont++;
            }
        }
        if(cont==2){
            System.out.println("As contas existem proximo passo verificar se existe saldo suficiente!");
        }else{
            System.out.println("As informações estão incorretas, verifique e tente novamente mais tarde!");
            return;
        }
        if(contaA.getSaldo()-valorTransfer>=0){
            contaB.setSaldo(contaB.getSaldo()+valorTransfer);
            contaA.setSaldo(contaA.getSaldo()-valorTransfer);
            System.out.println("A transferencia foi um sucesso");
        }else{
            System.out.println("Saldo insuficiente para transferencia!");
        }
    }

    public boolean transferenciaDistribuida(double valorTranferencia, String numContaServidor,String agenciaServidor ){
        InetAddress ia;
        int port = 5000;
        try {
            ia = InetAddress.getByName("localhost");
            Socket sock = new Socket(ia,port);

            System.out.println("Conetado ao servidor do outro banco");

            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());

                out.writeUTF(agenciaServidor);

                String msg_in1 = in.readUTF();

                if(msg_in1.equals("NEGADO")){
                    return false;
                }

                out.writeUTF(numContaServidor);

                String msg_in2 = in.readUTF();
                if(msg_in2.equals("NEGADO")){
                    return false;
                }

                String valorVerificar = String.valueOf(valorTranferencia);
                out.writeUTF(valorVerificar);

                String msg_in3 = in.readUTF();

                if(msg_in3.equals("NEGADO")){
                    return false;
                }


            sock.close();
        } catch (UnknownHostException ex) {
            System.out.println("Não foi possível resolver endereço");
            return false;
        } catch (IOException ex) {
            System.out.println("Erro de rede");
            return false;
        }
        return true;
    }


}
