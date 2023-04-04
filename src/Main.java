import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scner = new Scanner(System.in); //Grabs Sumplete Width
        System.out.println("Enter Array Length - ");
        int length = scner.nextInt();
        System.out.println("Now, Enter Array Width - ");
        int width = scner.nextInt();
        SumpleteValue array[][] = new SumpleteValue[length + 1][width + 1];


        System.out.println("Now Enter your Sumplete Values");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // If last row & last column: bail
                if (array[i].length - 1 == j)
                {
                    if (array.length - 1 == i)
                    {
                        array[i][j] = new SumpleteValue( 0, SumpleteValue.State.CORNER);
                        break;
                    }
                }
                if (array[i].length-1 == j){
                    array[i][j] = new SumpleteValue(scner.nextInt(), SumpleteValue.State.TOTAL);
                    continue;
                }
                if (array.length-1 == i){
                    array[i][j] = new SumpleteValue(scner.nextInt(), SumpleteValue.State.TOTAL);
                    continue;
                }
                SumpleteValue.State state = SumpleteValue.State.MAYBE;


                array[i][j] = new SumpleteValue(scner.nextInt(), SumpleteValue.State.MAYBE);
            }
        }
        //Rule 1, Eliminating too high numbers
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].val > array[i][array.length - 1].val || array[i][j].val > array[array.length - 1][j].val && array[i][j].state == SumpleteValue.State.MAYBE) {
                    array[i][j].state = SumpleteValue.State.NO;
                } else if (array[i][j].val > array[array.length - 1][i].val && array[i][j].state == SumpleteValue.State.MAYBE) {
                    for (int o = 0; o < array.length; o++) {
                        for (int k = 0; k < array[o].length; k++) {
                            array[o][k].state = SumpleteValue.State.NO;
                        }
                    }


                }
            }
        }

        //Rule Main
        int Sum = 0;
        int Grongle=1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 2; j++) {
                if (array[i][j].val + array[i][j+Grongle].val == array[i][array.length - 1].val) {
                    array[i][j].state = SumpleteValue.State.YES;
                    array[i][j + Grongle].state = SumpleteValue.State.YES;
                    break;
                } else if (array[i][j].val + array[i][j+Grongle].val < array[i][array.length - 1].val) {
                    Sum += array[i][j].val + array[i][j+Grongle].val;
                    if(Sum == array[i][array.length - 1].val){

                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
    }
}