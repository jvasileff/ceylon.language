package com.redhat.ceylon.compiler.java.runtime.metamodel;

import java.util.List;

import ceylon.language.Sequential;
import ceylon.language.empty_;
import ceylon.language.model.Type;
import ceylon.language.model.declaration.AliasDeclaration$impl;
import ceylon.language.model.declaration.AnnotatedDeclaration;
import ceylon.language.model.declaration.GenericDeclaration$impl;
import ceylon.language.model.declaration.OpenType;

import com.redhat.ceylon.compiler.java.Util;
import com.redhat.ceylon.compiler.java.metadata.Ignore;
import com.redhat.ceylon.compiler.java.metadata.Name;
import com.redhat.ceylon.compiler.java.metadata.Sequenced;
import com.redhat.ceylon.compiler.java.metadata.TypeInfo;
import com.redhat.ceylon.compiler.java.metadata.TypeParameter;
import com.redhat.ceylon.compiler.java.metadata.TypeParameters;
import com.redhat.ceylon.compiler.java.runtime.model.TypeDescriptor;
import com.redhat.ceylon.compiler.typechecker.model.ProducedReference;
import com.redhat.ceylon.compiler.typechecker.model.ProducedType;
import com.redhat.ceylon.compiler.typechecker.model.TypedDeclaration;

public class FreeAliasDeclaration extends FreeNestableDeclaration 
    implements ceylon.language.model.declaration.AliasDeclaration {

    @Ignore
    public final static TypeDescriptor $TypeDescriptor = TypeDescriptor.klass(FreeAliasDeclaration.class);

    private OpenType openType;

    private boolean initialised = false;

    private Sequential<? extends ceylon.language.model.declaration.TypeParameter> typeParameters;
    
    public FreeAliasDeclaration(com.redhat.ceylon.compiler.typechecker.model.TypeAlias declaration) {
        super(declaration);
        
        this.openType = Metamodel.getMetamodel(declaration.getType().resolveAliases());
    }

    protected final void checkInit(){
        if(!initialised ){
            synchronized(Metamodel.getLock()){
                if(!initialised){
                    init();
                    initialised = true;
                }
            }
        }
    }

    private void init() {
        com.redhat.ceylon.compiler.typechecker.model.TypeAlias declaration = (com.redhat.ceylon.compiler.typechecker.model.TypeAlias) this.declaration;
        
        this.typeParameters = Metamodel.getTypeParameters(declaration);
    }

    @Override
    @Ignore
    public AliasDeclaration$impl $ceylon$language$model$declaration$AliasDeclaration$impl() {
        return null;
    }

    @Override
    @Ignore
    public GenericDeclaration$impl $ceylon$language$model$declaration$GenericDeclaration$impl() {
        return null;
    }

    @Override
    public OpenType getOpenType() {
        return openType;
    }

    @Override
    public ceylon.language.model.declaration.TypeParameter getTypeParameterDeclaration(@Name("name") @TypeInfo("ceylon.language::String") String name) {
        return Metamodel.findDeclarationByName(getTypeParameterDeclarations(), name);
    }

    @Override
    @TypeInfo("ceylon.language::Sequential<ceylon.language.model.declaration::TypeParameter>")
    public Sequential<? extends ceylon.language.model.declaration.TypeParameter> getTypeParameterDeclarations() {
        checkInit();
        return typeParameters;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Ignore
    @Override
    public <Type> ceylon.language.model.Type<Type> apply(@Ignore TypeDescriptor $reifiedType){
        return apply($reifiedType, (Sequential)empty_.$get());
    }

    @Override
    @TypeInfo("ceylon.language.model::Type<Type>")
    @TypeParameters({
        @TypeParameter("Type"),
    })
    public <Type extends Object> ceylon.language.model.Type<Type> apply(@Ignore TypeDescriptor $reifiedType,
            @Name("typeArguments") @TypeInfo("ceylon.language::Sequential<ceylon.language.model::Type<ceylon.language::Anything>>") @Sequenced Sequential<? extends ceylon.language.model.Type<?>> typeArguments){
        if(!getToplevel())
            // FIXME: change type
            throw new RuntimeException("Cannot apply a member declaration with no container type: use memberApply");
        // FIXME
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Ignore
    @Override
    public <Container, Type extends Object>
        java.lang.Object memberApply(TypeDescriptor $reifiedContainer,
                                     TypeDescriptor $reifiedType,
                                     ceylon.language.model.Type<? extends Container> containerType){
        
        return this.<Container, Type>memberApply($reifiedContainer,
                                                 $reifiedType,
                                                 containerType,
                                                 (Sequential)empty_.$get());
    }

    @TypeInfo("ceylon.language.model::Member<Container,ceylon.language.model::Type<Type>>&ceylon.language.model::Type<Type>")
    @TypeParameters({
        @TypeParameter("Container"),
        @TypeParameter("Type"),
    })
    @Override
    public <Container, Type extends Object>
        java.lang.Object memberApply(
                @Ignore TypeDescriptor $reifiedContainer,
                @Ignore TypeDescriptor $reifiedType,
                @Name("containerType") ceylon.language.model.Type<? extends Container> containerType,
                @Name("typeArguments") @Sequenced Sequential<? extends ceylon.language.model.Type<?>> typeArguments){
        if(getToplevel())
            // FIXME: change type
            throw new RuntimeException("Cannot apply a toplevel declaration to a container type: use apply");
        // FIXME
        return null;
    }


    @Override
    public int hashCode() {
        int result = 1;
        java.lang.Object container = getContainer();
        result = 37 * result + (container == null ? 0 : container.hashCode());
        result = 37 * result + getName().hashCode();
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj == this)
            return true;
        if(obj instanceof ceylon.language.model.declaration.AliasDeclaration == false)
            return false;
        ceylon.language.model.declaration.AliasDeclaration other = (ceylon.language.model.declaration.AliasDeclaration) obj;
        if(!Util.eq(other.getContainer(), getContainer()))
            return false;
        return getName().equals(other.getName());
    }

    @Override
    public String toString() {
        return "alias "+super.toString();
    }

    @Override
    @Ignore
    public TypeDescriptor $getType() {
        return $TypeDescriptor;
    }
}
