package Sorting;

public class Election implements Comparable{

	private String statePost;
	private String countryName;
	private int fips;
	private int obamaVote;
	private int romneyVote;
	private double p1;
	private double p2;


	public Election(String statePost, String countryName, int fips, int obamaVote, int romneyVote){
		this.statePost = statePost;
		this.countryName = countryName;
		this.fips = fips;
		this.obamaVote = obamaVote;
		this.romneyVote = romneyVote;
		p1 = toPercent1(); p2 = toPercent2();
	}
	
	


	public String getStatePost() {
		return statePost;
	}


	public void setStatePost(String statePost) {
		this.statePost = statePost;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public int getFips() {
		return fips;
	}


	public void setFips(int fips) {
		this.fips = fips;
	}


	public double getP1() {
		return p1;
	}




	public void setP1(double p1) {
		this.p1 = p1;
	}




	public double getP2() {
		return p2;
	}




	public void setP2(double p2) {
		this.p2 = p2;
	}




	public int getObamaVote() {
		return obamaVote;
	}


	public void setObamaVote(int obamaVote) {
		this.obamaVote = obamaVote;
	}


	public int getRomneyVote() {
		return romneyVote;
	}


	public void setRomneyVote(int romneyVote) {
		this.romneyVote = romneyVote;
	}

	private double toPercent1(){
		double percent1 =0;
		if(obamaVote == 0){
			percent1 = 0;
		}else{
		percent1 = (obamaVote*1.0/(double)(obamaVote+romneyVote))*100;
		}
		return percent1;
	}
	private double toPercent2(){
		double percent2 = 0;
		if(obamaVote == 0){
			percent2 = 0;
		}else{
		percent2 = (romneyVote*1.0/(obamaVote+romneyVote))*100;
		}
		return percent2;
	}

	@Override
	public int compareTo(Object o) {
		if (this.p1 > ((Election)o).p1){
			return -1;
		}else if(this.p1 == ((Election)o).p1){
			return 0;
		}else{
			return 1;
		}
	}
	public String toString(){
		return String.format("%-42s%6d%11d%9.3f%10.3f", countryName + " (" + statePost + ")", obamaVote, romneyVote, p1, p2);
	}


}




