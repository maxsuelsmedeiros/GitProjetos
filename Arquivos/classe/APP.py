import json
from datetime import date

from Arquivos.classe.Participante import Participante


def main(args=[]):
    menu="1"

    while menu !="3":
        menu=input("Caso deseje verificar os participantes, digite 1 caso deseje adicionar os participantes digite 2, caso deseje sair digite 3 \n:")
        if menu=="1":
            verificarParticipantes()
        if menu == "2":
            adicionarParticipantes()
        if menu == "3":
            print("Adeus!")


def verificarParticipantes():
    participantes = []
    arq = open("participantes.txt", 'r', encoding="utf8")
    jsonObjs = json.loads(arq.read())
    # Iteração dos elementos do JSON.
    for jsonObj in jsonObjs:
        nome = jsonObj["nome"]
        email = jsonObj["email"]
        data = jsonObj["nascimento"].split("-")
        nascimento = date(int(data[0]), int(data[1]), int(data[2]))
        novoParticipante = Participante(nome, email, nascimento)
        print(novoParticipante)
        participantes.append(novoParticipante)
    for t in participantes:
        print(t)
    arq.close()
def adicionarParticipantes():
    nome=input("Por favor digite o nome do novo participante!")
    email=input("Por favor digite o email do novo participante!")
    nascimento=input("Por favor digite a data de nascimento do participante dividindo por '-'(hifen) !")
    data=nascimento.split("-")
    data=date(int(data[2]), int(data[1]), int(data[0]))
    participanteNovo=Participante(nome,data,email)
    arq = open("participante.txt" , 'a+', encoding="utf8")
    jsonObjs = json.loads(arq.read())
    novoParticipante ={}
    novoParticipante['nome']=participanteNovo.nome
    novoParticipante['nascimento']=participanteNovo.nascimento
    novoParticipante['email']=participanteNovo.email
    jsonObjs.append(novoParticipante)
    json.dump(jsonObjs,arq,ensure_ascii=False, indent=4)
    arq.close()



if __name__ == '__main__':
    main()
