namespace java com.thesis.dataserviceprovider  // define namespace for java code

/**
 * Structs can also be exceptions, if they are nasty.
 */
exception InvalidSDQML {
  1: string why
}



service ThriftService {  // defines simple arithmetic service
            bool pushSDQML(1:string xml) throws (1:InvalidSDQML ouch),
}

