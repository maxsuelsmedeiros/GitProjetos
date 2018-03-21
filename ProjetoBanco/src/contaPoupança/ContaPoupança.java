package contaPoupança;

/*Essa classe utiliza a classe conta como super classe conta, que receber já tanto seus atributos, como
* métodos e até mesmo utilizar seu construtor
*/
//Será que essa taxa de variação mensal realmente é útil? verificar com o professor
import conta.Conta;
import agencia.Agencia;
public class ContaPoupança extends Conta {
    private String variação;

    public ContaPoupança(String conta,String senha,String cpf, double saldo,String variação, String agencia){
        super(conta,senha,cpf,saldo,agencia);
        this.variação=variação;
            }

    public void setVariação(String variação) {
        this.variação = variação;
    }


    public String getVariação() {
        return variação;
    }
}

