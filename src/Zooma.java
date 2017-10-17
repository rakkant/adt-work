import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zooma {
	private int n,m;
	private int[] c;
	private int[] d;
	private int[] p;

	public static void main(String[] args) throws IOException {
		Zooma main = new Zooma();

		main.process();
	}

	private void process() throws IOException {
		readInput();
		FlexiArray<Integer> colorBall = new FlexiArray<Integer>(n + m);
		FlexiArray<Integer> positionBall = new FlexiArray<Integer>(n + m);

		for(int i = 0 ; i < n ; i++){
			colorBall.insert(i,c[i]);
			positionBall.insert(i, i+1);
		}

		for (int j = 0; j < m ; j++){
			int numBall = n+1+j;
			int shootPosition = p[j];
			int tempIndex = positionBall.findIndex((Integer num) -> (num == shootPosition))+1;

			if(tempIndex != 0){
				colorBall.insert(tempIndex, d[j]);
				positionBall.insert(tempIndex, numBall);

				int tempCheck = checkBalls ( colorBall, tempIndex);
				if(tempCheck >= 3){
					for (int i = 0 ; i < tempCheck ; i++){
						colorBall.remove(tempIndex);
						positionBall.remove(tempIndex);
					}
				}


			}
		}




		for(int i = 0 ; i < m+n; i++){
			if(positionBall.get(i) != null){
				System.out.println(positionBall.get(i));
			}
		}
	}


	public int checkBalls (FlexiArray<Integer> colorBall, int ballCount){
		if(colorBall.get(ballCount) != colorBall.get(ballCount+1)){
			return 1;
		}
		return checkBalls (colorBall, ballCount+1)+1;
	}


	private void readInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );

		String[] items = reader.readLine().split(" "); 
		n = Integer.parseInt(items[0]);
		m = Integer.parseInt(items[1]);

		c = new int[n];
		d = new int[m];
		p = new int[m];

		for(int i=0; i<n; i++) {
			c[i] = Integer.parseInt(reader.readLine());
		}

		for(int j=0; j<m; j++) {
			items = reader.readLine().split(" ");
			d[j] = Integer.parseInt(items[0]);
			p[j] = Integer.parseInt(items[1]);
		}
	}
}