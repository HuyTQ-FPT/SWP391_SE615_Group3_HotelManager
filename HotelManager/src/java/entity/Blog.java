
package entity;

public class Blog {
    private int BlogID;
	private int AccountID;
	private String BlogAuthor;
	private String BlogDescription;
	private String BlogImage;
	private String BlogDate;
	private String BlogTitleString;

    public Blog() {
    }

    public Blog(int BlogID, int AccountID, String BlogAuthor, String BlogDescription, String BlogImage, String BlogDate, String BlogTitleString) {
        this.BlogID = BlogID;
        this.AccountID = AccountID;
        this.BlogAuthor = BlogAuthor;
        this.BlogDescription = BlogDescription;
        this.BlogImage = BlogImage;
        this.BlogDate = BlogDate;
        this.BlogTitleString = BlogTitleString;
    }

    public int getBlogID() {
        return BlogID;
    }

    public void setBlogID(int BlogID) {
        this.BlogID = BlogID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getBlogAuthor() {
        return BlogAuthor;
    }

    public void setBlogAuthor(String BlogAuthor) {
        this.BlogAuthor = BlogAuthor;
    }

    public String getBlogDescription() {
        return BlogDescription;
    }

    public void setBlogDescription(String BlogDescription) {
        this.BlogDescription = BlogDescription;
    }

    public String getBlogImage() {
        return BlogImage;
    }

    public void setBlogImage(String BlogImage) {
        this.BlogImage = BlogImage;
    }

    public String getBlogDate() {
        return BlogDate;
    }

    public void setBlogDate(String BlogDate) {
        this.BlogDate = BlogDate;
    }

    public String getBlogTitleString() {
        return BlogTitleString;
    }

    public void setBlogTitleString(String BlogTitleString) {
        this.BlogTitleString = BlogTitleString;
    }

    @Override
    public String toString() {
        return "Blog{" + "BlogID=" + BlogID + ", AccountID=" + AccountID + ", BlogAuthor=" + BlogAuthor + ", BlogDescription=" + BlogDescription + ", BlogImage=" + BlogImage + ", BlogDate=" + BlogDate + ", BlogTitleString=" + BlogTitleString + '}';
    }
        
}
