package net.wetstudios.wsmedievalglassmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wetstudios.wsmedievalglassmod.MedievalGlassMod;
import net.wetstudios.wsmedievalglassmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MedievalGlassMod.MOD_ID);

    public static final DeferredBlock<Block> CASED_GLASS_BLOCK = registerBlock("cased_glass_block",
            () ->  new TransparentBlock(
                    BlockBehaviour.Properties.of()
                            .instrument(NoteBlockInstrument.HAT)
                            .strength(0.4F)
                            .sound(SoundType.GLASS)
                            .noOcclusion()
                            .isValidSpawn(Blocks::never)
            )
    );


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    }