import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.Reader;
	import java.util.Scanner;
	import java.util.StringTokenizer;


	public class Bishop {
		public static void main(String[] args){
			Scanner input = new Scanner();
			int block = input.nextInt();
			int target = input.nextInt();
			if(((block%8) + (((block-1)%16)/8))%2 != ((target%8) + (((target-1)%16)/8))%2){
				System.out.println(-1);
			}
			else{
				if(block == target){
					System.out.println(0);
				}
				else{
				if(block%7 == target%7 || block%9 == target% 9){
					System.out.println(1);
				}
				else{
					System.out.println(2);
				}
				}
			}
		}
		public static class Scanner {
	        BufferedReader br;
	        StringTokenizer st;

	        public Scanner(Reader in) {
	            br = new BufferedReader(in);
	        }

	        public Scanner() { this(new InputStreamReader(System.in)); }

	        String next() {
	            while (st == null || !st.hasMoreElements()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }

	        int nextInt() { return Integer.parseInt(next()); }
	        long nextLong() { return Long.parseLong(next()); }
	        double nextDouble() { return Double.parseDouble(next()); }

	        // Slightly different from java.util.Scanner.nextLine(),
	        // which returns any remaining characters in current line,
	        // if any.  
	        String readNextLine() {
	            String str = "";
	            try {
	                str = br.readLine();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return str;
	        }
	    }
	}
