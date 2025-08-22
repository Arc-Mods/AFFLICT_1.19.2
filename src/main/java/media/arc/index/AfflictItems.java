package media.arc.index;

import media.arc.item.CoinItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AfflictItems {

    public static final Item COIN = register("coin", new CoinItem(new Item.Settings()));
    public static final Item STAR_CORE = register("star_core", new Item(new Item.Settings()));
    public static final Item BLADE = register("blade", new SwordItem(ToolMaterials.NETHERITE, 4, -2.7f, new Item.Settings()));
    public static final Item INK = new BlockItem(AfflictBlocks.INK_BLOCK, new Item.Settings());

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier("afflict", name), item);
    }

    public static final ItemGroup GROUP = FabricItemGroupBuilder
            .create(new Identifier("afflict", "group"))
            .icon(() -> new ItemStack(COIN))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(COIN));
                stacks.add(new ItemStack(STAR_CORE));
                stacks.add(new ItemStack(BLADE));
                stacks.add(new ItemStack(INK));
            })
            .build();

    public static void initialize(){
        Registry.register(Registry.ITEM, new Identifier("afflict", "ink"), INK);

    }
}
