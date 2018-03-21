from PessoaInterface import PessoaInterface
class Pessoa(PessoaInterface):

    def __init__(self,nome,email,id):
        self.nome=nome
        self.email=email
        self.id=id

    def __str__(self):
        return ("O nome da pessoa cadastrada é: %s \n O email da pessoa cadastrada é: %s \n O ID da pessoa cadastrada é:%s"%(self.nome,self.email,self.id))

    def atualizar(self,Pessoa):
        pass
    def remover(self,Id):
        pass
    def cadastro(self):
        print("Cadastrando")
        P= Pessoa(self.nome,self.email,self.id)
        return P
