package dev.drf.l2db.conf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recipe {
    static Recipe NONE = new Recipe();

    private List<CraftItem> items;
    private int count = 1;

    private Recipe() {
        items = Collections.emptyList();
    }

    public Recipe(List<CraftItem> items) {
        this.items = items;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<CraftItem> items;
        private int count = 1;

        public Builder() {
            items = new ArrayList<>();
        }

        public Builder addItem(int count, Resource resource) {
            items.add(new CraftItem(count, resource));
            return this;
        }

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public Recipe build() {
            return new Recipe(items);
        }
    }


}
