
package entity;

public class Post {
    private int PostID;
	private int AccountID ;
	private String PostAuthor ;
	private String PostDescription ;
	private String PostImage;
	private String PostDate ;
	private String BlogTitle;

    public Post() {
    }

    public Post(int PostID, int AccountID, String PostAuthor, String PostDescription, String PostImage, String PostDate, String BlogTitle) {
        this.PostID = PostID;
        this.AccountID = AccountID;
        this.PostAuthor = PostAuthor;
        this.PostDescription = PostDescription;
        this.PostImage = PostImage;
        this.PostDate = PostDate;
        this.BlogTitle = BlogTitle;
    }

    @Override
    public String toString() {
        return "Post{" + "PostID=" + PostID + ", AccountID=" + AccountID + ", PostAuthor=" + PostAuthor + ", PostDescription=" + PostDescription + ", PostImage=" + PostImage + ", PostDate=" + PostDate + ", BlogTitle=" + BlogTitle + '}';
    }
        
}
