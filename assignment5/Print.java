public class Print {
    int index, compare;
    long time; 
    String text, search;

    public Print(){
        this.index = 0; 
        this.compare = 0; 
        this.time = 0; 
        this.text = "";
        this.search = "";
    }

    public Print(int index, int compare, long time, String text, String search){
        this.index = index; 
        this.compare = compare; 
        this.time = time; 
        this.text = text;
        this.search = search;
    }
    public static void print(Print p) {
        System.out.println();
        System.out.printf("%15s %25s %25s %25s %25s %1s", "First Index", "Comparisons", "Time","Input Text","Search word", "\n");
        System.out.printf("%15d %22d %25dms %25s %25s", p.index, p.compare, p.time, p.text, p.search);
        System.out.println();
    }
}