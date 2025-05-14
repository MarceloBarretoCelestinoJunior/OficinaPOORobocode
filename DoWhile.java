/*
  -Autor: Marcelo Barreto Celestino Junior
  -Data: 14/05/2025
  -Atividade: 04
  Kata: Vowel Count
*/

public class Vowels {

  public static int getCount(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    } 

    String vogais = "aeiou";
    int contavogal = 0;
    int i = 0;
    char pegavogal = 'x';
    
    do {
      pegavogal = str.charAt(i);
      if (vogais.indexOf(pegavogal) != -1) {
        contavogal++;
      }
      i++;
    } while (i < str.length());
    return contavogal;
  }

}
