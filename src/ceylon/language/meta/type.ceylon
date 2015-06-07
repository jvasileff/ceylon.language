import ceylon.language.meta.model { ClassModel }

"Returns the closed type and model of a given instance. Since only classes
 can be instantiated, this will always be a [[ClassModel]] model."
shared native ClassModel<Type,Nothing> type<Type>(Type instance)
    given Type satisfies Anything;
