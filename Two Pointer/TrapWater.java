
public class TrapWater {

	public int trap(int[] height){
	    int i = 0, j = height.length-1;
	    int max = 0, left = 0, right = 0;
	    while(i <= j){
	        if(height[i] < height[j]){
	            if (height[i] > left) left = height[i];
	            else max += (left - height[i]);       
	            i++;
	        } else{
	        	if (height[j] > right) right = height[j];
	        	else max += (right - height[j]);
	            j--;
	        }
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		TrapWater tw = new TrapWater();
		int[] A = {2,0,2};
//		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(tw.trap(A));
	}

}
