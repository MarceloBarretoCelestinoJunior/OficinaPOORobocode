/*
  -Autor: Marcelo Barreto Celestino Junior
  -Data: 14/05/2025
  -Atividade: 04
  Kata: Basic Mathematical Operations
*/


public class BasicOperations
{
  public static Integer basicMath(String op, int v1, int v2){
    if (op == null || op.length() == 0){
      return 0;
    }
   
    switch (op){
        case "+":
          return somar(v1, v2);
        
        case "-":
          return subtrair(v1, v2);
        
        case "*":
          return multiplicar(v1, v2);
        
        case "/":
          return dividir(v1, v2);
        
        default:
          return 0;
    }
  }
    
    public static int somar (int v1, int v2){
      System.out.println(v1 + v2);
      return v1 + v2;
      }
      
    public static int subtrair (int v1, int v2){
      System.out.println(v1 - v2);
      return v1 - v2;
    }
    
    public static int multiplicar (int v1, int v2){
      System.out.println(v1 * v2);
      return v1 * v2;
    }
    
    public static int dividir (int v1, int v2){
      System.out.println(v1 / v2);
      return v1 / v2;
    }
    }
