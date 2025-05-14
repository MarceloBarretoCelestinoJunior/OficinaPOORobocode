/*
  -Autor: Marcelo Barreto Celestino Junior
  -Atividade: 02
  -Kata: Quadrants
  -Data: 06/05/2025
*/
public class Kata {
  
  public static int quadrant(int x, int y) {
   
    if( x > 0 && y > 0 ){
      System.out.println("Esse conjunto se encontra no quadrante 1!");
      return 1;
    } else if( x < 0 && y > 0){
      System.out.println("Esse conjunto se encontra no quadrante 2!");
      return 2;
    } else if(x < 0 && y < 0){
      System.out.println("Esse conjunto se encontra no quadrante 3!");
      return 3;
    } else {
      System.out.println("Esse conjunto se encontra no quadrante 4!");
    return 4;
     }
  }
