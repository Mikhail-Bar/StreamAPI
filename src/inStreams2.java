import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class inStreams2 {
    public static void main(String[] args) {


        System.out.println(Arrays.toString(gen33(10)));
        System.out.println(Arrays.toString(genFib(1000)));
        System.out.println(Arrays.toString(gen101()));
        System.out.println(Arrays.toString(gen123()));
        System.out.println(sum20());
        System.out.println(Arrays.toString(genPrime(10)));
        System.out.println(maxPrimeFactor(42));

    }

    //Последовательность чисел 3, 33, 333 .... n
    public static int[] gen33(int count){
        return IntStream.iterate(3,n->n*10+3)
                .limit(count)
                .toArray();
    }
    //Числа Фибоначчи: 1 1 2 3 5 8 13 21 ...
    public static long[] genFib(long max){
        return Stream.iterate( new long[] {0,1}, a-> a[0] < max , a->new long[]{a[1],a[0]+a[1]})
                .mapToLong(a->a[0])
                .toArray();
    }
    //Сгенерировать последовательность чисел: 10 1 9 2 8 3 7 4 6 5 5 6 4 7 3 8 2 9 1 10
    public static int[] gen101(){
        return Stream.iterate( new int[] {10,1}, a -> a[0]!=0, a->new int[]{a[0]- 1, a[1] + 1})
                .flatMapToInt(IntStream::of)
                .toArray();
    }
    //Сгенерировать последовательность чисел:1 2 4 7 11 16 22 29 ..
    public static int[] gen123(){
        return Stream.iterate( new int[] {1,1}, a -> a[0]<30, a->new int[]{a[0]+a[1], a[1] + 1})
                .mapToInt(a->a[0])
                .toArray();
    }
    //Первое число, сумма цифр которого равна 20(или несколько первых таких чисел)
    public static int sum20(){
        return Stream.iterate(new int[]{1,1}, a->new int[]{++a[0],sum(Integer.toString(a[0]).chars().toArray())})
                .filter(a->a[1]==30)
                .mapToInt(a->a[0])
                .limit(1)
                .findFirst().orElse(0);

    }
    static int sum(int[] arr){
        int result = 0;
        for(int a:arr) result+=a - '0';
        return result;
    }
    //Вывести n первых простых чисел
    public static int[] genPrime(int count){
        return IntStream.iterate(1,n->n+1)
                .filter(n->isPrime(n))
                .limit(count)
                .toArray();
    }
    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
    //Максимальный простой делитель числа
    public static int maxPrimeFactor(int number) {
        return IntStream.rangeClosed(2, number/2)
                .filter(n->number%n==0)
                .filter(n->isPrime(n))
                .max().getAsInt();
    }
}
