import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Fileoption {
	
	static String line;
	static String jsonTmp="";
	
	static void getFile(){
		File file=new File("D:\\new");
		File[] filenews=file.listFiles();
		for(int i=0;i<filenews.length;i++){
			String newsPath="D:\\new\\"+filenews[i].getName();
			
			
			try {
				BufferedReader mBufferedReader=new BufferedReader(new FileReader(newsPath));
				 line=mBufferedReader.readLine();
				 
					while(line!=null){
						jsonTmp+=line;
						line=mBufferedReader.readLine();
					}
					
					mBufferedReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(jsonTmp);
			
		}
		
		
		
	}
	
	static void writeFile(){
		//System.in输入为字节流，InputStreamReader把其转化为字符流
		BufferedReader buffReader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter buffWriter;
		try {
			buffWriter = new BufferedWriter(new FileWriter("D:\\new\\3.txt"));
			String input="";
			while(!(input=buffReader.readLine()).equals("quit")){
				buffWriter.write(input);
				 //newLine()方法写入与操作系统相依的换行字符，依执行环境当时的OS来决定该输出那种换行字符  
                buffWriter.newLine();  
			}
			buffReader.close();
			buffWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String arg[]){
		//getFile();
		writeFile();
		
		
		
		
		
		
	}

}
