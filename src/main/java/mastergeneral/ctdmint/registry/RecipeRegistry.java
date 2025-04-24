package mastergeneral.ctdmint.registry;

import mastergeneral.ctdmint.recipe.SellingRecipe;
import mastergeneral.ctdmint.recipe.SellingRecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeRegistry {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "ctdmint");
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, "ctdmint");

    public static final RegistryObject<RecipeSerializer<?>> SELLING_SERIALIZER = RECIPE_SERIALIZER.register("selling", SellingRecipe.Serializer::new);

    public static final RegistryObject<RecipeType> SELLING_TYPE = RECIPE_TYPES.register("selling", SellingRecipeType::new);
}
