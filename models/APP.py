from PontosCartesianos import point
def main(args = []):
    p=point()
    p2=point()
    p.solicitandoPontos()
    p2.solicitandoPontos()
    print(p+p2)

if __name__=="__main__":
    main()
