package com.festa.hack.kurly.type;

public enum CategoryDepth {
    PARENT(1), // 상위 카테고리
    CHILD(2);  // 하위 카테고리

    private final int depth;

    CategoryDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
}
