package review;

public class ReviewEntity {

	int reviewID;
	String userID;
	String menuName;
	String orderData;
	String whereOrder;
	String todayDate;
	String reviewTitle;
	String reviewContent;
	String totalScore;
	String delScore;
	String deliveryScore;
	String serviceScore;
	String packingScore;
	String chickenImage;
	String billImage;
	int likeCount;
	public int getReviewID() {
		return reviewID;
	}
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getChickenImage() {
		return chickenImage;
	}
	public void setChickenImage(String chickenImage) {
		this.chickenImage = chickenImage;
	}
	public String getBillImage() {
		return billImage;
	}
	public void setBillImage(String billImage) {
		this.billImage = billImage;
	}
	public String getOrderData() {
		return orderData;
	}
	public void setOrderData(String orderData) {
		this.orderData = orderData;
	}
	public String getWhereOrder() {
		return whereOrder;
	}
	public void setWhereOrder(String whereOrder) {
		this.whereOrder = whereOrder;
	}
	
	public String getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public String getDelScore() {
		return delScore;
	}
	public void setDelScore(String delScore) {
		this.delScore = delScore;
	}
	public String getDeliveryScore() {
		return deliveryScore;
	}
	public void setDeliveryScore(String deliveryScore) {
		this.deliveryScore = deliveryScore;
	}
	public String getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(String serviceScore) {
		this.serviceScore = serviceScore;
	}
	public String getPackingScore() {
		return packingScore;
	}
	public void setPackingScore(String packingScore) {
		this.packingScore = packingScore;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	
	public ReviewEntity(int reviewID, String userID, String menuName, String orderData, String whereOrder,
			String todayDate, String reviewTitle, String reviewContent, String totalScore,
			String delScore, String deliveryScore, String serviceScore, String packingScore, String chickenImage,
			String billImage, int likeCount) {
		super();
		this.reviewID = reviewID;
		this.userID = userID;
		this.menuName = menuName;
		this.orderData = orderData;
		this.whereOrder = whereOrder;
		this.todayDate = todayDate;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.totalScore = totalScore;
		this.delScore = delScore;
		this.deliveryScore = deliveryScore;
		this.serviceScore = serviceScore;
		this.packingScore = packingScore;
		this.chickenImage = chickenImage;
		this.billImage = billImage;
		this.likeCount = likeCount;
	}
	
	
}
