public class Print {
    public int compNsq, compN, compDbl;
    long clockNsq, clockN, clockDbl;

    public Print(){
        this.compNsq = 0;
        this.compN = 0; 
        this.compDbl = 0;
        this.clockNsq = 0;
        this.clockN = 0; 
        this.clockDbl = 0;
    }

    public Print(long a, Long b, long c, int x, int y, int z){
        this.compNsq = x;
        this.compN = y; 
        this.compDbl = z;
        this.clockNsq = a;
        this.clockN = b; 
        this.clockDbl = c;
    }
    public static void print(Print p) {
        System.out.printf("%5s %5s %18s %15s %15s %20s", "O(n^2)", "O(N)", "Printing String", "Comp for N^2", "Comp fo N", "Comp for print\n");
        System.out.printf("%1dms %5dms %10dms %20d %15d %18d", p.clockNsq, p.clockN, p.clockDbl, p.compNsq, p.compN, p.compDbl);
        System.out.println();
    }
}