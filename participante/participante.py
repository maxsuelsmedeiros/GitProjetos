class  Participante():

    # Criação de participante e seus dados iniciais
    def __init__(self,nome,cpf,contato):
        self.nome=nome
        self.cpf=nome
        self.contato=contato
    # Verificação de dados do participante
    def __str__(self):
        return ("Nome: %s \n CPF: %s \n Contato: %s" %(self.nome,self.cpf,self.contato))

    # Verificar se um partifipante é igual a outro

    def __eq__(self, other):
        return self.nome == other.nome and self.cpf == other.cpf and self.contato == other.contato