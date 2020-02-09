package dev.drf.l2db.conf;

import static dev.drf.l2db.conf.Recipe.*;

public enum Resource {
    ANIMAL_BONE("Animal bone", "http://l2db.ru/items/loock/1872/c4", NONE),
    ANIMAL_SKIN("Animal Skin", "http://l2db.ru/items/loock/1867/c4", NONE),
    COAL("Coal", "http://l2db.ru/items/loock/1870/c4", NONE),
    IRON_ORE("Iron Ore", "http://l2db.ru/items/loock/1869/c4", NONE),
    STEM("Stem", "http://l2db.ru/items/loock/1663/c4", NONE),
    SUEDE("Suede", "http://l2db.ru/items/loock/1866/c4", NONE),
    THREAD("Thread", "http://l2db.ru/items/loock/1868/c4", NONE),
    VARNISH("Varnish", "http://l2db.ru/items/loock/1865/c4", NONE),
    CHARCOAL("Charcoal", "http://l2db.ru/items/loock/1871/c4", NONE),
    SILVER_NUGGET("Silver Nugget", "http://l2db.ru/items/loock/1873/c4", NONE),
    ADAMANTITE_NUGGET("Adamantite Nugget", "http://l2db.ru/items/loock/1877/c4", NONE),
    MITHRIL_ORE("Mithril Ore", "http://l2db.ru/items/loock/1876/c4", NONE),
    ORIHARUKON_ORE("Oriharukon Ore", "http://l2db.ru/items/loock/1874/c4", NONE),
    STONE_OF_PURITY("Stone of Purity", "http://l2db.ru/items/loock/1875/c4", NONE),
    ASOFE("Asofe", "http://l2db.ru/items/loock/4043/c4", NONE),
    ERNIA("Enria", "http://l2db.ru/items/loock/4042/c4", NONE),
    THRONS("Thons", "http://l2db.ru/items/loock/4044/c4", NONE),
    MOLD_GLUE("Mold Glue", "http://l2db.ru/items/loock/4039/c4", NONE),
    MOLD_HARDENER("Mold Hardener", "http://l2db.ru/items/loock/4041/c4", NONE),
    /* with craft */
    LEATHER("Leather", "http://l2db.ru/items/loock/1882/c4", Recipe.builder()
            .addItem(6, ANIMAL_SKIN)
            .build()),
    BRAIDED_HEMP("Braided Hemp", "http://l2db.ru/items/loock/1878/c4", Recipe.builder()
            .addItem(5, STEM)
            .build()),
    STEEL("Steel", "http://l2db.ru/items/loock/1880/c4", Recipe.builder()
            .addItem(5, VARNISH)
            .addItem(5, IRON_ORE)
            .build()),
    COARSE_BONE_POWDER("Coarse Bone Powder", "http://l2db.ru/items/loock/1881/c4", Recipe.builder()
            .addItem(10, ANIMAL_BONE)
            .build()),
    COKES("Cokes", "http://l2db.ru/items/loock/1879/c4", Recipe.builder()
            .addItem(3, COAL)
            .addItem(3, CHARCOAL)
            .build()),
    CORD("Cord", "http://l2db.ru/items/loock/1692/c4", Recipe.builder()
            .addItem(25, THREAD)
            .addItem(2, STEEL)
            .setCount(20)
            .build()),
    HIGH_GRADE_SUEDE("High Grade Suede", "http://l2db.ru/items/loock/1885/c4", Recipe.builder()
            .addItem(3, SUEDE)
            .addItem(1, COARSE_BONE_POWDER)
            .build()),
    COMPOUND_BRAID("Compound Braid", "http://l2db.ru/items/loock/1889/c4", Recipe.builder()
            .addItem(5, THREAD)
            .addItem(5, BRAIDED_HEMP)
            .build()),
    CRAFTED_LEATHER("Crafted Leather", "http://l2db.ru/items/loock/1894/c4", Recipe.builder()
            .addItem(4, LEATHER)
            .addItem(4, COAL)
            .addItem(4, CORD)
            .build()),
    METAL_HARDENER("Metal Hardener", "http://l2db.ru/items/loock/5220/c4", Recipe.builder()
            .addItem(10, STEM)
            .addItem(10, VARNISH)
            .addItem(10, IRON_ORE)
            .build()),
    METALLIC_FIBER("Metallic Fiber", "http://l2db.ru/items/loock/1895/c4", Recipe.builder()
            .addItem(15, SILVER_NUGGET)
            .addItem(20, CORD)
            .setCount(20)
            .build()),
    METALLIC_THREAD("Metallic Thread", "http://l2db.ru/items/loock/5549/c4", Recipe.builder()
            .addItem(10, THREAD)
            .addItem(5, IRON_ORE)
            .build()),
    DURABLE_METAL_PLATE("Durable Metal Plate", "http://l2db.ru/items/loock/5550/c4", Recipe.builder()
            .addItem(5, MITHRIL_ORE)
            .addItem(5, METALLIC_THREAD)
            .build())
    ;

    private final String name;
    private final String url;
    private final Recipe recipe;

    Resource(String name, String url, Recipe recipe) {
        this.name = name;
        this.url = url;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}
