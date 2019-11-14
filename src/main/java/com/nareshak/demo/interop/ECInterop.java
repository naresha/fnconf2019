package com.nareshak.demo.interop;

import com.nareshak.demo.data.DataProvider;
import com.nareshak.demo.data.Developer;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

import java.util.List;

public class ECInterop {
    public static void main(String[] args) {
        List<Developer> developers = DataProvider.getSampleListOfDevelopers();
        MutableList<Developer> mutableList = Lists.adapt(developers);
        ImmutableList<Developer> developersImmutable = Lists.immutable.ofAll(developers);

        List<Developer> developers2 = mutableList;

        List<Developer> toMutable = developersImmutable.toList();

    }
}
