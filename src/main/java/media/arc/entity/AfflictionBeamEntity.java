package media.arc.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class AfflictionBeamEntity extends ProjectileEntity {

    public float rotation;
    private int lifetime; // optional, to despawn after X ticks

    public AfflictionBeamEntity(EntityType<? extends AfflictionBeamEntity> type, World world) {
        super(type, world);
        this.rotation = 0f;
        this.lifetime = 200; // example: ~10 seconds
    }

    @Override
    public void tick() {
        super.tick();

        // Rotate continuously
        this.rotation += 5f;
        if (this.rotation >= 360f) this.rotation -= 360f;

        // Optional: count down lifetime
        if (lifetime-- <= 0) {
            this.discard(); // remove entity when time is up
        }
    }

    @Override
    protected void initDataTracker() {}

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {}

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {}
}