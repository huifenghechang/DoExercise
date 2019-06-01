package autoConfig.soundSystem;

import org.springframework.stereotype.Component;

@Component
public class SgtPepper implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    @Override
    public void play() {
        System.out.println("Playing "+ title + "By" + artist);
    }
}
