package contaCorrente;

/*Essa classe utiliza a classe conta como super classe conta, que receber já tanto seus atributos, como
 * métodos e até mesmo utilizar seu construtor
 */
//Esse valor de saldo especial deve ser trocado para cheque especial e deve ser atribuido um limite a ele?
//talvez ele deva se tornar um atributo static final para não ser alterado,perguntar ao professor
import conta.Conta;
import agencia.Agencia;
public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente(String conta,String senha,String cpf, double saldo,double saldoEspecial, String agencia){
        super(conta,senha,cpf,saldo,agencia);
        this.chequeEspecial=saldoEspecial;
    }

    public void setChequeEspeciall(double saldoEspecial) {
        this.chequeEspecial = saldoEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }
}
