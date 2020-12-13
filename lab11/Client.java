package lab10;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        VideoBlog Dima = new VideoBlog("Dima Tereschenko");
        Dima.addVideo(new Video("HomeVideoWithSa...", "hub.com/dimaAndS", 1000, 100, 2));
        Dima.addVideo(new Video("Sashka+Ira=❤", "hub.com/SandI", 200000, 10000, 2));
        Dima.getVideos().last().addComment(new Comment("Какие эмоции, какая страсть, просто вах", 0, 100));
        Dima.getVideos().last().addComment(new Comment("Ну такое...", 1000, 0));
        Dima.getVideos().first().addComment(new Comment("Первый комментарий", 0, 1000));
        Dima.getVideos().first().addComment(new Comment("Ах какие солнышки", 1, 1000));
        Dima.Display();
        System.out.println("\n Общие просмотры: " + getFullViewers(Dima));
        likesMore(Dima);

        System.out.println("\n Видео набравшие найбольшое количевство дизлайков:");
        List<Video> disLikesVideo = videoWithMoreDislikes(Dima);
        for(Video video:disLikesVideo){
            video.Display();
        }
    }

    static public int getFullViewers(VideoBlog videoBlog){
        int S = 0;
        for(Iterator<Video> i = videoBlog.getVideos().iterator(); i.hasNext();)
        {
            Video video = i.next();
            S += video.getViewers();
        }
        return S;
    }

    static public void likesMore(VideoBlog videoBlog){
        int likesVideo;
        boolean mayak = true;
        for(Iterator i = videoBlog.getVideos().iterator(); i.hasNext();){
            Object o = i.next();
            if (o instanceof Video){
                Video video = (Video) o;
                likesVideo = video.getLikes();
                for(Iterator j = video.getComments().iterator(); j.hasNext();){
                    Object o1 = j.next();
                    if(o1 instanceof Comment){
                        Comment comment = (Comment) o1;
                        if(comment.getLikes() > likesVideo){
                            System.out.println("\n Comment: " + comment.getText()+ "\n Under video: " + video.getName() + " has more likes than video");
                            mayak = false;
                        }
                    }
                }
            }
        }
        if(mayak){
            System.out.println("\n Comment with more likes than video not exist");
        }
    }

    static public List<Video> videoWithMoreDislikes(VideoBlog videoBlog){
        List<Video> videosDislikes = new ArrayList<>();
        int maxDislikes = 0;
        for(Video video : videoBlog.getVideos()){
            if(video.getDislikes() > maxDislikes){
                videosDislikes.clear();
                videosDislikes.add(video);
                maxDislikes = video.getDislikes();
            }
            else if(video.getDislikes()==maxDislikes && video.getDislikes()!=0){
                videosDislikes.add(video);
            }
        }
        if (maxDislikes == 0){
            videosDislikes.clear();
        }
        return videosDislikes;
    }
}
