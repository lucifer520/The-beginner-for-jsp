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
		//System.in����Ϊ�ֽ�����InputStreamReader����ת��Ϊ�ַ���
		BufferedReader buffReader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter buffWriter;
		try {
			buffWriter = new BufferedWriter(new FileWriter("D:\\new\\3.txt"));
			String input="";
			while(!(input=buffReader.readLine()).equals("quit")){
				buffWriter.write(input);
				 //newLine()����д�������ϵͳ�����Ļ����ַ�����ִ�л�����ʱ��OS��������������ֻ����ַ�  
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
