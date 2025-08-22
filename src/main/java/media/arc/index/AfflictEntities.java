package media.arc.index;

import media.arc.Afflict;
import media.arc.entity.AfflictionBeamEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class AfflictEntities {

    public static final EntityType<AfflictionBeamEntity> AFFLICTION_BEAM = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Afflict.MOD_ID, "affliction_beam"),
                    FabricEntityTypeBuilder.create(
                            SpawnGroup.MISC,
                            (EntityType<AfflictionBeamEntity> type, World world) -> new AfflictionBeamEntity(type, world)// lambda matches constructor
                    )
                    .dimensions(EntityDimensions.changing(5f, 200f)) // 5x200 beam
                    .trackRangeBlocks(128) // see it from far away
                    .trackedUpdateRate(1)
                    .build()
    );

    public static void initialize() {}
}
