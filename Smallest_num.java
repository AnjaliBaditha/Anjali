package demo;

public class Smallest_num {

	public static void main(String[] args) {
		//int min=0;
		int arr[]=new int[] {45,8,23,14,14,54};
		int min=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(min>arr[i]) {
				min=arr[i];
			}
		}
System.out.println(min);
	}

}

