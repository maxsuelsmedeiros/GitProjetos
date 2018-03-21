from Pessoa import Pessoa

def main(args=[]):
    print("Informe os dados necessário para cadastro\n")
    nome=input("Nome da Pessoa: ")
    email=input("Email da pessoa: ")
    id=str(input("ID da pessoa: "))
    P1=Pessoa(nome,email,id)
    pCadastrada=P1.cadastro()
    print(P1) # Aqui imprime os valores do construtor que foram atribuido ao objeto P1 que é do tipo pessoa
    print(pCadastrada) # O cadastro retorna um objeto do tipo pessoa, com as mesmas informações da pessoa P1

if __name__=='__main__':
    main()
