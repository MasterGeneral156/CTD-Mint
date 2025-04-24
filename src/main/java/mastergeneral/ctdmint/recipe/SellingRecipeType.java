package mastergeneral.ctdmint.recipe;

import net.minecraft.world.item.crafting.RecipeType;

public class SellingRecipeType implements RecipeType<SellingRecipe>
{
    @Override
    public String toString()
    {
        // Return a unique identifier for your recipe type
        return "selling";
    }
}
