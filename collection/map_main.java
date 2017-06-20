package collection;

import java.util.HashMap;
import java.util.Iterator;

public class map_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//map은 키와 벨류로 이루어짐. 리스트와 달리 인덱스가 없다. 키와 벨류는 레퍼런스형 자료가 들어간다.
		
		HashMap<Integer,String> map1 = new HashMap<Integer,String>();
		map1.put(0, "hahaha0");
		map1.put(1, "hahaha1");
		map1.put(2, "hahaha2");
		map1.put(3, "hahaha3");
		
		System.out.println(map1.get(1)); //키값을 넣어 가져온다.
		System.out.println(map1.toString());
		
		map1.remove(0); // 키값을 넣어 삭제한다.
		Iterator<Integer> iter =  map1.keySet().iterator(); //map의 keyset을 가져와서 iterator 생성하고 이를 저
		
		while(iter.hasNext()){ //hasNext() 다음 이터레이션 있으면 true 반환 
			System.out.println(map1.get(iter.next())); // iter.next() 다음 이터레이션을 가져온다.
		}
		map1.clear();
		
		
	}

}
