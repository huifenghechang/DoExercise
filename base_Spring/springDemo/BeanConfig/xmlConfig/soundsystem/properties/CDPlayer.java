package xmlConfig.soundsystem.properties;
import org.springframework.beans.factory.annotation.Autowired;
import xmlConfig.soundsystem.CompactDisc;
import xmlConfig.soundsystem.MediaPlayer;


public class CDPlayer implements MediaPlayer {
  private CompactDisc compactDisc;

  @Autowired
  public void setCompactDisc(CompactDisc compactDisc) {
    this.compactDisc = compactDisc;
  }

  public void play() {
    compactDisc.play();
  }

}
