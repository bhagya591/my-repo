package com.binaryreversal;

public class BinaryReversalApp {
    public static void main(String[] args) {
        System.out.println(BinaryReversal("47"  ));

        for (int i = 0; i < 32; i++) {
            System.out.println(BinaryReversal("" + ((int) Math.pow(2, i))));
        }
    }



    /*
    Have the function BinaryReversal(str) take the str parameter being passed, which will be a positive integer,
    take its binary representation (padded to the nearest N * 8 bits)
    , reverse that string of bits, and then finally return the new reversed string in decimal form.
    For example: if str is "47" then the binary version of this integer is 101111 but we pad it to be 00101111.
    Your program should reverse this binary string which then becomes: 11110100 and
    then finally return the decimal version of this string, which is 244.
     */

    static long BinaryReversal(String inputString) {
        int parsedNumber = Integer.parseInt(inputString);
        int N = 0;
        int temp = parsedNumber;
        while (temp > 0) {
            N += 8;
            temp /= 256;
        }
        String binString = String.format("%" + N + "s", Integer.toBinaryString(parsedNumber)).replace(' ', '0');
        System.out.println(parsedNumber + "==>" + binString);
        String revbinString = new StringBuilder(binString).reverse().toString();
        return Long.parseLong(revbinString, 2);

    }
}


