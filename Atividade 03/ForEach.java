/*
  -Autor: Marcelo Barreto Celestino Junior
  -Data: 14/05/2025
  -Atividade: 04
  Kata: Vowel Count
*/

public class Vowels {

  public static int getCount(String str) {
    if( str == null || str.length() == 0){
      return 0;
    }
    
    String vogais = "aeiou";
    int i = 0;
    int contavogal = 0;
    
    for(char letratual : str.toCharArray()){
      System.out.println(letratual);
      if(vogais.indexOf(letratual) != -1){
        contavogal++;
      }
      i++;
    }
    return(contavogal);
  }

}
