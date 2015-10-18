package exercise.productDetail;

import exercise.ShoppingCart.typeAndRate.ProductType;
import junit.framework.TestCase;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShelfDetailTest extends TestCase {

    private ShelfDetail shelfDetailForDomesticExempt;
    private ShelfDetail shelfDetailForImportedTaxable;

    @Before
    public void setUp() {
        shelfDetailForDomesticExempt = new ShelfDetail(12.49, ProductType.DOMESTIC_EXEMPT);
        shelfDetailForImportedTaxable = new ShelfDetail(12.49, ProductType.IMPORTED_TAXABLE);
    }

    public void testGetPrice() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getPrice(), is(12.49));
        assertThat(shelfDetailForImportedTaxable.getPrice(), is(12.49));
    }

    public void testGetTaxRate() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getTaxRate(), is(0.00));
        assertThat(shelfDetailForImportedTaxable.getTaxRate(), is(0.150));
    }

    public void testGetTax() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getTax(), is(0.00));
        assertThat(shelfDetailForImportedTaxable.getTax(), is(1.90));
    }

    public void testGetCost() throws Exception {
        assertThat(shelfDetailForDomesticExempt.getCost(), is(12.49));
        assertThat(shelfDetailForImportedTaxable.getCost(), is(14.39));
    }
}