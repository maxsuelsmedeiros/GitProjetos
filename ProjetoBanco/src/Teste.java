import cliente.Cliente;
import agencia.Agencia;
import conta.Conta;
import contaCorrente.ContaCorrente;
import contaPoupança.ContaPoupança;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;

import autenticarDados.Autenticar;
import operações.OperaçõesBanco;

import javax.swing.*;

public class Teste {
/*
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){


        Agencia ag = cadastrarAgencia();
        Cliente cL=cadastrarCliente(ag);
        ContaCorrente cC = cadastrarContaC(ag,cL);
        ContaPoupança cP = cadastrarContaP(ag,cL);
        cL.setContaC(cC);
        cL.setContaP(cP);
        verificar(cL);
    }

    static Agencia cadastrarAgencia(){
        String num="1111-1";
        String endereço="R manoel tavares";
        Agencia ag = new Agencia(num,endereço);
        return ag;
    }

    static ContaCorrente cadastrarContaC(Agencia ag, Cliente cL){
        Autenticar at = new Autenticar();
        String numConta5C="";
        String numConta2C="";
        boolean teste=false;
        //Essas linhas existem para realizar a verificação de o usuário esta digitando valores validos para cadastro de conta
        while(teste == false){
            System.out.println("Digite os 5 primeiros digitos da conta");
            numConta5C=scan.next();
            teste=at.verificarTam5(numConta5C);
        }
        teste=false;
        while(teste == false){
            System.out.println("Digite os 2 primeiros digitos da conta");
            numConta2C=scan.next();
            teste=at.verificarTam2(numConta2C);
        }
        String numContaC = numConta5C +"-"+numConta2C;
        String senha="123";
        double saldo=500.20;
        double saldoE=100.00;
        ContaCorrente aC = new ContaCorrente(numContaC,senha,cL.getCpf(),saldo,saldoE*-1,ag);
        return aC;
    }

    static ContaPoupança cadastrarContaP(Agencia ag, Cliente cL){
        Autenticar at = new Autenticar();
        String numConta5P="";
        String numConta2P="";
        boolean teste=false;
        //Essas linhas existem para realizar a verificação de o usuário esta digitando valores validos para cadastro de conta
        while(teste == false){
            System.out.println("Digite os 5 primeiros digitos da conta");
            numConta5P=scan.next();
            teste=at.verificarTam5(numConta5P);
        }
        teste=false;
        while(teste == false){
            System.out.println("Digite os 2 primeiros digitos da conta");
            numConta2P=scan.next();
            teste=at.verificarTam2(numConta2P);
        }
        String numContaP = numConta5P +"-"+ numConta2P;
        String senha="123";
        double saldo=700.00;
        String var="51";
        double taxa=0.12;
        ContaPoupança cP = new ContaPoupança(numContaP,senha,cL.getCpf(),saldo,var,ag);
        return cP;
    }


    static Cliente cadastrarCliente(Agencia ag){
        System.out.println("Digite seu primeiro nome");
        String primeiroNome=scan.next();
        System.out.println("Digite seu sobre nome");
        String sobreNome= scan.next();
        System.out.println("Digite sua senha");
        String senha = scan.next();
        System.out.println("Digite seu CPF");
        String cpf = scan.next();
        Cliente cL= new Cliente(primeiroNome,sobreNome,cpf,senha,ag);
        return cL;
    }

    static void verificar(Cliente cL){
        System.out.println(cL.getPrimeiroNome());
        System.out.println(cL.getSobreNome());
        System.out.println(cL.getContaC());
        System.out.println(cL.getContaP());
        System.out.println(cL.getAgencia());
    }

*/
    public static void main(String args[]){

        Agencia ag = cadastrarAgencia();
        Cliente cL=cadastrarCliente(ag);
        ContaCorrente cC = cadastrarContaC(ag,cL);
        cL.setContaC(cC.getNúmeroConta());
        verificar(cL);
        InetAddress ia;
        int port = 5000;
        try {
            ia = InetAddress.getByName("localhost");
            Socket sock = new Socket(ia,port);

            System.out.println("Conetado ao servidor do outro banco");

            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());

            String agencia = "1111-1";

            out.writeUTF(agencia);

            String msg_in1 = in.readUTF();

            if(msg_in1.equals("NEGADO")){
                System.out.println("Deu problema");
            }
            String numero = "22222-22";
            out.writeUTF(numero);

            String msg_in2 = in.readUTF();
            if(msg_in2.equals("NEGADO")){
                System.out.println("Deu problema");
            }

            double valor = 50;
            String valorVerificar = String.valueOf(valor);
            out.writeUTF(valorVerificar);

            String msg_in3 = in.readUTF();

            if(msg_in3.equals("NEGADO")){
                System.out.println("Deu problema");
            }
            System.out.println("foi sucesso");

            sock.close();
        } catch (UnknownHostException ex) {
            System.out.println("Não foi possível resolver endereço");

        } catch (IOException ex) {
            System.out.println("Erro de rede");

        }
        /*
        try {
            InetAddress ia = InetAddress.getByName("192.168.25.218");
            int port = 5000;
            ServerSocket server = new ServerSocket(port, 10, ia);
            System.out.println("Aguardando conexão do próximo cliente...");
            Socket sock = server.accept();
            ///////////////////////////////////////////////////////
            try {
                int contC = 0;
                DataInputStream in = new DataInputStream(sock.getInputStream());
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());

                //Essa primeira mensagem deve ser a agencia
                String msg_agencia = in.readUTF();

                if(msg_agencia.equals(cC.getAgencia())){
                    contC=contC+1;
                }

                if (contC == 1 ) {
                    out.writeUTF("OK");
                } else {
                    out.writeUTF("NEGADO");
                }
                //Essa segunda mensagem é o número da conta
                String msg_conta = in.readUTF();

                    if (msg_conta.equals(cC.getNúmeroConta())) {
                        contC = contC + 1;
                    }

                if (contC == 2 ) {
                    out.writeUTF("OK");
                } else {
                    out.writeUTF("NEGADO");
                }
                //Essa ultima mensagem verifica se o valor passo é positivo ou negativo
                String msg_valor = in.readUTF();
                double valor = Double.valueOf(msg_valor);
                if (valor > 0) {
                    out.writeUTF("OK");
                } else {
                    out.writeUTF("NEGADO");
                }
                if (contC == 2) {
                    cC.setSaldo(cC.getSaldo()+valor);
                }

                System.out.println("Transferencia efetuada com sucesso");

            } catch (IOException ex) {
                System.out.println();
            }
            //////////////////////////////////////////////////////
        }catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        */
    }

    static Agencia cadastrarAgencia(){
        String num="1111-1";
        String endereço="R manoel tavares";
        Agencia ag = new Agencia(num,endereço);
        return ag;
    }

    static ContaCorrente cadastrarContaC(Agencia ag, Cliente cL){
        String numContaC = "33333-33";
        String senha="123456";
        double saldo=100.00;
        double saldoE=100.00;
        ContaCorrente aC = new ContaCorrente(numContaC,senha,cL.getCpf(),saldo,saldoE*-1,ag.getNumeroAgencia());
        return aC;
    }



    static Cliente cadastrarCliente(Agencia ag){
            String primeiroNome="jose";

        String sobreNome= "silva";

        String senha = "123456";
        String cpf = "12345678910";
        Cliente cL= new Cliente(primeiroNome,sobreNome,cpf,senha,ag.getNumeroAgencia());
        return cL;
    }

    static void verificar(Cliente cL){
        System.out.println(cL.getPrimeiroNome());
        System.out.println(cL.getSobreNome());
        System.out.println(cL.getContaC());
        System.out.println(cL.getContaP());
        System.out.println(cL.getAgencia());
    }


    }
