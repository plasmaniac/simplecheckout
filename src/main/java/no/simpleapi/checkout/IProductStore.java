package no.simpleapi.checkout;

/**An implementation of this based on db store could be expected ;-) */
public interface IProductStore {
    ProductDefinition getProductDetails(String productId);
}
