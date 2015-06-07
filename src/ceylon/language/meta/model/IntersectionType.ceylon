"A closed intersection type."
shared sealed interface IntersectionType<Intersection=Anything>
        satisfies Type<Intersection> {
    
    "The list of closed satisfied types of this intersection."
    shared formal List<AnyType> satisfiedTypes;
}
