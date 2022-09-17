package mega_adds.entities.bullet.energy;

import mindustry.gen.*;
import mindustry.graphics.*;
import arc.graphics.*;
import mindustry.entities.bullet.*;
import mindustry.content.*;

public class EnergySpikeBulletType extends BasicBulletType {
    public Color fromColor = Color.white.cpy();
    public Color toColor = Color.valueOf("f3e979");
    public static final Effect defaultFx = new Effect(30f, e -> {
        Draw.color(fromColor, toColor, e.fin());
        Drawf.tri(e.x, e.y, width * e.fout(), height * e.fout(), e.rotation);
    });
    public EnergySpikeBulletType(float speed, float damage, Color color) {
        super(speed, damage, bulletSprite);
        homingPower = 0.08f;
        shrinkY = 0;
        width = 8;
        height = 8;
        hitSound = Sounds.spark;
        trailInterval = 0.4f;
        lifetime = 52;
        trailRotation = true;
        trailEffect = defaultFx;
    }
    
    public EnergySpikeBulletType(float speed, float damage) {
        this(speed, damage, "bullet");
    }

    public EnergySpikeBulletType() {
        this(1f, 1f, "bullet");
    }
    
    @Override
    public void draw(Bullet b) {
        if (b.data instanceof Position data) {
            Drawf.tri(b.x, b.y, width, height, b.rotation);
        }
    }
}
