from datetime import date
class Participante():

    def __init__(self,nome,data,email):
        self.nome=nome
        self.nascimento=data
        self.email=email

    def __str__(self):
        data=str(self.nascimento)
        return ("O nome do participante é: %s\n seu nascimento é: %s \n seu email é: %s" %(self.nome,self.nascimento,self.email))
