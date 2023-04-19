package perceptron_digitos;
/**
 *
 * @author Clarimundo
 */
public class Validacao {
    
    
    public double [] somatorio(int mat[][], double w[][]){
        
        double yent[] = {0,0,0,0};  
        double entrada[] = new double[16];
        int l=1;
        entrada[0]=1;
        for(int i=0; i<5; i++)
            for(int j=0; j<3; j++){
                entrada[l] = mat[i][j]; //joga os valores adicionados dentro da variavel entrada
                l++;
            }        
        for(int j=0;j<16;j++){
            for(int n=0;n<4;n++)
                yent[n] = yent[n] + entrada[j]*w[j][n]; // calcula o yent para os valores de entrada
        }            
        return yent;
    }

    public double [] saida(double yent[], double limiar){
        double f[]= new double [4];
        
        for(int n=0;n<4;n++)
            if(yent[n] > limiar)
               f[n] = 1;
            else 
               if(yent[n] < -limiar)
                  f[n] = -1;          
               else
                  f[n] = 0;
        return f;
    }
  
    public String teste(int mat[][], double w[][], double t[][], double limiar){
              
       double yent[] = somatorio(mat,w);
       double f[] = saida(yent,limiar);
       
       if(f[0] == t[0][0] && f[1] == t[0][1] && f[2] == t[0][2] && f[3] == t[0][3])
           return "0";
       else if(f[0] == t[1][0] && f[1] == t[1][1] && f[2] == t[1][2] && f[3] == t[1][3])
            return "1";
       else if(f[0] == t[2][0] && f[1] == t[2][1] && f[2] == t[2][2] && f[3] == t[2][3])
            return "2";
       else if(f[0] == t[3][0] && f[1] == t[3][1] && f[2] == t[3][2] && f[3] == t[3][3])
            return "3";
       else if(f[0] == t[4][0] && f[1] == t[4][1] && f[2] == t[4][2] && f[3] == t[4][3])
            return "4";
       else if(f[0] == t[5][0] && f[1] == t[5][1] && f[2] == t[5][2] && f[3] == t[5][3])
            return "5";
       else if(f[0] == t[6][0] && f[1] == t[6][1] && f[2] == t[6][2] && f[3] == t[6][3])
            return "6";
       else if(f[0] == t[7][0] && f[1] == t[7][1] && f[2] == t[7][2] && f[3] == t[7][3])
            return "7";
       else if(f[0] == t[8][0] && f[1] == t[8][1] && f[2] == t[8][2] && f[3] == t[8][3])
            return "8";
       else if(f[0] == t[9][0] && f[1] == t[9][1]  && f[2] == t[9][2] && f[3] == t[9][3])
            return "9";
       else
            return "?";             
    }             
}