public class JAVA_basic_print_datatypes_variable {
    public static void main(String[] args){
        System.out.println("Hello World");//println gets to new line same as endl
        System.out.print("Bye");//print doesn't go to new line
        int a=4;//variable declaration
        System.out.println(a);

        //data types in java

        byte b = 100;//byte-range is -128 to 127 (1 byte / 8 bits)
        System.out.println(b);

        short s = 20000;//short-range is -32,768 to 32,767 (2 bytes / 16 bits)
        System.out.println(s);

        int i = 123456;//int-range is -2^31 to (2^31 - 1) (4 bytes / 32 bits), most commonly used
        System.out.println(i);

        long l = 9999999999L;//long-range is -2^63 to (2^63 - 1) (8 bytes / 64 bits), needs L suffix
        System.out.println(l);

        float f = 3.14f;//float is single precision decimal (4 bytes), needs f suffix, ~6-7 digit precision
        System.out.println(f);

        double d = 3.14159265;//double is double precision decimal (8 bytes), default for decimals, ~15 digit precision
        System.out.println(d);

        char c = 'A';//char stores one Unicode character (2 bytes), range 0 to 65535 (\u0000 to \uffff)
        System.out.println(c);

        boolean bool = true;//boolean stores true/false only, size is JVM dependent (usually 1 bit logically, 1 byte in practice)
        System.out.println(bool);

        //implicit typecasting (widening) - small type to big type, done automatically by compiler, no data loss
        int implicitInt = 10;
        double implicitDouble = implicitInt;//int automatically converted to double
        System.out.println(implicitDouble);//prints 10.0

        char implicitChar = 'A';
        int charToInt = implicitChar;//char automatically converted to int (uses ASCII/Unicode value)
        System.out.println(charToInt);//prints 65

        //explicit typecasting (narrowing) - big type to small type, done manually by us, can cause data loss
        double explicitDouble = 9.78;
        int explicitInt = (int) explicitDouble;//manually casting double to int, decimal part is dropped not rounded
        System.out.println(explicitInt);//prints 9

        int bigNumber = 130;
        byte explicitByte = (byte) bigNumber;//manually casting int to byte, 130 is outside byte range so it overflows
        System.out.println(explicitByte);//prints -126 (wraps around due to overflow)

        long bigLong = 100000L;
        int explicitLongToInt = (int) bigLong;//manually casting long to int
        System.out.println(explicitLongToInt);//prints 100000, fine here since it's within int range
    }
}