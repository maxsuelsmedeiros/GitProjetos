package autenticarDados;

public class Autenticar {

    /*Todas as informações de senha, número de contas e número de agencias só devem ser compostas por
    números de 0..9, então deve se passar por autenticar, os outros metodos tem funções mais especificas
    para cada uma, mas para não ficar repetitivo e nem "encher" o main
    */
    public boolean autenticar(String autent){
        try{
            long valor= Long.valueOf(autent);

        }catch (NumberFormatException ex) {
            System.out.println("O valor informado não esta de acordo com os valores adequados!");
            ex.getMessage();
            return false;
        }

        return true;
    }

    //Verificar tanto os primeiros 5 digitos da conta corrente e poupança

    public boolean verificarTam5(String numConta){
        if(numConta.length() == 5){
            if (autenticar(numConta)==false){
                return false;
            }
            return true;
        }
        System.out.println("O tamanho esta incorreto, digite o número da conta com o tamanho correto!");
        return false;
    }

    //Verificar o tamanho dos valores de agencia
    public boolean verificarTam4(String agencia){
        if(agencia.length() == 4){
            if (autenticar(agencia)==false){
                return false;
            }
            return true;
        }
        System.out.println("O tamanho esta incorreto, digite o número da conta com o tamanho correto!");
        return false;
    }

    //Verificar os 2 ultimos digitos as contas
    public boolean verificarTam2(String numConta){
        if(numConta.length() == 2){
            if (autenticar(numConta)==false){
                return false;
            }
            return true;
        }
        System.out.println("O tamanho esta incorreto, digite o número da conta com o tamanho correto!");
        return false;
    }

    //Verificar o ultimo digito da agencia
    public  boolean verificarTam1(String agencia){
        if(agencia.length()==1){
            if(autenticar(agencia)==false){
                return false;
            }
            return true;
        }
        System.out.println("O tamanho esta incorreto, digite o número da conta com o tamanho correto!");
        return false;
    }

    //Verificar se a senha vai possuir os 6 digitos
    public boolean verificarSenha(String senha){
        if(senha.length() == 6){
            if(autenticar(senha)==false){
                System.out.println("ERROR SENHA");
                return false;
            }
        return true;
        }
        System.out.println("O tamanho esta incorreto, digite o número da conta com o tamanho correto!");
        return false;
    }

    //Verificar se o cpf possui 11 digitos
    public boolean verificarCpf(String cpf){
        if(cpf.length() == 11){
            if(autenticar(cpf)==false){
                System.out.println("ERROR CPF");
                return false;
            }
            return true;
        }
        System.out.println("O tamanho esta incorreto, digite o número do cpf com o tamanho correto!");
        return false;
    }
}
