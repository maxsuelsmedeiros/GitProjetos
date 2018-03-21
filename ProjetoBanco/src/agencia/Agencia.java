package agencia;

import java.util.ArrayList;
import cliente.Cliente;

public class Agencia {
    private String numeroAgencia;
    private String endereço;
    private ArrayList<Cliente> listaCliente;

    public Agencia(String numeroAgencia,String endereço){
        this.numeroAgencia=numeroAgencia;
        this.endereço=endereço;
        this.listaCliente = new ArrayList();
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void AdicionarCliente(Cliente cliente){
        this.listaCliente.add(cliente);
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public String getEndereço() {
        return endereço;
    }

    public ArrayList<Cliente> getListaCliente(){
        return this.listaCliente;
    }
}
