package Week6;

public class ProgrammingContest {
    public static void main(String[] args) {
        framingSquares(2,3,1,2);
        System.out.println();
        framingSquares(3,4,1,2);

        diamonds("CANADA");
        wordFrame("CANADA");
        loopTest();
    }
    private static void loopTest() {
        for(int i=0; i<10; i++){
            System.out.print(i);
        }
    }

    private static void wordFrame(String str) {
        System.out.println("*"+str+"*");
        for(int a=str.length()-1; a>=0; a--){
            System.out.print(str.substring(a, a+1));
            for(int i=0; i<str.length(); i++){
                System.out.print("*");
            }
            System.out.println(str.substring(str.length()-a-1, str.length()-a));
        }

        System.out.print("*");
        for(int a=str.length()-1; a>=0; a--){
            System.out.print(str.substring(a, a+1));
        }
        System.out.println("*");
    }

    private static void diamonds(String str) {
        for(int j=0; j<str.length()-1;j++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
        //FORWARD
        for(int i = 1; i < str.length(); i++){
            String letter = str.substring(i, i+1);
            for(int j=0; j<str.length()-i-1;j++){
                System.out.print(" ");
            }
            System.out.print(letter);

            for(int j=0; j<2*i-1;j++){
                System.out.print(" ");
            }
            System.out.print(letter);

            System.out.println();
        }

        //BACKWORD
        for(int i = str.length()-2; i >= 1; i--){
            String letter = str.substring(i, i+1);
            for(int j=0; j<str.length()-i-1; j++){
                System.out.print(" ");
            }
            System.out.print(letter);

            for(int j=0; j<2*i-1;j++){
                System.out.print(" ");
            }
            System.out.print(letter);

            System.out.println();
        }

        for(int j=0; j<str.length()-1;j++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
        
    }


    /**
     * 
     * @param M - height of picture
     * @param N - width of picture
     * @param P - padding/margin width
     * @param Q - frame width
     */

    private static void framingSquares(int M, int N, int P, int Q) {
        // TOP PART OF THE FRAME

        for(int i = 0; i < Q; i++){
            for(int j=0; j<N+2*P+2*Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < P; i++){
            for(int j=0; j<Q; j++){
                System.out.print("#");
            }
            for(int j=0; j<2*P+N; j++){
                System.out.print("+");
            }
            for(int j=0; j<Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < M; i++){
            for(int j=0; j<Q; j++){
                System.out.print("#");
            }
            for(int j=0; j<P; j++){
                System.out.print("+");
            }
            for(int j=0; j<N; j++){
                System.out.print(".");
            }
            for(int j=0; j<P; j++){
                System.out.print("+");
            }
            for(int j=0; j<Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < P; i++){
            for(int j=0; j<Q; j++){
                System.out.print("#");
            }
            for(int j=0; j<2*P+N; j++){
                System.out.print("+");
            }
            for(int j=0; j<Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        for(int i = 0; i < Q; i++){
            for(int j=0; j<N+2*P+2*Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
