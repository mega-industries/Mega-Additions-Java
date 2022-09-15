package mega_adds.entities.bullet;

import mindustry.gen.*;
import mindustry.graphics.*;

public class SpikeBulletType extends BasicBulletType{
  public Color fromColor = Color.white.cpy();
  public Color toColor = Color.valueOf("f3e979");

    public SpikeBulletType(float speed, float damage, Color color){
        super(speed, damage, bulletSprite);
        homingPower = 0.08f;
        shrinkY = 0f;
        width = 8f;
        height = 8f;
        hitSound = Sounds.spark;
        trailInterval = 0.4;
        lifetime = 52f;
      trailRotation: true;
      trailEffect = new Effect(30f, e -> {
                               Draw.color(fromColor, toColor, e.fin());
        Drawf.tri(e.x, e.y, width * e.fout(), height * e.fout(), e.rotation);
    }),
    }
  
  @Override
    public void draw(Bullet b){
        if(b.data instanceof Position data){
            Drawf.tri(b.x, b.y, width, height, b.rotation)
        }
    }

    public SpikeBulletType(float speed, float damage){
        this(speed, damage, "bullet");
    }

    public SpikeBulletType(){
        this(1f, 1f, "bullet");
    }
}