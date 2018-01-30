from .Pessoa.Pessoa import pessoa
class  Participante(pessoa):

    # Criação de participante e seus dados iniciais
    def __init__(self,pNome,sNome,cpf,nascimento,genero,contato):
        self.primeiroNome=pNome
        self.sobreNome=sNome
        self.cpf=cpf
        self.nascimento=nascimento
        self.genero=genero
        self.contato=contato

