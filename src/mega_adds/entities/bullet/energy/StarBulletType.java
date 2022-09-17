package mega_adds.entities.bullet.energy;

import mindustry.gen.*;
import mindustry.graphics.*;
import arc.graphics.*;
import mindustry.entities.bullet.*;
import mindustry.content.*;

public class StarBulletType extends BasicBulletType {
    public Color color = Color.valueOf("f3e979");
  public float oscScl = 1.2f, oscMag = 0.02f;
  public float flareWidth = 3f, flareInnerScl = 0.5f, flareLength = 40f, flareInnerLenScl = 0.5f, flareLayer = Layer.bullet - 0.0001f, flareRotSpeed = 1.2f;
  public Interp flareInterp = Interp.slope;
  
    public StarBulletType(float speed, float damage, Color color) {
        super(speed, damage, bulletSprite);
        homingPower = 0.08f;
        shrinkY = 0;
        width = 8;
        height = 8;
        hitSound = Sounds.spark;
        trailInterval = 0.4f;
        lifetime = 52;
    }
    
    public StarBulletType(float speed, float damage) {
        this(speed, damage, "bullet");
    }

    public StarBulletType() {
        this(1f, 1f, "bullet");
    }
    
    @Override
    public void draw(Bullet b) {
        if (b.data instanceof Position data) {
            color(color);
            Draw.z(flareLayer);

            float angle = Time.time * flareRotSpeed;
              float sin = Mathf.sin(Time.time, oscScl, oscMag);
          float mult = b.fin(flareInterp);

            for(int i = 0; i < 4; i++){
                Drawf.tri(b.x, b.y, flareWidth, flareLength * (mult + sin), i*90f + 45f + angle);
            }

            color();
            for(int i = 0; i < 4; i++){
                Drawf.tri(b.x, b.y, flareWidth * flareInnerScl, flareLength * flareInnerLenScl * (mult + sin), i*90f + 45f + angle);
            }
        }
    }
}
