package 算法;

import java.util.ArrayList;

public class 字符串排序 {
    public static ArrayList<Object> resultArray;
    
	public static void main(String[] args) {
		
		resultArray = new ArrayList<>();
		String content = "My father was a self-taught mandolin player. He was one of the best string instrument players in our town. He could not read music, but if he heard a tune a few times, he could play it. When he was younger, he was a member of a small country music band. They would play at local dances and on a few occasions would play for the local radio station. He often told us how he had auditioned and earned a position in a band that featured Patsy Cline as their lead singer. He told the family that after he was hired he never went back. Dad was a very religious man. He stated that there was a lot of drinking and cursing the day of his audition and he did not want to be around that type of environment.";
		content = content.replace(".", "");
		content = content.replaceAll(",", "");
		String array[] = content.split(" ");
	    int i = 0;
	    while (i < array.length) {
			System.out.print(array[i]+"  ");
			i++;
			
		}
		
	}
	
	void traverseArray(String[] array)
	{
		if (array.length > 0) {
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
			//String transformArray[] =  
			//this.traverseArray(newArray);
			
		}
		else 
		{
			return;
		}
	}
}
