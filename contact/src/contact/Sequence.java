package contact;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sequence {

	private static final String SEQ_FILE = "sequence.dat";
	private int nextNo;
	
	public Sequence() {
		// 객체 생성 시, 파일로부터 번호 불러옴
		nextNo = load();
	}
	
	// 시퀀스 파일 불러오기
	private int load() {
		File file = new File(SEQ_FILE);
		if( !file.exists() ) return 1;	// 파일이 없으면 최초 시퀀스는 1
		
		try (
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
		) {
		
			int no = (int) ois.readObject();
			return no;
		} catch(Exception e) {
			e.printStackTrace();
			return 1;
		}
		
	}
	
	// 시퀀스 파일 저장하기
	private void save() {
		try(
			FileOutputStream fos = new FileOutputStream(SEQ_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
				
		) {
			oos.writeObject(nextNo);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	// 다음 번호 가져오기
	public int nextNo() {
		int current = nextNo;
		nextNo++;
		save();
		return current;
	}
}
