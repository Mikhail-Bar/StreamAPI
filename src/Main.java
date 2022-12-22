import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //Сгенерироваь массив последовательных натуральных чисел в заданном диапазоне
        System.out.println(Arrays.toString(genNatural(1,9)));
        //Отфильтровать нечетные числа
        System.out.println(Arrays.toString(genEven(1,9)));

        int [] arr = genNatural(1,9);
        int [] arr2 = Arrays.stream(arr)
                .filter(n->n%2==0)
                .toArray();
        System.out.println(Arrays.toString(arr2));

        //Получить сумму чисел
        System.out.println(Arrays.stream(arr).sum());

        //Получить кол-во
        System.out.println(Arrays.stream(arr).count());
        //Сгенерироваь массив случайных натуральных чисел чисел в заданном диапазоне
        System.out.println(Arrays.toString(genRandom(1,10,10)));

        //Вывести все числа от 1 до 1000, которые делятся на 3, 5, и 11
        System.out.println(Arrays.toString(gen3_5_11(1,1000)));

        //Вывести квадраты первых n натуральных чисел
        System.out.println(Arrays.toString(genSquares(1,10)));
        System.out.println(Arrays.toString(genSquares2(10)));

        //Степени числа 2


    }

    static int[] genNatural( int min, int max){
        return IntStream
                .range(min,max+1)
                .toArray();
    }
    static int[] genEven( int min, int max){
        return IntStream
                .range(min,max+1)
                .filter(n->n%2==0)
                .toArray();
    }
    static int[] genRandom( int min, int max, int count){
        Random random = new Random();
        return IntStream
                .generate(()->random.nextInt(max-min+1)+min)
                .limit(count)
                .toArray();
    }
    static int[] gen3_5_11( int min, int max){
        return IntStream
                .range(min,max+1)
                .filter(n->n%3==0||n%5==0||n%11==0)
                .toArray();
    }
    static int[] genSquares( int min, int max){
        return IntStream
                .range(min,max+1)
                .map(n->n*n)
                .limit(100)
                .toArray();
    }
    static int[] genSquares2(int count){
        return IntStream
                .iterate(1, i -> i + 1)
                .filter(n->Math.abs((int)Math.sqrt(n)-Math.sqrt(n))<1e-10)
                .limit(10)
                .toArray();
    }


}
