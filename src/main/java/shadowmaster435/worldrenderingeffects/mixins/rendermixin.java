package shadowmaster435.worldrenderingeffects.mixins;


import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import shadowmaster435.worldrenderingeffects.client.RenderEffect;

@Mixin(WorldRenderer.class)
public class rendermixin {

    @Inject(method = "render", at = @At("HEAD"))
    public void changerendering(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f matrix4f, CallbackInfo ci) {
        if (!RenderEffect.HasActiveEffect()) {
            --RenderEffect.effectTime;
            RenderEffect.rotate(matrices);
            RenderEffect.translate(matrices);
            RenderEffect.scale(matrices);
        } else {
            RenderEffect.reset(matrices);
        }
    }
}