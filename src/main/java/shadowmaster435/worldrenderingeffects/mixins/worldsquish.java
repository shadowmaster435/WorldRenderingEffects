package shadowmaster435.worldrenderingeffects.mixins;


import shadowmaster435.worldrenderingeffects.client.WorldrenderingeffectsClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class worldsquish {
    @Shadow private ClientWorld world;

    @Inject(method = "render", at = @At("HEAD"))
    public void messitallup(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f matrix4f, CallbackInfo ci) {
        float offset = (float) (Math.sin((world.getTime() + tickDelta) / 8.0) / 2.0);

        if (WorldrenderingeffectsClient.mode == 1) {
            matrices.scale( 1, 0.25f ,1f);
        } else if (WorldrenderingeffectsClient.mode == 2) {
            matrices.scale( 1.5f, 0.45f ,0.65f);
        } else if (WorldrenderingeffectsClient.mode == 3) {
            matrices.scale( 0.2f, 0.2f ,0.2f);
        } else if (WorldrenderingeffectsClient.mode == 4) {
            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(((world.getTime()) * 4)));
        } else if (WorldrenderingeffectsClient.mode == 5) {
            matrices.scale( 1f + (offset * -1) , 1f , 1f + offset);
        }  else if (WorldrenderingeffectsClient.mode == 6) {
            matrices.scale( -1f, -1f ,-1f);
        }  else if (WorldrenderingeffectsClient.mode == 7) {
            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(((world.getTime()) * offset) / 256));
        } else if (WorldrenderingeffectsClient.mode == 8) {
            matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(((world.getTime()) * 4)));
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(((world.getTime()) * 4)));
            matrices.multiply(Vector3f.NEGATIVE_Z.getDegreesQuaternion(((world.getTime()) * 4)));
        } else if (WorldrenderingeffectsClient.mode == 0) {
            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(0));
            matrices.scale(1f, 1f, 1f);
        }
    }
}