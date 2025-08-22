package media.arc.index;

import media.arc.block.InkBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AfflictBlocks {

    public static final Block INK_BLOCK = new InkBlock(AbstractBlock.Settings.of(Material.SCULK)
            .noCollision()
            .nonOpaque()
            .strength(0.2F)
            .ticksRandomly()
            .sounds(BlockSoundGroup.SCULK));

    public static void initialize() {
        Registry.register(Registry.BLOCK, new Identifier("afflict", "ink"), INK_BLOCK);
    }
}
