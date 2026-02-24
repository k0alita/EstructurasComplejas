package ejemplos;

import java.util.*;
import java.util.List;

public class Ejemplo2 {
    static void main(String[] args) {
        Collection<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(10);
        numeros.add(10);
        numeros.add(10);

        List<Integer> nums = new ArrayList<>();
        nums.add(12);
        System.out.println(nums);
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
    }
}
