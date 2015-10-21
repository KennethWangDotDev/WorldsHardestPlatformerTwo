package com.kenneth.whp2.actors.objects;
 
import java.util.ArrayList;
 
import com.badlogic.gdx.graphics.g2d.Batch;
import com.kenneth.whp2.Assets;
 
public class Key extends Powerups {
        private float x;
        private float y;
        public static ArrayList<Key> keyList = new ArrayList<Key>();
       
        public Key(float x, float y) {
                setWidth(32);
                setHeight(32);
                setPosition(x * 32, y * 32);
                animation = Assets.gateKey;
                animationTime = 0.1f;
                keyList.add(this);
        }
       
        public void act(float delta){
                super.act(delta);
        collision();
        }
       
        @Override
        public void draw(Batch batch, float parentAlpha) {
                super.draw(batch, parentAlpha);
        }
       
        public boolean collision() {
                 if (super.collision()) {
                         Characters.mainCharacter.setKeyCurrent(Characters.mainCharacter.getKeyCurrent() + 1);
                                return true;
                 }
                 return false;
        }
}