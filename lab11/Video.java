package lab10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Video {
    private String name;
    private String URL;
    private int viewers;
    private int likes;
    private int dislikes;
    private TreeSet<Comment> comments;

    public Video(String name, String URL, int viewers, int likes, int dislikes){
        this.name = name;
        this.URL = URL;
        this.viewers = viewers;
        this.likes = likes;
        this.dislikes = dislikes;
        comments = new TreeSet<>();
    }

    public int getViewers() {
        return viewers;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public TreeSet<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void Display(){
        System.out.println("==================================================");
        System.out.println(" Name: " + name + "\n URL: " + URL + "\n viewers - " + viewers + "; likes - " + likes + "; dislikes - " + dislikes);
        for(Comment comment: comments){
            System.out.println(comment);
        }
    }

}
