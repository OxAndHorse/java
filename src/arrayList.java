package src;


import java.util.ArrayList;
import java.util.List;

public class arrayList {
    public  static void main(String args[]){
//        int[] nums={1,2,3};
////        System.out.println(nums);
////        System.out.println("Hello, World!");
        ArrayList<String> listOfStrings = new ArrayList<>();
//        listOfStrings.add("123");
//        listOfStrings.add("java");
//        listOfStrings.add("hava");
//
//        String[] strs=listOfStrings.toArray(new String[listOfStrings.size()]);
//        Arrays.sort(strs);
//        for (String str: strs) System.out.println(str);
//        listOfStrings.sort(Comparator.naturalOrder());
//        for (String str: listOfStrings) System.out.println(str);
//        System.out.println();
//        ArrayList<List<Integer>> array1=new ArrayList<>();
        List<List<Integer>> list=new ArrayList<>();
//        System.out.println(list.getClass());
////        List<Integer> list=new List<>();
//        array1.add(Arrays.asList(nums[0],nums[1],nums[2]));
//        System.out.println(list.add(Arrays.asList(1,2,4)));
//        System.out.println((Arrays.asList(1,2,4)).getClass());
//        System.out.println(listOfStrings);


        String [] str=new String[10];
        Class< ? extends String[]> strclz=str.getClass();
        System.out.println(strclz.getName());

        int [][] Int=new int[1][2];
        Class<? extends int[][]> Intclz=Int.getClass();
        System.out.println(Intclz.getName());
        Class Intclz1=Int.getClass();
        System.out.println(Intclz1.getName());


        int [] a=new int[2];
        Class aclz=a.getClass();
        Class<? extends int[]> a_1=a.getClass();
        System.out.println(aclz.getName());





    }

}
