package net.albertoi.prototype.factory;

public interface Prototype<T extends Prototype> extends Cloneable {
    T clone();

    T deepClone();
}