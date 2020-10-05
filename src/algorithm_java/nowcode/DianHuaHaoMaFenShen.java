package algorithm.nowcode;

import java.util.*;

public class DianHuaHaoMaFenShen {

    private static Map<Character,Integer> getCharCountMap(String input){
        HashMap<Character,Integer> charCountMap = new HashMap<>();
        for(char singleChar : input.toCharArray()){
            if (!charCountMap.containsKey(singleChar)) {
                charCountMap.put(singleChar,0);
            }
            charCountMap.put(singleChar,charCountMap.get(singleChar)+1);
        }
        return charCountMap;
    }
    private static List<Integer> getNumberList(Map<Character, Integer> charCountMap, Map<Integer, Map> numToCharMap,Map<Character,Integer> charToSpecificNumMap){
        List<Integer> numberList = new ArrayList<>();

        for (Character outc : charToSpecificNumMap.keySet()){
            if(!charCountMap.containsKey(outc)){
                continue;
            }
            int numCount = charCountMap.get(outc);
            int num = charToSpecificNumMap.get(outc);
            Map<Character,Integer> charMap = numToCharMap.get(num);

            numCount /= charMap.get(outc);

            for(char inc : charMap.keySet()){
                int newCount = charCountMap.get(inc) -  charMap.get(inc)*numCount;
                if(newCount == 0){
                    charCountMap.remove(inc);
                }else{
                    charCountMap.put(inc,newCount);
                }
            }

            for(int i = 0 ; i< numCount ; i++){
                numberList.add(num);
            }
        }
        return numberList;
    }

    public static void main(String[] args){
        Map<Integer,String> numToEnglishMap = new HashMap<>();
        numToEnglishMap.put(0,"EIGHT");
        numToEnglishMap.put(1,"NINE");
        numToEnglishMap.put(2,"ZERO");
        numToEnglishMap.put(3,"ONE");
        numToEnglishMap.put(4,"TWO");
        numToEnglishMap.put(5,"THREE");
        numToEnglishMap.put(6,"FOUR");
        numToEnglishMap.put(7,"FIVE");
        numToEnglishMap.put(8,"SIX");
        numToEnglishMap.put(9,"SEVEN");

        Map<Integer,Map> numToCharMap = new HashMap<>();
        for(int num : numToEnglishMap.keySet()){
            String englishNum = numToEnglishMap.get(num);
            Map<Character,Integer> charCountMap = getCharCountMap(englishNum);
            numToCharMap.put(num,charCountMap);
        }

        Map<Character,Integer> charToSpecificNumMap = new LinkedHashMap<>();
        charToSpecificNumMap.put('G',0);
        charToSpecificNumMap.put('U',6);
        charToSpecificNumMap.put('W',4);
        charToSpecificNumMap.put('X',8);
        charToSpecificNumMap.put('Z',2);

        charToSpecificNumMap.put('O',3);
        charToSpecificNumMap.put('R',5);
        charToSpecificNumMap.put('S',9);
        charToSpecificNumMap.put('F',7);
        charToSpecificNumMap.put('I',1);

        Scanner in = new Scanner(System.in);
        int groups = in.nextInt();
        while (groups-->0) {
            String fenshen = in.next();
            Map<Character,Integer> charCountMap = getCharCountMap(fenshen);
            List<Integer> numMap = getNumberList(charCountMap,numToCharMap,charToSpecificNumMap);
            Collections.sort(numMap);

            for(int i : numMap){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
