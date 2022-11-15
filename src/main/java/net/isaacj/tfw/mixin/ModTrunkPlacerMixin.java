package net.isaacj.tfw.mixin;


import com.mojang.serialization.Codec;
import net.isaacj.tfw.world.feature.tree.placer.ModBranchingTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

public class ModTrunkPlacerMixin<P extends TrunkPlacer> {

    @Mixin(TrunkPlacerType.class)
    public interface TrunkPlacerTypeInvoker {
        @Invoker("register")
        static <P extends TrunkPlacer> TrunkPlacerType<P> callRegister(String id, Codec<P> codec) {
            throw new IllegalStateException();
        }
    }
}
