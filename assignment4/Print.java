public class Print {
    public int encodeLength, decodeLength;
    long encodeTime, decodeTime;

    public Print(){
        this.encodeLength = 0; 
        this.decodeLength = 0;
        this.encodeTime = 0;
        this.decodeTime = 0; 
    }

    public Print(long encodeTime, Long decodeTime, int encodeLength, int decodeLength){
        this.encodeTime = encodeTime; 
        this.decodeTime = decodeTime;
        this.encodeLength = encodeLength;
        this.decodeLength = decodeLength; 
    }
    public static void print(Print p) {
        System.out.println();
        System.out.printf("%15s %25s %25s %15s", "Size preEncode", "Size postEncoding", "Time encoding","\n");
        System.out.printf("%10dbits %20dbits %20dms", p.encodeLength, p.decodeLength, p.encodeTime);
        System.out.println();
    }
}