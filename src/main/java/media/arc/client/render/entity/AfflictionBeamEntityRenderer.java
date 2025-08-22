package media.arc.client.render.entity;

import media.arc.client.AfflictClient;
import media.arc.entity.AfflictionBeamEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;


public class AfflictionBeamEntityRenderer extends EntityRenderer<AfflictionBeamEntity> {

    private final AfflictionBeamModel model;
    private static final Identifier TEXTURE = new Identifier("afflict", "textures/entity/affliction_beam.png");

    public AfflictionBeamEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new AfflictionBeamModel(context.getPart(AfflictClient.BEAM_LAYER));
    }

    @Override
    public void render(AfflictionBeamEntity entity, float entityYaw, float partialTicks,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(TEXTURE));
        model.render(matrices, vertexConsumer, light, 0, 1f, 1f, 1f, 1f);
        matrices.pop();
    }

    @Override
    public Identifier getTexture(AfflictionBeamEntity entity) {
        return TEXTURE;
    }
}




