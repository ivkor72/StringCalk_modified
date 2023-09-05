import java.sql.SQLOutput;
import java.util.Scanner;

public class MyStringCalc {
    private static String rezult;
    private static String rez;
    private  static char operX = 0; //счетчик операции
    private static String oper = "\0"; //операция
    private static String [] mass; //массив из слов
    private static String stroka; //строка для вывода
    private static String numMass = "0123456789";
    private static boolean f=true; //флаг выхода из программы


    public static void main(String[] args){

        calc(rezult);


    }//end main

    public static String calc(String rezult) {


        String operMass = "+-*/";
        char operX = 0; //счетчик операции
        String oper = "\0"; //операция
        Scanner scan = new Scanner(System.in);
        f=true;



            System.out.println();
            System.out.println("Vvedite stroku i deystvie");
            System.out.println("Dlya vyhoda vvedite \"stop\"");
            System.out.printf("> ");
            String vvod = scan.nextLine();
        met1:
        {
   //         if (vvod.equalsIgnoreCase("stop")){scan.close(); return (rezult);}
        if (vvod.equalsIgnoreCase("stop")){
            f=true;
            break met1;}

            char[] vvodMass = vvod.toCharArray();

            for (char symb : vvodMass) {
                switch (symb) {
                    case '+':
                        oper = "\\+";
                        operX++;
                        break;
                    case '-':
                        oper = "-";
                        operX++;
                        break;
                    case '*':
                        oper = "\\*";
                        operX++;
                        break;
                    case '/':
                        oper = "/";
                        operX++;
                        break;
                }//end switch


            }//end for

            if (operX == 0) {
                System.out.println("Ne vveden znak operacii");
                f=false;
                break met1;
            }
            if (operX > 1) {
                System.out.println("Bolee odnogo znaka operacii nedopustimo");
                f=false;
                break met1;
            }

            String[] mass = vvod.split(oper); //массив из слов

            String slovo1 = mass[0];
            String slovo2 = mass[1];

            try {
                int s = Integer.parseInt(slovo1);

       //        System.out.println("Chislo ne moget byt pervym operandom");
               f=true;
                throw new IllegalStateException("Chislo ne moget byt pervym operandom");
        //        break met1;

            }//try
           catch (NumberFormatException e){}//catch


            if ((slovo1.length()>10) | (slovo2.length()>10)){
        //        System.out.println("Stroka dolgna sodergat ne bolee 10 simvolov");
                throw new NumberFormatException ("Stroka dolgna sodergat ne bolee 10 simvolov");
         //       f=true;
          //      break met1;
            }


            switch (oper) {
                case "\\+":
                    slogeniye(rezult, slovo1, slovo2);
        //            calc(rezult);
                    break;
                case "-":
                    vichitaniye(rezult, slovo1, slovo2);
                    break;
                case "\\*":
                    umnogeniye(rezult, slovo1, slovo2);
                    break;
                case "/":
                    deleniye(rezult, slovo1, slovo2);
                    break;

            }//end switch

        }//met1





        if (f==false) {calc(rezult);}
            return (rezult);




    }//end calc

    public static String slogeniye(String rezult, String slovo1, String slovo2){//сложение

        rezult = slovo1+slovo2;
        System.out.println("Resultat > "+ rezult);
        f=false;

        return rezult;}//end slogeniye

    public static String vichitaniye(String rezult, String slovo1, String slovo2){ //вычитание
        if ((slovo1.equalsIgnoreCase(slovo2) == true) ){
            rezult = "";}
            else if (slovo1.contains(slovo2)){
           rezult= slovo1.replace(slovo2,"");}
            else if ((slovo1.equalsIgnoreCase(slovo2) == false)){rezult=slovo1;}

        System.out.println("Resultat > "+ rezult);
        f=false;
        return (rezult);}// end vichitaniye

    public static String deleniye(String rezult, String slovo1, String slovo2){ //деление

        int lenthSlovo1 = slovo1.length();
     //   try {
            int s = Integer.parseInt(slovo2);
            if ((s<1) | (s>10)){
                System.out.println("Chislo dolgno byt v intervale ot 1 do 10");
                f=true;
                return (rezult);
            }
            if (lenthSlovo1 < s) {
                System.out.println("Dlina stroki menee delitelya");
                f=true;
                return (rezult);
            }
            int len = lenthSlovo1 / s;
            char[] massSlovo1 = slovo1.toCharArray();
            rezult="";
            for (int i=0; i<=(len - 1); i++){
                rezult = rezult + massSlovo1[i];
            }
    //    }//try
    //    catch (NumberFormatException e){
    //        System.out.println("Deleniye ne na chislo");
    //        f=true;
    //        return(rezult);}//catch
        System.out.println("Resultat > "+ rezult);
        f=false;
        return (rezult);}   //end deleniye

    public static String umnogeniye(String rezult, String slovo1, String slovo2){

    //    try {
            int s = Integer.parseInt(slovo2);
            if ((s < 1) | (s > 10)) {
                System.out.println("Chislo dolgno byt v intervale ot 1 do 10");
                f = true;
                return (rezult);
            }
            rezult="";
            for (int i=1; i<=s; i++){
                rezult = rezult + slovo1;
            }
            if (rezult.length()>40){
                rezult = rezult.substring(0,39) + "...";
            }
    //    }//try
   //     catch (NumberFormatException e){
   //         System.out.println("Umnogeniye ne na chislo");
    //        f=true;
    //        return(rezult);}//catch

        System.out.println("Resultat > "+ rezult);
        f=false;
         return (rezult); } // end umnogeniye


}//end MyStringCalc
