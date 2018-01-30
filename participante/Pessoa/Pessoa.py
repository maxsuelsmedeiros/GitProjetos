class pessoa():

    def __init__(self,pNome,sNome,cpf,nascimento,genero):
        self.primeiroNome=pNome
        self.sobreNome=sNome
        self.cpf=cpf
        self.nascimento=nascimento
        self.genero=genero

    def __str__(self):
        return ("Primeiro Nome: %s \n Sobre Nome: %s \n CPF: %s \n Nascimento:%s \n Genero: %s" %(self.primeiroNome,self.sobreNome,self.cpf,self.nascimento,self.genero))

    def __eq__(self, other):
        return self.primeiroNome == other.primeiroNome and self.sobreNome == other.sobreNome and self.cpf == other.cpf and self.nascimento == other.nascimento and self.genero == other.genero

    def getNomeCompleto(self):
        return self.primeiroNome + " " + self.sobreNome

    def getCpf(self):
        return self.cpf

    def getNascimento(self):
        return self.nascimento

    def getGenero(self):
        return self.genero