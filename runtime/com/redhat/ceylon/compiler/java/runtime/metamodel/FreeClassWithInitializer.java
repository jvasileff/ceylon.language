package com.redhat.ceylon.compiler.java.runtime.metamodel;

import ceylon.language.Sequential;
import ceylon.language.meta.model.Class;
import ceylon.language.meta.model.ClassOrInterface;
import ceylon.language.meta.model.MemberClass;
import ceylon.language.meta.model.Type;

import com.redhat.ceylon.compiler.java.metadata.Ceylon;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;

@Ceylon(major = 8)
@com.redhat.ceylon.compiler.java.metadata.Class
public class FreeClassWithInitializer 
        extends FreeClass 
        implements ceylon.language.meta.declaration.ClassWithInitializerDeclaration {

    public FreeClassWithInitializer(com.redhat.ceylon.model.typechecker.model.Class declaration) {
        super(declaration);
    }

    @Override
    @Ignore
    public ceylon.language.meta.declaration.ClassWithInitializerDeclaration$impl 
    $ceylon$language$meta$declaration$ClassWithInitializerDeclaration$impl() {
        return new ceylon.language.meta.declaration.ClassWithInitializerDeclaration$impl(this);
    }

}
