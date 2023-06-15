import java.util.ArrayList;

public class teste {

	//PROGRAMA = x
	//DEC = y
	//COMANDOS = z
	//TIPO = c

	public static void main(String[] args) {
		String[] transicao = new String[] { "q,programa,x,q,x", "q,id,x,q,xzy" , "q,return,z,q,e" , "q,id,y,q,c" , "q,char,c,q,e", 
				"q,int,c,q,e" , "q,vetor,c,q,e" , "q,id,z,q,c" };
		ArrayList<String> pilha = new ArrayList<String>();
		pilha.add("x");
		String estado = "q";
		String entrada = "programa id id char id char";
		String split[] = entrada.split(" ");
		
        for (String palavra : split) {
            for(String tr : transicao) {
            	String splitTransicao[] = tr.split(",");
            	if (splitTransicao[0].equals(estado) && splitTransicao[1].equals(palavra) && splitTransicao[2].equals(pilha.get(pilha.size()-1))) {
					estado = splitTransicao[3];
					if (splitTransicao[4].length() > 1) {
						//se a modificação de pilha tiver 2 elementos = mantém o anterior e adiciona um novo topo
						String splitdosplit[] = splitTransicao[4].split("");
						for (int i = 0; i < splitdosplit.length-1; i++) {
							pilha.add(splitdosplit[i+1]);
						}
					}else {
						//se a modificação de pilha tiver 1 caracter = modifica o topo pelo elemento
						pilha.remove(pilha.size()-1);
						if (!splitTransicao[4].equals("e")) {
							//se a modificação de pilha for vazio(e) = remove
							pilha.add(splitTransicao[4]);
						}
					}
					break;
				}
            }
        }
        
        System.out.println(pilha);
        if (pilha.get(pilha.size()-1).equals("x")) {
			System.out.println("Aceita");
		}else {
			System.out.println("Não Aceita");
		}
	}
	
}
