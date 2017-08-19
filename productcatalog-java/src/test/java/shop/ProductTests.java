package shop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class ProductTests {

    @Test
    public void productGetName() throws Exception {
        Product product=new Product("Nombre Producto");
        assertEquals("Nombre Producto", product.getName());
    }

}
