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
        System.out.printf("%10s %10s %100s", "Length preEncode", "Length postEncoding", "Time encoding","\n");
        System.out.printf("%1d %10d %10dms", p.encodeLength, p.decodeLength, p.encodeTime);
        System.out.println();
    }
}