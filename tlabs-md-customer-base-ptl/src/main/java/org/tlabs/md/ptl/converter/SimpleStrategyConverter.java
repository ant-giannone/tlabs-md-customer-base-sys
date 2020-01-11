package org.tlabs.md.ptl.converter;

import java.util.List;

public interface SimpleStrategyConverter<SOURCE, TARGET> {

    public void execute(SOURCE source, TARGET target);
    public void execute(SOURCE source, List<TARGET> target);
    public void execute(List<SOURCE> source, List<TARGET> target);
}
