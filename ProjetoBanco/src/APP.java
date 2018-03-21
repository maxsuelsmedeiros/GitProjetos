<<<<<<< HEAD
import com.sun.org.apache.regexp.internal.RE;
import contaCorrente.ContaCorrente;
import contaPoupança.ContaPoupança;

import java.io.Console;
=======
import contaCorrente.ContaCorrente;
import contaPoupança.ContaPoupança;
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
import java.util.ArrayList;
import java.util.Scanner;
import autenticarDados.Autenticar;
import operações.OperaçõesBanco;
//Classes de socket

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
<<<<<<< HEAD
//Classes para cores
public class APP  {
    static Scanner scan = new Scanner(System.in);
    static Autenticar aT = new Autenticar();
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
=======
import java.util.logging.Level;
import java.util.logging.Logger;
public class APP  {
    static Scanner scan = new Scanner(System.in);
    static Autenticar aT = new Autenticar();
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67

    public static void main(String args[]){
        OperaçõesBanco oP = new OperaçõesBanco();
        try {
            // Trecho de código disponibilizado pelo professor Ruan
            InetAddress ia = InetAddress.getByName("localhost");
            int port = 5000;
            ServerSocket server = new ServerSocket(port, 10, ia);
            //Nesse trecho os dados do servidor são passados por parametro pelo socketserver chamdo de server
            oP.setSock(server);
            //Depois inicia uma thread que vai ficar ativa, já que o main só é finalizado caso o usuário digite 0 e saia do main
            Thread t1 = new Thread(oP);
            t1.start();
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
<<<<<<< HEAD
        System.out.println(BLUE+"Bem vindo, os opções são as seguintes:\n1-Cadastrar Agência 2-Cadastrar Cliente"+RESET);
        System.out.println(BLUE+"3-Cadastro de conta Corrente 4-Cadastro de conta Poupança \n5-Deposito 6-Saque\n7-Transferência para o mesmo banco 8-Informações do cliente \n9-Saldo 10-Transferencia para outro banco\n0- Para finalizar\n:"+RESET);
=======
        System.out.println("Bem vindo, os opções são as seguintes:\n1-Cadastrar Agência\n2-Cadastrar Cliente");
        System.out.println("3-Cadastro de conta Corrente\n4-Cadastro de conta Poupança \n5-Deposito\n6-Saque\n7-Transferência para o mesmo banco\n8-Informações do cliente \n9-Saldo\n10-Transferencia para outro banco\n0- Para finalizar\n:");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
        int opção = scan.nextInt();
        while(opção != 0){
            //Opção 1 é para cadastrar a agência
            if(opção==1){
<<<<<<< HEAD
                System.out.println(YELLOW+"Informe por favor os 4 primeiros digitos da agencia:\n"+RESET);
                String aG4 = scan.next();
                System.out.println(YELLOW+"Informe por favor o ultimo digito da agência:\n"+RESET);
=======
                System.out.println("Informe por favor os 4 primeiros digitos da agencia:\n");
                String aG4 = scan.next();
                System.out.println("Informe por favor o ultimo digito da agência:\n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                String aG1 = scan.next();
                boolean teste = validarAgencia(aG4,aG1);
                if (teste==true){
                    String numAg=aG4+"-"+aG1;
                    System.out.println(numAg);
<<<<<<< HEAD
                    System.out.println(YELLOW+"Por favor informe o endereço da agência!"+RESET);
                    String endereço = scan.next();
                    teste = oP.cadastrarAgencia(numAg,endereço);
                    if(teste == true) {
                        System.out.println(BLUE+"Cadastrado com sucesso"+RESET);
                    }else{
                        System.out.println(RED+"Cadastrado não foi feito"+RESET);
=======
                    System.out.println("Por favor informe o endereço da agência!");
                    String endereço = scan.next();
                    teste = oP.cadastrarAgencia(numAg,endereço);
                    if(teste == true) {
                        System.out.println("Cadastrado com sucesso");
                    }else{
                        System.out.println("Cadastrado não foi feito");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                    }
                }
            }
            //opção 2 é para Cadastrar cliente
            if(opção==2){
<<<<<<< HEAD
                System.out.println(YELLOW+"Digite o cpf do cliente:\n"+RESET);
                String cpf = scan.next();
                System.out.println(YELLOW+"Digite o primeiro nome do cliente:\n"+RESET);
                String primeiroNome = scan.next();
                System.out.println(YELLOW+"Digite o sobre nome do cliente:\n"+ RESET);
                String sobreNome = scan.next();
                System.out.println(YELLOW+"Informe a senha de 6 digitos do cliente:\n"+RESET);
                String senha = scan.next();
                System.out.println(YELLOW+"Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n "+RESET);
=======
                System.out.println("Digite o cpf do cliente:\n");
                String cpf = scan.next();
                System.out.println("Digite o primeiro nome do cliente:\n");
                String primeiroNome = scan.next();
                System.out.println("Digite o sobre nome do cliente:\n");
                String sobreNome = scan.next();
                System.out.println("Informe a senha de 6 digitos do cliente:\n");
                String senha = scan.next();
                System.out.println("Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n ");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                String numAG = scan.next();
                if(validarCliente(senha,cpf)==true){
                    if(oP.verificarAgencia(numAG)==true){
                        oP.cadastrarCliente(primeiroNome,sobreNome,cpf,senha,numAG);
<<<<<<< HEAD
                        System.out.println(BLUE+"Cadastro feito com sucesso!"+RESET);
                    }else{
                        System.out.println(RED+"Agencia não existe"+RESET);
                    }
                }else{
                    System.out.println(RED+"Alguma das informações não estão válidas, não foi possível realizar o cadastro!"+RESET);
=======
                        System.out.println("Cadastro feito com sucesso!");
                    }else{
                        System.out.println("Agencia não existe");
                    }
                }else{
                    System.out.println("Alguma das informações não estão válidas, não foi possível realizar o cadastro!");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                }
            }
            //Opção 3 é referente ao cadastro da conta corrente
            if(opção==3){
<<<<<<< HEAD
                System.out.println(YELLOW+"Por favor digite os 5 primeiros digitos da conta:\n"+RESET);
                String aC5 = scan.next();
                System.out.println(YELLOW+"Por favor digite os 2 ultimos digitos da conta:\n"+RESET);
                String aC2 = scan.next();
                System.out.println(YELLOW+"Por favor digite os 6 digitos senha:\n"+RESET);
                String senha = scan.next();
                System.out.println(YELLOW+"Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n "+RESET);
                String numAG = scan.next();
                System.out.println(YELLOW+"Digite o cpf do cliente dono da conta, lembrando que deve possuir 11 digitos:\n"+RESET);
                String cpf = scan.next();
                System.out.println(YELLOW+"Por favor digite o saldo inicial da conta do cliente: \n"+RESET);
                double saldo = scan.nextDouble();
                System.out.println(YELLOW+"Por favor digite o saldo especial da conta do cliente, lembrando que esse é um limite negativo até onde o cliente pode usufruir: \n"+RESET);
=======
                System.out.println("Por favor digite os 5 primeiros digitos da conta:\n");
                String aC5 = scan.next();
                System.out.println("Por favor digite os 2 ultimos digitos da conta:\n");
                String aC2 = scan.next();
                System.out.println("Por favor digite os 6 digitos senha:\n");
                String senha = scan.next();
                System.out.println("Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n ");
                String numAG = scan.next();
                System.out.println("Digite o cpf do cliente dono da conta, lembrando que deve possuir 11 digitos:\n");
                String cpf = scan.next();
                System.out.println("Por favor digite o saldo inicial da conta do cliente: \n");
                double saldo = scan.nextDouble();
                System.out.println("Por favor digite o saldo especial da conta do cliente, lembrando que esse é um limite negativo até onde o cliente pode usufruir: \n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                double saldoEspecial = scan.nextDouble();
                saldoEspecial=saldoEspecial*(-1);
                if(validarContaC(aC5,aC2,senha,cpf)==true){
                    String numConta=aC5+"-"+aC2;
                    if(oP.verificarAgencia(numAG)==true){
                        oP.cadastrarContaCorrente(numConta,cpf,saldo,senha,numAG,saldoEspecial);
<<<<<<< HEAD
                        System.out.println(BLUE+"Cadastro feito com sucesso!"+RESET);
                    }
                }else{
                    System.out.println(RED+"Alguma informação não esta correta, o cadastro não foi finalizado com sucesso!"+RESET);
=======
                        System.out.println("Cadastro feito com sucesso!");
                    }
                }else{
                    System.out.println("Alguma informação não esta correta, o cadastro não foi finalizado com sucesso!");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                }
            }
            //opção 4 Cadastro de conta Poupança
            if(opção==4){
<<<<<<< HEAD
                System.out.println(YELLOW+"Por favor digite os 5 primeiros digitos da conta:\n"+RESET);
                String aC5 = scan.next();
                System.out.println(YELLOW+"Por favor digite os 2 ultimos digitos da conta:\n"+RESET);
                String aC2 = scan.next();
                System.out.println(YELLOW+"Por favor digite os 6 digitos senha:\n"+RESET);
                String senha = scan.next();
                System.out.println(YELLOW+"Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n "+RESET);
                String numAG = scan.next();
                System.out.println(YELLOW+"Digite o cpf do cliente dono da conta, lembrando que deve possuir 11 digitos:\n"+RESET);
                String cpf = scan.next();
                System.out.println(YELLOW+"Por favor digite o saldo inicial da conta do cliente: \n"+RESET);
                double saldo = scan.nextDouble();
                System.out.println(YELLOW+"Por favor informe a variação da conta poupança: \n"+RESET);
=======
                System.out.println("Por favor digite os 5 primeiros digitos da conta:\n");
                String aC5 = scan.next();
                System.out.println("Por favor digite os 2 ultimos digitos da conta:\n");
                String aC2 = scan.next();
                System.out.println("Por favor digite os 6 digitos senha:\n");
                String senha = scan.next();
                System.out.println("Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n ");
                String numAG = scan.next();
                System.out.println("Digite o cpf do cliente dono da conta, lembrando que deve possuir 11 digitos:\n");
                String cpf = scan.next();
                System.out.println("Por favor digite o saldo inicial da conta do cliente: \n");
                double saldo = scan.nextDouble();
                System.out.println("Por favor informe a variação da conta poupança: \n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                String var = scan.next();
                String numConta=aC5+"-"+aC2;
                if(validarContaP(aC5,aC2,senha,cpf,var)==true){
                    if(oP.verificarAgencia(numAG)==true) {
                        if(oP.cadastrarContaPoupança(numConta, cpf, saldo, senha, numAG, var)==true){
<<<<<<< HEAD
                            System.out.println(BLUE+"Cadastrado feito com sucesso!"+RESET);
                        }
                    }
                }else{
                    System.out.println(RED+"Alguma informação não esta correta, o cadastro não foi finalizado com sucesso!"+RESET);
=======
                            System.out.println("Cadastrado feito com sucesso!");
                        }
                    }
                }else{
                    System.out.println("Alguma informação não esta correta, o cadastro não foi finalizado com sucesso!");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                }
            }
            //opção de 5 é de deposito
            if(opção==5){
<<<<<<< HEAD
                System.out.println(YELLOW+"Por favor escolha 1- para depositar em conta corrente\n 2- para depositar em conta poupança:\n"+RESET);
                String escolha = scan.next();
                if(escolha.equals("1")){
                    System.out.println(YELLOW+"Por favor informe o número da conta para deposito, utilize o modelo xxxxx-xx:\n"+RESET);
                    String numConta=scan.next();
                    System.out.println(YELLOW+"Por favor infome o valor do deposito: \n"+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n "+RESET);
                    String numAG = scan.next();
                    oP.despositoContaCorrente(numConta,valor,numAG);
                }else if(escolha.equals("2")){
                    System.out.println(YELLOW+"Por favor informe o número da conta para deposito, utilize o modelo xxxxx-xx:\n"+RESET);
                    String numConta=scan.next();
                    System.out.println(YELLOW+"Por favor infome o valor do deposito: \n"+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n "+RESET);
                    String numAG = scan.next();
                    oP.despositoContaPoupança(numConta,valor,numAG);
                }else{
                    System.out.println(RED+"A opção escolhida não existe, tente novamente mais tarde!"+RESET);
=======
                System.out.println("Por favor escolha 1- para depositar em conta corrente\n 2- para depositar em conta poupança:\n");
                String escolha = scan.next();
                if(escolha.equals("1")){
                    System.out.println("Por favor informe o número da conta para deposito, utilize o modelo xxxxx-xx:\n");
                    String numConta=scan.next();
                    System.out.println("Por favor infome o valor do deposito: \n");
                    double valor = scan.nextDouble();
                    System.out.println("Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n ");
                    String numAG = scan.next();
                    oP.despositoContaCorrente(numConta,valor,numAG);
                }else if(escolha.equals("2")){
                    System.out.println("Por favor informe o número da conta para deposito, utilize o modelo xxxxx-xx:\n");
                    String numConta=scan.next();
                    System.out.println("Por favor infome o valor do deposito: \n");
                    double valor = scan.nextDouble();
                    System.out.println("Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n ");
                    String numAG = scan.next();
                    oP.despositoContaPoupança(numConta,valor,numAG);
                }else{
                    System.out.println("A opção escolhida esta não existe, tente novamente mais tarde!");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                }
            }
            //opção de 6 é de saque
            if(opção==6){
<<<<<<< HEAD
                System.out.println(YELLOW+"Por favor escolha 1- para saque em conta corrente\n 2- para saque em conta poupança:\n"+RESET);
                String escolha = scan.next();
                if(escolha.equals("1")){
                    System.out.println(YELLOW+"Por favor informe o número da conta para saque, utilize o modelo xxxxx-xx:\n"+RESET);
                    String numConta=scan.next();
                    System.out.println(YELLOW+"Informe a agência que o cliente da conta, informe no formato xxxx-x:\n "+RESET);
                    String numAG = scan.next();
                    System.out.println(YELLOW+"Por favor infome o valor do saque: \n"+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Informe por favor a senha de 6 digitos da conta para saque"+RESET);
                    String senha = scan.next();
                    oP.saqueContaCorrente(numConta,senha,valor,numAG);
                }else if(escolha.equals("2")){
                    System.out.println(YELLOW+"Por favor informe o número da conta para saque, utilize o modelo xxxxx-xx:\n"+RESET);
                    String numConta=scan.next();
                    System.out.println(YELLOW+"Informe a agência que o cliente da conta, informe no formato xxxx-x:\n "+RESET);
                    String numAG = scan.next();
                    System.out.println(YELLOW+"Por favor infome o valor do saque: \n"+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Informe por favor a senha de 6 digitos da conta para saque"+RESET);
                    String senha = scan.next();
                    oP.saqueContaPoupança(numConta,senha,valor,numAG);
                }else {
                    System.out.println(RED+"A opção escolhida esta não existe, tente novamente mais tarde!"+RESET);
=======
                System.out.println("Por favor escolha 1- para saque em conta corrente\n 2- para saque em conta poupança:\n");
                String escolha = scan.next();
                if(escolha.equals("1")){
                    System.out.println("Por favor informe o número da conta para saque, utilize o modelo xxxxx-xx:\n");
                    String numConta=scan.next();
                    System.out.println("Por favor infome o valor do saque: \n");
                    double valor = scan.nextDouble();
                    System.out.println("Informe por favor a senha de 6 digitos da conta para saque");
                    System.out.println("Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n ");
                    String numAG = scan.next();
                    String senha = scan.next();
                    oP.saqueContaCorrente(numConta,senha,valor,numAG);
                }else if(escolha.equals("2")){
                    System.out.println("Por favor informe o número da conta para saque, utilize o modelo xxxxx-xx:\n");
                    String numConta=scan.next();
                    System.out.println("Por favor infome o valor do saque: \n");
                    double valor = scan.nextDouble();
                    System.out.println("Informe por favor a senha de 6 digitos da conta para saque");
                    String senha = scan.next();
                    System.out.println("Informe a agência que o cliente vai ser cadastrado, informe no formato xxxx-x:\n ");
                    String numAG = scan.next();
                    oP.saqueContaPoupança(numConta,senha,valor,numAG);
                }else {
                    System.out.println("A opção escolhida esta não existe, tente novamente mais tarde!");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                }
            }
            //opções 7 é de Transferencias para a mesmo banco
            if(opção==7){
<<<<<<< HEAD
                System.out.println(YELLOW+"Por favor escolha uma das seguintes opções para transfêrencia:"+RESET);
                System.out.println(YELLOW+"1-Conta Corrente para Conta corrente\n 2- Conta Poupança para Poupança\n"+RESET);
=======
                System.out.println("Por favor escolha uma das seguintes opções para transfêrencia:");
                System.out.println("1-Conta Corrente para Conta corrente\n 2- Conta Poupança para Poupança\n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                String escolha = scan.next();
                if(escolha.equals("1")){
                    ContaCorrente CC1 = new ContaCorrente("000000","00000","00000",0,0,"0");
                    ContaCorrente CC2 = new ContaCorrente("000000","00000","00000",0,0,"0");
<<<<<<< HEAD
                    System.out.println(YELLOW+"Digite o número da conta corrente com a numeração xxxxx-xx, que deve ter o dinehiro retirado:\n"+RESET);
=======
                    System.out.println("Digite o número da conta corrente com a numeração xxxxx-xx, que deve ter o dinehiro retirado:\n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                    String contaCSacar=scan.next();
                    ArrayList<ContaCorrente> listaCC=oP.getListaCC();
                    //Recuperar o objeto conta corrente
                    for(ContaCorrente atual:listaCC){
                        if(contaCSacar.equals(atual.getNúmeroConta())){
                            CC1=atual;
                        }
                    }
<<<<<<< HEAD
                    System.out.println(YELLOW+"Por favor informe o valor da transfêrencia: "+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Digite o número da conta corrente com a numeração xxxxx-xx, que vai receber o dinheiro:\n"+RESET);
=======
                    System.out.println("Por favor informe o valor da transfêrencia: ");
                    double valor = scan.nextDouble();
                    System.out.println("Digite o número da conta corrente com a numeração xxxxx-xx, que vai receber o dinheiro:\n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                    String contaCDepositar=scan.next();
                    for(ContaCorrente atual:listaCC){
                        if(contaCDepositar.equals(atual.getNúmeroConta())){
                            CC2=atual;
                        }
                    }
                    oP.transferCorrenteCorrente(CC1,valor,CC2);
                }else if(escolha.equals("2")){
                    ContaPoupança CP1 = new ContaPoupança("00000","0000","00000",0,"00","00000");
                    ContaPoupança CP2 = new ContaPoupança("00000","0000","00000",0,"00","00000");
<<<<<<< HEAD
                    System.out.println(YELLOW+"Digite o número da conta poupança com a numeração xxxxx-xx, que deve ter o dinehiro retirado:\n"+RESET);
=======
                    System.out.println("Digite o número da conta poupança com a numeração xxxxx-xx, que deve ter o dinehiro retirado:\n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                    String contaCSacar=scan.next();
                    ArrayList<ContaPoupança> listaCP = oP.getListaCP();
                    //Recuperar o objeto conta corrente
                    for(ContaPoupança atual:listaCP){
                        if(contaCSacar.equals(atual.getNúmeroConta())){
                            CP1=atual;
                        }
                    }
<<<<<<< HEAD
                    System.out.println(YELLOW+"Por favor informe o valor da transfêrencia: "+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Digite o número da conta poupança com a numeração xxxxx-xx, que vai receber o dinheiro:\n"+RESET);
=======
                    System.out.println("Por favor informe o valor da transfêrencia: ");
                    double valor = scan.nextDouble();
                    System.out.println("Digite o número da conta poupança com a numeração xxxxx-xx, que vai receber o dinheiro:\n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                    String contaCDepositar=scan.next();
                    for(ContaPoupança atual:listaCP){
                        if(contaCDepositar.equals(atual.getNúmeroConta())){
                            CP2=atual;
                        }
                    }
                    oP.transferPoupançaPoupança(CP1,valor,CP2);
                }else{
<<<<<<< HEAD
                    System.out.println(RED+"Opção invalida, tente novamente mais tarde!"+RESET);
=======
                    System.out.println("Opção invalida, tente novamente mais tarde!");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                }
            }
            //Opção 8 é de verificar informações de um cliente espeficico
            if(opção==8){
<<<<<<< HEAD
                System.out.println(YELLOW+"Para verificar informações do cliente digite o cpf de 11 digitos: \n"+RESET);
                String cpf = scan.next();
                System.out.println(YELLOW+"Para verificar informações do cliente digite a senha de 6 digitos: \n"+RESET);
=======
                System.out.println("Para verificar informações do cliente digite o cpf de 11 digitos: \n");
                String cpf = scan.next();
                System.out.println("Para verificar informações do cliente digite a senha de 6 digitos: \n");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
                String senha = scan.next();
                oP.verificarDadosCliente(cpf,senha);
            }
            //Opção 9 é de verificar o saldo da conta corrente ou poupança
            if(opção==9){
<<<<<<< HEAD
                System.out.println(YELLOW+"Escolha uma opção de conta:\n1-Saldo Conta Corrente \n2-Saldo Conta Poupança"+RESET);
                String escolha = scan.next();
                if(escolha.equals("1")){
                    System.out.println(YELLOW+"Por favor informe a numeração da conta com a numeração xxxxx-xx:\n"+RESET);
                    String numConta = scan.next();
                    System.out.println(YELLOW+"Por favor informe a senha de 6 digitos da conta:\n "+RESET);
                    String senha = scan.next();
                    oP.saldoContaCorrente(numConta,senha);
                }else if(escolha.equals("2")){
                    System.out.println(YELLOW+"Por favor informe a numeração da conta com a numeração xxxxx-xx:\n"+RESET);
                    String numConta = scan.next();
                    System.out.println(YELLOW+"Por favor informe a senha de 6 digitos da conta:\n "+RESET);
                    String senha = scan.next();
                    oP.saldoContaPoupança(numConta,senha);
                }else{
                    System.out.println(RED+"Opção invalida, tente novamente mais tarde!"+RESET);
                }
            }
            //Essa é a opção para permitir a transferencia para o outro banco, que é a 10
            if(opção==10){
                System.out.println(YELLOW+"Para realizar a transferencia para outro banco, escolha uma das opções:\n 1- Para transferir de uma conta Corrente \n 2-Para transferir de uma conta Poupança"+RESET);
                String escolha = scan.next();
                if(escolha.equals("1")) {
                    System.out.println(YELLOW+"Informe a agencia cliente que o dinheiro será retirado, com a numeração xxxx-x:\n"+RESET);
                    String numAg = scan.next();
                    System.out.println(YELLOW+"Informe a conta corrente do cliente que o dinheiro será retirado com a numeração xxxxx-xx:\n "+RESET);
                    String numconta = scan.next();
                    System.out.println(YELLOW+"Informe o valor da transferencia:\n"+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Informe a senha de 6 digitos da conta que deve ter o dinheiro retirado:\n"+RESET);
                    String senha = scan.next();
                    System.out.println(YELLOW+"Por favor informe o endereço do outro banco para transfêrencia, que pode ser 'localhost' para o mesmo banco e em formado de endereço IP exemplo:\n192.168.2.1"+RESET);
                    String endereço = scan.next();
                    if (oP.retornarTranferenciaPossivelContaC(numconta, numAg, valor) == true) {
                        System.out.println(YELLOW+"Informe a agencia do outro banco para ser transferida, utilize a numeração xxxx-x:\n"+RESET);
                        String numAgTransfer = scan.next();
                        System.out.println(YELLOW+"Informe a conta do outro banco para ser transferida, utilize a numeração xxxxx-xx\n"+RESET);
                        String numContaTransfer = scan.next();
                        if (oP.transferenciaDistribuida(valor, numContaTransfer, numAgTransfer,endereço) == true) {
                            oP.saqueContaCorrente(numconta, senha, valor, numAg);
                        }
                    } else {
                        System.out.println(RED+"Não é possível realizar a transferencia!"+RESET);
                    }
                }
                if(escolha.equals("2")){
                    System.out.println(YELLOW+"Informe a agencia cliente que o dinheiro será retirado, com a numeração xxxx-x:\n"+RESET);
                    String numAg = scan.next();
                    System.out.println(YELLOW+"Informe a conta corrente do cliente que o dinheiro será retirado com a numeração xxxxx-xx:\n "+RESET);
                    String numconta = scan.next();
                    System.out.println(YELLOW+"Informe o valor da transferencia:\n"+RESET);
                    double valor = scan.nextDouble();
                    System.out.println(YELLOW+"Informe a senha de 6 digitos da conta que deve ter o dinheiro retirado:\n"+RESET);
                    String senha = scan.next();
                    System.out.println(YELLOW+"Por favor informe o endereço do outro banco para transfêrencia, que pode ser 'localhost' para o mesmo banco e em formado de endereço IP exemplo:\n192.168.2.1"+RESET);
                    String endereço = scan.next();
                    if(oP.retornarTranferenciaPossivelContaP(numconta,numAg,valor)==true){
                        System.out.println(YELLOW+"Informe a agencia do outro banco para ser transferida, utilize a numeração xxxx-x:\n"+RESET);
                        String numAgTransfer = scan.next();
                        System.out.println(YELLOW+"Informe a conta do outro banco para ser transferida, utilize a numeração xxxxx-xx\n"+RESET);
                        String numContaTransfer = scan.next();
                        if(oP.transferenciaDistribuida(valor,numContaTransfer,numAgTransfer,endereço)==true){
                            oP.saqueContaPoupança(numconta,senha,valor,numAg);
                        }
                    }else{
                        System.out.println(RED+"Não é possível realizar a transferencia!"+RESET);
                    }
                }
            }
            System.out.println(BLUE+"Bem vindo, os opções são as seguintes:\n1-Cadastrar Agência 2-Cadastrar Cliente"+RESET);
            System.out.println(BLUE+"3-Cadastro de conta Corrente 4-Cadastro de conta Poupança \n5-Deposito 6-Saque\n7-Transferência para o mesmo banco 8-Informações do cliente \n9-Saldo 10-Transferencia para outro banco\n0- Para finalizar\n:"+RESET);
=======
                System.out.println("Escolha uma opção de conta:\n1-Saldo Conta Corrente \n2-Saldo Conta Poupança");
                String escolha = scan.next();
                if(escolha.equals("1")){
                    System.out.println("Por favor informe a numeração da conta com a numeração xxxxx-xx:\n");
                    String numConta = scan.next();
                    System.out.println("Por favor informe a senah de 6 digitos da conta:\n ");
                    String senha = scan.next();
                    oP.saldoContaCorrente(numConta,senha);
                }else if(escolha.equals("2")){
                    System.out.println("Por favor informe a numeração da conta com a numeração xxxxx-xx:\n");
                    String numConta = scan.next();
                    System.out.println("Por favor informe a senah de 6 digitos da conta:\n ");
                    String senha = scan.next();
                    oP.saldoContaPoupança(numConta,senha);
                }else{
                    System.out.println("Opção invalida, tente novamente mais tarde!");
                }
            }
            //Essa é a opção para permitir a transferencia para o outro banco
            if(opção==10){
                System.out.println("Para realizar a transferencia para outro banco, escolha uma das opções:\n 1- Para transferir de uma conta Corrente \n 2-Para transferir de uma conta Poupança");
                String escolha = scan.next();
                if(escolha.equals("1")) {
                    System.out.println("Informe a agencia da conta do cliente que o dinheiro será retirado, com a numeração xxxx-x:\n");
                    String numAg = scan.next();
                    System.out.println("Informe a conta corrente do cliente que o dinheiro será retirado com a numeração xxxxx-xx:\n ");
                    String numconta = scan.next();
                    System.out.println("Informe o valor da transferencia:\n");
                    double valor = scan.nextDouble();
                    System.out.println("Informe a senha de 6 digitos da conta que deve ter o dinheiro retirado:\n");
                    String senha = scan.next();
                    if (oP.retornarTranferenciaPossivelContaC(numconta, numAg, valor) == true) {
                        System.out.println("Informe a agencia do outro banco para ser transferida, utilize a numeração xxxx-x:\n");
                        String numAgTransfer = scan.next();
                        System.out.println("Informe a conta do outro banco para ser transferida, utilize a numeração xxxxx-xx\n");
                        String numContaTransfer = scan.next();
                        if (oP.transferenciaDistribuida(valor, numContaTransfer, numAgTransfer) == true) {
                            oP.saqueContaCorrente(numconta, senha, valor, numAg);
                        }
                    } else {
                        System.out.println("Não é possível realizar a transferencia!");
                    }
                }
                if(escolha.equals("2")){
                    System.out.println("Informe a agencia da conta do cliente que o dinheiro será retirado, com a numeração xxxx-x:\n");
                    String numAg = scan.next();
                    System.out.println("Informe a conta corrente do cliente que o dinheiro será retirado com a numeração xxxxx-xx:\n ");
                    String numconta = scan.next();
                    System.out.println("Informe o valor da transferencia:\n");
                    double valor = scan.nextDouble();
                    System.out.println("Informe a senha de 6 digitos da conta que deve ter o dinheiro retirado:\n");
                    String senha = scan.next();
                    if(oP.retornarTranferenciaPossivelContaP(numconta,numAg,valor)==true){
                        System.out.println("Informe a agencia do outro banco para ser transferida, utilize a numeração xxxx-x:\n");
                        String numAgTransfer = scan.next();
                        System.out.println("Informe a conta do outro banco para ser transferida, utilize a numeração xxxxx-xx\n");
                        String numContaTransfer= scan.next();
                        if(oP.transferenciaDistribuida(valor,numContaTransfer,numAgTransfer)==true){
                            oP.saqueContaPoupança(numconta,senha,valor,numAg);
                        }
                    }else{
                        System.out.println("Não é possível realizar a transferencia!");
                    }
                }
            }
            System.out.println("Bem vindo, os opções são as seguintes:\n1-Cadastrar Agência\n2-Cadastrar Cliente");
            System.out.println("3-Cadastro de conta Corrente\n4-Cadastro de conta Poupança \n5-Deposito\n6-Saque\n7-Transferência para o mesmo banco\n8-Informações do cliente \n9-Saldo\n10-Transferencia para outro banco\n0- Para finalizar\n:");
>>>>>>> 8e56fb18112c00a2f37c372b345dc04a0e1aef67
            opção = scan.nextInt();
        }

    }
    //Esse metodo existe puramente para validar os valores da agência
    static boolean validarAgencia(String aG4, String aG1){
        if(aT.verificarTam4(aG4)==false){
            return false;
        }
        if(aT.verificarTam1(aG1)==false){
            return false;
        }
        System.out.println("As informações estão válidas!");
        return true;
    }
    //Esse metodo existe puramente para validar os valores para o cliente
    static boolean validarCliente(String senha,String cpf){
        if(aT.verificarSenha(senha)==false){
            return false;
        }
        if(aT.verificarCpf(cpf)==false){
            return false;
        }
        System.out.println("As informações estão válidas!");
        return true;
    }
    //Esse metodo existe puramente para validar os valores para a criação da conta corrente
    static boolean validarContaC(String aC5, String aC2, String senha,String cpf){
        if(aT.verificarCpf(cpf)==false){
            return false;
        }
        if(aT.verificarSenha(senha)==false){
            return false;
        }
        if(aT.verificarTam5(aC5)==false){
            return false;
        }
        if(aT.verificarTam2(aC2)==false){
            return false;
        }
        System.out.println("As informações estão válidas!");
        return true;
    }
    //Esse metodo existe puramente para validar os valores para a criação da conta poupança
    static boolean validarContaP(String aC5, String aC2, String senha,String cpf,String var) {
        if(aT.verificarCpf(cpf)==false){
            return false;
        }
        if(aT.verificarSenha(senha)==false){
            return false;
        }
        if(aT.verificarTam5(aC5)==false){
            return false;
        }
        if(aT.verificarTam2(aC2)==false){
            return false;
        }
        if(aT.verificarTam2(var)==false){
            return false;
        }
        System.out.println("As informações estão válidas!");
        return true;
    }


}








