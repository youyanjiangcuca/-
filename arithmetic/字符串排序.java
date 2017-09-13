package 算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import com.alibaba.fastjson.asm.Type;

public class 字符串排序 {
    public static ArrayList<Object> resultArray;
    public static Map<String, String> resultMap;
	public static void main(String[] args) {
		
		resultArray = new ArrayList<>();
		resultMap = new HashMap<String, String>();
		String content = "My father was a self-taught mandolin player.    He was one of the best string instrument players in our town. He could not read music, but if he heard a tune a few times, he could play it. When he was younger, he was a member of a small country music band. They would play at local dances and on a few occasions would play for the local radio station. He often told us how he had auditioned and earned a position in a band that featured Patsy Cline as their lead singer. He told the family that after he was hired he never went back. Dad was a very religious man. He stated that there was a lot of drinking and cursing the day of his audition and he did not want to be around that type of environment.";
		content = content.replace(".", "");
		content = content.replaceAll(",", "");
		String array[] = content.split(" ");
	    int i = 0;
	    traverseArray(array);
	    System.out.println();
	    while (i < array.length) {
	    	
			System.out.print(array[i]+"  ");
			i++;
			
		}
	}
	
	static void traverseArray(String[] array)
	{
		if (array.length > 1) {
			int num = 0;
			String firstString = array[0];
			ArrayList<String> newArray = new ArrayList<>();
			
			for(int i = 0; i < array.length;i++)
			{
				if (firstString.equals(array[i])) {
					num++;
				}
				else {
					newArray.add(array[i]);
				}
			}
			
			if (resultArray.size() > 0) {
				
				String maxNum = (String)resultArray.get(1);
				
				if (num > Integer.valueOf(maxNum)) {
					
					resultArray.set(0, array[0]);
					resultArray.set(1, String.valueOf(num));
				}
				
			}
			else {
				resultArray.add(array[0]);
				resultArray.add(String.valueOf(num));
			}
			
            String transformArray[] = newArray.toArray(new String[newArray.size()]); 
			traverseArray(transformArray);
			
		}
		else 
		{
			System.out.println();
			System.out.print("用到最多的单词是:"+resultArray.get(0)+"  次数是:"+resultArray.get(1));
		}
	}
}
