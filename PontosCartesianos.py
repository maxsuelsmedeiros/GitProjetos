class point():

    def __init__(self):
        self.pointX=None
        self.pintY=None

    def __add__(self, other):
        return self+other

    def __str__(self):
        pontoX=str(self.pointX)
        pontoY=str(self.pintY)
        print("ponto x:" + pontoX + " /n ponto y" + pontoY )

    def solicitandoPontos(self):
        self.pointX=int(input("Por favor informe a posição do elemento em relação a X do plano"))
        self.pintY=int(input("Por favor informe a posição do elemento em relação a Y do plano"))
