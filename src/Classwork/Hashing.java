package Classwork;

public class Hashing {

    public static final int TABLE_SIZE = 13;
    public static int hash(int key, int tableSize){
        return key % tableSize;
    }


    public static void main(String[] args){
        int[] HashTable = new int[TABLE_SIZE];
        int[] values = {10,34,5,7,8};

        for (int i=0;i<values.length;i++){
            HashTable[hash(values[i],TABLE_SIZE)] = values[i];
        }
    }
}
