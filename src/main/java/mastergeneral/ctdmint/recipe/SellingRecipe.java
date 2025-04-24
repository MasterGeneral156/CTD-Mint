package mastergeneral.ctdmint.recipe;

import com.google.gson.JsonObject;
import mastergeneral.ctdmint.registry.RecipeRegistry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class SellingRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final Ingredient input;
    private final float value;

    public SellingRecipe(ResourceLocation id, Ingredient input, float value) {
        this.id = id;
        this.input = input;
        this.value = value;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        return input.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess access) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.SELLING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeRegistry.SELLING_TYPE.get();
    }

    public Ingredient getInput() {
        return input;
    }

    public float getValue() {
        return value;
    }

    public static class Serializer implements RecipeSerializer<SellingRecipe> {

        @Override
        public SellingRecipe fromJson(ResourceLocation id, JsonObject json) {
            Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "input"));
            float value = GsonHelper.getAsFloat(json, "value");
            return new SellingRecipe(id, input, value);
        }

        @Override
        public SellingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            Ingredient input = Ingredient.fromNetwork(buf);
            float value = buf.readFloat();
            return new SellingRecipe(id, input, value);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, SellingRecipe recipe) {
            recipe.getInput().toNetwork(buf);
            buf.writeFloat(recipe.getValue());
        }
    }

}

