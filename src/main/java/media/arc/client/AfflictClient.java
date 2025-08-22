package media.arc.client;

import media.arc.Afflict;
import media.arc.client.render.entity.AfflictionBeamEntityRenderer;
import media.arc.client.render.entity.AfflictionBeamModel;
import media.arc.index.AfflictEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class AfflictClient implements ClientModInitializer {

    public static final EntityModelLayer BEAM_LAYER = new EntityModelLayer(new Identifier(Afflict.MOD_ID, "affliction_beam"), "main");

    @Override
    public void onInitializeClient() {
        // Register model geometry
        EntityModelLayerRegistry.registerModelLayer(BEAM_LAYER, AfflictionBeamModel::getTexturedModelData);

        // Register renderer
        EntityRendererRegistry.register(
                AfflictEntities.AFFLICTION_BEAM,
                (context) -> new AfflictionBeamEntityRenderer(context)
        );
    }
}



