import ceylon.language.meta.model { AppliedType = Type }

"A closed type.
 
 A closed type is a type which is fully resolved and bound and contains no open type variables.
 All instance types are closed at runtime.
 
 You have only four sorts of types:
 
 - [[ClassOrInterface]]
 - [[UnionType]]
 - [[IntersectionType]]
 - [[nothingType]]
"
shared sealed
interface Type<Target=Anything> /* of ClassOrInterface
                                        | UnionType
                                        | IntersectionType
                                        | nothingType */ {
    
    "True if the given instance is of this type, or is of a subtype of this type."
    shared formal Boolean typeOf(Anything instance);
    
    "True if this type is a supertype of the given type, or if both types are the same."
    shared formal Boolean supertypeOf(AnyType type);
    
    "True if this type is a subtype of the given type, or if both types are the same."
    shared default Boolean subtypeOf(AnyType type) => type.supertypeOf(this);
    
    "True if the given type is a exactly this type."
    shared formal Boolean exactly(AnyType type);
    
    "The union of this type with the other type."
    shared formal Type<out Target|Other> union<Other>(Type<out Other> other);
    
    "The intersection of this type with the other type."
    shared formal Type<out Target&Other> intersection<Other>(Type<out Other> other);
}

shared alias AnyType => Type<out Anything>;