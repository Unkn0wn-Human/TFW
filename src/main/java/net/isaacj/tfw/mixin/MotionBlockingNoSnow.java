package net.isaacj.tfw.mixin;


import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Heightmap.class)
public abstract class MotionBlockingNoSnow {


}
