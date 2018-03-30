package net.albertoi.prototype.factory;

public interface Prototype<T extends Prototype> extends Cloneable {
    T copyClone();

    T deepClone();
}