package dev.arc.index;

import dev.arc.item.CoinItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AfflictItems {

    public static final Item COIN = register("coin", new CoinItem(new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier("afflict", name), item);
    }

    public static final ItemGroup GROUP = FabricItemGroupBuilder
            .create(new Identifier("afflict", "group"))
            .icon(() -> new ItemStack(COIN))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(COIN));
            })
            .build();

    public static void initialize(){

    }
}
