package perceptron_digitos;

/**
 *
 * @author Clarimundo
 */
public class Aprendizagem {

    private double x[][] = { 
        { 
            { 1, 1, 1, 1, 1, -1, 1, 1, -1, 1, 1, -1, 1, 1, 1, 1 },
            { 1, -1, 1, -1, 1, 1, -1, -1, 1, -1, -1, 1, -1, 1, 1, 1 },
            { 1, 1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, 1, 1, 1 },
            { 1, 1, -1, 1, -1, -1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, -1, -1, 1, -1, -1, 1 },
            { 1, 1, 1, 1, 1, -1, -1, 1, 1, 1, -1, -1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1, -1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, -1, -1, 1, -1, -1, 1, 1, -1, 1, -1, -1, 1 },
            { 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1 }
    };

    private double w[][] = new double[16][4];
    private double t[][] = { 
            { -1, -1, -1, -1 },
            { -1, 1, -1, -1 },
            { -1, -1, 1, -1 },
            { -1, 1, 1, -1 },
            { -1, 1, 1, 1 },
            { 1, -1, -1, -1 },
            { 1, 1, -1, -1 },
            { 1, -1, 1, -1 },
            { 1, 1, 1, -1 },
            { 1, 1, 1, 1 }
    };
    private int epocas;

    public Aprendizagem() {
        epocas = 0;
    }

    public double[] getw() {
        return w;
    }

    public double[] gett() {
        return t;
    }

    public int getepocas() {
        return epocas;
    }

    public double somatorio(int i, int n) {
        double yent = 0;
        for (int j = 0; j < 16; j++)
            yent = yent + x[i][j] * w[j][n];
        return yent;
    }

    public double saida(double yent, double limiar) {
        double f;

        if (yent > limiar)
            f = 1;
        else if (yent < -limiar)
            f = -1;
        else
            f = 0;
        return f;
    }

    public void atualiza(double alfa, double f[]) {
        for (int i = 0; i < 10; i++)
            for(int n = 0;  n< 4; n++)
                for (int j = 0; j < 16; j++)
                w[j][n] = w[j][n] + alfa * (t[i][n] - f[n]) * x[i][j];
    }

    public void algoritmo(double alfa, double limiar) {
        double yent[4];
        double f[] = { 0, 0, 0, 0 };
        boolean mudou;

        for (int j = 0; j < 16; j++) // zerar os pesos
            for(int i =0; i< 4; i++)
            w[j][i] = 0;
        do {
            mudou = false;
            for (int i = 0; i < 10; i++) { // 10 padrões de entrada (digito 0) a (digito 9)
              for( int n = 0; n < 4; n++){
                yent[n] = somatorio(i, n);
                f[n] = saida(yent[n], limiar);
              }
                if (f[0] != t[i][0] || f[1] != t[i][1] || f[2] != t[i][2] || f[3] != t[i][3] )
                    mudou = true;
            }
            if (mudou == true)
                atualiza(alfa, f[]);
            epocas++;
        } while (mudou == true);
    }
}
