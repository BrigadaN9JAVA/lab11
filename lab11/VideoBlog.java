package lab10;

import java.util.*;

public class VideoBlog {
    private String videoBloger;
    private TreeSet<Video> videos;

    public VideoBlog(String videoBloger){
        this.videoBloger = videoBloger;
        videos = new TreeSet<>(new CompareVideo());
    }

    public String getVideoBloger() {
        return videoBloger;
    }

    public TreeSet<Video> getVideos() {
        return videos;
    }

    public void Display(){
        System.out.println("\n VideoBloger: " + videoBloger);
        for(Video video : videos){
            video.Display();
        }
    }

    public void addVideo(Video video){
        videos.add(video);
    }

}

class CompareVideo implements Comparator<Video>{

    @Override
    public int compare(Video v1, Video v2) {
        return v1.getURL().compareTo(v2.getURL());
    }
}

