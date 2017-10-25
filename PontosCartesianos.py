class point(object):

    def __init__(self):
        self.pointX=None
        self.pointY=None

    def __add__(self, novo):
        pX=self.pointX+novo.pointX
        pY=self.pointY+novo.pointY
        return (pX,pY)

    def __str__(self):
        pontoX=str(self.pointX)
        pontoY=str(self.pointY)
        print("ponto x:" + pontoX + " /n ponto y" + pontoY )

    def solicitandoPontos(self):
        self.pointX=int(input("Por favor informe a posição do elemento em relação a X do plano: "))
        self.pointY=int(input("Por favor informe a posição do elemento em relação a Y do plano: "))
