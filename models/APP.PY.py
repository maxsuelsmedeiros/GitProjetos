from PontosCartesianos import point
def main(String = []):
    p=point()
    p2=point()
    p3=point()
    p.solicitandoPontos()
    p2.solicitandoPontos()
    p3=p+p2
    print(p3)
if __name__=="__main__":
    main()
