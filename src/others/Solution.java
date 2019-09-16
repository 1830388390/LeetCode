package others;

import java.util.Scanner;


public class Solution {
	public String isTriangle(){
		Scanner s = new Scanner(System.in);
		String read = s.nextLine();
		int a = Integer.valueOf(read);
		String read2 = s.nextLine();
		int b = Integer.valueOf(read2);
		String read3 = s.nextLine();
		int c = Integer.valueOf(read3);
		if(a <= 0 || b <= 0 || c <= 0){
			return "����Ƿ�";
		}
		if(a + b < c || a + c < b || b + c < a){
			return "����Ƿ�";
		}
		if(a == b && b == c){
			return "�ȱ�������";
		}
		if(a == b || a == c || c == b){
			return "����������";
		}
		return "һ��������";
	}
	public String getNextData(){
		Scanner s = new Scanner(System.in);
		String read = s.nextLine();
		int month = Integer.valueOf(read);
		String read2 = s.nextLine();
		int day = Integer.valueOf(read2);
		String read3 = s.nextLine();
		int year = Integer.valueOf(read3);
		
		int[] monthDays = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%4 == 0){
			monthDays[2] = 29;
		}
		if(month > 12 || month <=0 || day>monthDays[month]){
			return "����Խ��";
		}
		int newDay = day + 1;
		int newMonth = month;
		int newYear = year;
		if(newDay>monthDays[month]){
			newDay = 1;
			newMonth = month + 1;
			if(newMonth > 12){
				newYear = newYear + 1;
				newMonth = 1;
			}
		}
		return newYear + "." + newMonth + "." + newDay;
	}
	
	public static void main(String[] args){
		System.out.print(new Solution().isTriangle());
		System.out.print(new Solution().getNextData());
	}
}
