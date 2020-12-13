package lab10;

public class Comment implements Comparable<Comment> {
    private String text;
    private int dislikes;
    private int likes;

    public Comment(String text, int dislikes, int likes){
        this.text = text;
        this.dislikes = dislikes;
        this.likes = likes;
    }

    @Override
    public String toString() {
        return  "---------------------\n" + " Comment: \"" + text + '\"' +
                ", dislikes - " + dislikes +
                ", likes - " + likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }

    @Override
    public int compareTo(Comment other) {
        return this.text.compareTo(other.text);
    }
}
