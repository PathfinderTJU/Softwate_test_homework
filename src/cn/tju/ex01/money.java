package cn.tju.ex01;

public class money {
	
	static int moneys[] = {50, 20, 10, 5, 5, 1, 1, 1};
	
	public static boolean calc(int x) {
		for (int i = 0 ; i < moneys.length ; i++) {
			if (x  == 0) {
				return true;
			}
			
			if (x - moneys[i] < 0) {
				continue;
			}else {
				x -= moneys[i];
				continue;
			}
		}
		
		if ( x == 0) {
			return true;
		}else {
			return false;
		}
	}

}
