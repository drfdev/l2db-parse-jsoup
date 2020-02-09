package dev.drf.l2db.conf;

public final class CraftItem {
    private final int count;
    private final Resource resource;

    public CraftItem(int count, Resource resource) {
        this.count = count;
        this.resource = resource;
    }

    public int getCount() {
        return count;
    }

    public Resource getResource() {
        return resource;
    }
}
