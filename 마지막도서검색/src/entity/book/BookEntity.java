package entity.book;

public class BookEntity {
	private String bisbn;
	private String btitle;
	private String bdate;
	private String bpage;
	private String bauthor;
	private String btranslator;
	private String bsupplement;
	private String bpublisher;
	private String bimgurl;
	private String bimgbase64;
	private String keyword;
	private int bprice;
	
	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}


	
	public BookEntity(){
		
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBpage() {
		return bpage;
	}

	public void setBpage(String bpage) {
		this.bpage = bpage;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBtranslator() {
		return btranslator;
	}

	public void setBtranslator(String btranslator) {
		this.btranslator = btranslator;
	}

	public String getBsupplement() {
		return bsupplement;
	}

	public void setBsupplement(String bsupplement) {
		this.bsupplement = bsupplement;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}

	public String getBimgbase64() {
		return bimgbase64;
	}

	public void setBimgbase64(String bimgbase64) {
		this.bimgbase64 = bimgbase64;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
