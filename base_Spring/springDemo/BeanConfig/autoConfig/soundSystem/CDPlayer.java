package autoConfig.soundSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* AutoWired 自动装备
*   可以用在构造方法上、Setter方法上。
* */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        System.out.println("I am CD player ");
        cd.play();
    }
}
