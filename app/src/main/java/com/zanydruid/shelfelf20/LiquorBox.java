package com.zanydruid.shelfelf20;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by yizhu on 2/8/16.
 */
public class LiquorBox {
    private static LiquorBox sLiquorBox;
    private List<Liquor> mLiquors;

    public static LiquorBox get(Context context){
        if(sLiquorBox==null){
            sLiquorBox = new LiquorBox(context);
        }
        return sLiquorBox;
    }

    //Constructor
    public LiquorBox(Context context){
        mLiquors = new ArrayList<>();
        addLiquor(new Liquor(
                "Captain Morgan Spiced Rum",
                "Smooth and medium bodied, Captain Morgan ® Original Spiced Rum is a secret blend of" +
                        " Caribbean rums and mellow spice and other natural flavours. It gets its " +
                        "distinct richness and amber colour from aging the rum in charred white oak" +
                        " barrels. Captain Morgan ® Original Spiced Rum is the perfect mix with Cola " +
                        "–the secret recipe of spices blend with the Cola to make a legendary mix!",
                "35\u00AD37.5%",
                new String[]{"750mL", "1L", "1.75L"},
                new double[]{14.99, 27.99, 24.99}));
        addLiquor(new Liquor(
                "Bacardi Rum Superior (silver)",
                "With distinctive vanilla and almond nores which are developed in white oak barrels " +
                        "and shaped through a secret blend of charcoal for a distinctive smoothness",
                "40%",
                new String[]{"750mL", "1L", "1.75L"},
                new double[]{15.99, 18.99, 21.99}));
        addLiquor(new Liquor(
                "Sailor Jerry Spiced Rum",
                "Generally there were two ways to take the edge off rum. One was to age the liquid in " +
                        "wooden casks, which sailors rarely bothered with. The other way was to blend in " +
                        "spices. This is what most sailors did and it’s what we do. Every year, a team of " +
                        "William Grant & Sons blending specialists travel to the Caribbean to inspect distilleries " +
                        "and identify the finest rums. The ones that make the cut are blended together to create " +
                        "the ideal base for our unmatched recipe of natural spices.",
                "40%",
                new String[]{"750mL", "1L", "1.75L"},
                new double[]{21.99, 23.99, 25.99}));
        addLiquor(new Liquor(
                "Malibu Rum Original with Coconut",
                "Nothing beats an original, and Malibu is not only an original, it is the world’s " +
                        "best\u00ADselling Caribbean rum with natural coconut flavor. The taste of " +
                        "Malibu is Barbados in a bottle— smooth, fresh coconut flavor with a sweet " +
                        "finish\u00AD\u00AD\u00AD perfect for bringing the island to anytime.",
                "21%",
                new String[]{"750mL", "1L", "1.75L"},
                new double[]{18.99, 24.99, 23.99}));
        addLiquor(new Liquor(
                "Myer’s Rum Original Dark",
                "Myers’s Rum is 100% Jamaican Rum using only pure Jamaican molasses. Myers’s Rum is " +
                        "produced from continuous and pot still distillation and is then matured for " +
                        "up to four years on white oak barrels.",
                "40%",
                new String[]{"750mL", "1L", "1.75L"},
                new double[]{29.99, 37.99, 49.99}));
    }

    public void addLiquor(Liquor liquor){
        mLiquors.add(liquor);
    }

    public List<Liquor> getLiquors(){
        return mLiquors;
    }

    /**
     *
     * Get a liquor from mLiquors with an identification
     *
     * @param id    UUID, an identification of a liquor
     * @return      Liquor
     */
    public Liquor getLiquorById(UUID id){
        for(Liquor liquor:mLiquors){
            if(liquor.getLiquorId().equals(id)){
                return liquor;
            }
        }
        return null;
    }

    /**
     *
     * Get an array of liquors from mLiquors with a String query
     *
     * Walk through mLiquors, compare each elements with query,
     * if element starts with letters identical to this query, insert it into liquors
     *
     * @param query     a string where user input a search query
     * @return List     a list of liquors
     */
    public List<Liquor> getLiquorByName(String query){
        List<Liquor> liquors = new ArrayList<Liquor>();
        for(Liquor liquor:mLiquors){
            if(liquor.getName().startsWith(query)){
                liquors.add(liquor);
            }
        }
        return liquors;
    }
}
