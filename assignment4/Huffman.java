import java.util.*;
import java.io.*;

// A Tree node
class Node{
	char ch;
	int freq;
	Node left = null, right = null;

	Node(char ch, int freq)
	{
		this.ch = ch;
		this.freq = freq;
	}

	public Node(char ch, int freq, Node left, Node right) {
		this.ch = ch;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
}

public class Huffman{
    static int preencoding = 0;
    static int postencoding = 0;
    static long encodingTime = 0;
	static long decodingTime = 0;
	static double ratio = 0;
    public static void main(String[] args) throws FileNotFoundException{
        String s = readFile();
        preencoding = s.length();
        buildHuffmanTree(s);
    }
    public static String readFile()throws FileNotFoundException{
        File file = new File("input1.txt");
        Scanner sc = new Scanner(file); 
        StringBuilder sb = new StringBuilder(); 

        while(sc.hasNext()){
            sb.append(sc.nextLine());
        }
        String s = sb.toString();
        s = s.replaceAll("\\p{C}", "");
        return s;
    }
	public static void encode(Node root, String str, Map<Character, String> huffmanCode){
		if (root == null)
			return;

		// found a leaf node
		if (root.left == null && root.right == null) {
			huffmanCode.put(root.ch, str);
		}

		encode(root.left, str + '0', huffmanCode);
		encode(root.right, str + '1', huffmanCode);
    }
    
	public static int decode(Node root, int index, StringBuilder sb){
		if (root == null)
			return index;
		if (root.left == null && root.right == null){
			System.out.print(root.ch);
			return index;
		}
		index++;
		if (sb.charAt(index) == '0')
			index = decode(root.left, index, sb);
		else
			index = decode(root.right, index, sb);

		return index;
    }
    
	public static void buildHuffmanTree(String text){
		Map<Character, Integer> freq = new HashMap<>();
		for (char c: text.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.freq));

		for (var entry : freq.entrySet()) {
			pq.add(new Node(entry.getKey(), entry.getValue()));
		}

		while (pq.size() != 1){
			Node left = pq.poll();
			Node right = pq.poll();

			int sum = left.freq + right.freq;
			pq.add(new Node('\0', sum, left, right));
		}

		Node root = pq.peek();

        Map<Character, String> huffmanCode = new HashMap<>();
        long start = System.currentTimeMillis();
        encode(root, "", huffmanCode);
        long end = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (char c: text.toCharArray()) {
			sb.append(huffmanCode.get(c));
        }
        encodingTime = (end-start);
        System.out.println("Encoding : " + sb);
        
        int index = -1;
        postencoding = sb.length();
        System.out.println();
        System.out.print("Decoding: ");
        start = System.currentTimeMillis();
		while (index < sb.length() - 2) {
			index = decode(root, index, sb);
        }
        end = System.currentTimeMillis();
        decodingTime = (end-start);
        System.out.println();
        Print p = new Print(encodingTime, decodingTime, preencoding*8, postencoding); 
		p.print(p);
		ratio = (double)preencoding/(double)postencoding;
		System.out.println("Compression ratio: " + ratio);
    }
}