"The singleton closed type for [[Nothing|ceylon.language::nothing]]."
shared object nothingType satisfies Type<Nothing> {
    
    string => "Nothing";
    
    typeOf(Anything instance) => false;
    
    exactly(AnyType type) => type == nothingType;
    
    supertypeOf(AnyType type) => exactly(type);
    
    subtypeOf(AnyType type) => true;
    
    shared actual Type<out Other> union<Other>(Type<out Other> type) => type;
    
    shared actual Type<Nothing> intersection<Other>(Type<out Other> type) => this;
}
